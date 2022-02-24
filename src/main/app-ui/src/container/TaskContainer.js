import { useState, useEffect } from "react";
import Task from "../component/Task";
import { loadTasks } from "../api/service/taskService";
import { submitSolution } from "../api/service/submissionService";

const emptyResultObject = {
  resultMessage: "",
  success: false,
};

const TaskContainer = () => {
  const [tasks, setTasks] = useState([]);
  const [submissionResult, setSubmissionResult] = useState(emptyResultObject);

  const initTasks = () => {
    loadTasks().then((res) => {
      setTasks(res.data);
    });
  };

  const onTaskChange = () => {
    setSubmissionResult(emptyResultObject);
  };

  useEffect(() => {
    initTasks();
  }, []);

  const onSubmit = (solution) => {
    // TODO validate
    submitSolution(solution)
      .then((res) => {
        setSubmissionResult(res.data);
      })
      .catch((err) => console.log("error caught " + err));
  };

  return (
    <Task
      tasks={tasks}
      onSubmit={onSubmit}
      submissionResult={submissionResult}
      onTaskChange={onTaskChange}
    />
  );
};

export default TaskContainer;

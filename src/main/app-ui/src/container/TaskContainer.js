import { useState, useEffect } from "react";
import { useSnackbar } from "notistack";
import Task from "../component/Task";
import { loadTasks } from "../api/service/taskService";
import { submitSolution } from "../api/service/submissionService";

const emptyResultObject = {
  resultMessage: "",
  success: false,
};

const TaskContainer = ({ loading, setLoading }) => {
  const [tasks, setTasks] = useState([]);
  const [submissionResult, setSubmissionResult] = useState(emptyResultObject);
  const { enqueueSnackbar } = useSnackbar();

  const initTasks = () => {
    setLoading(true);
    loadTasks()
      .then((res) => {
        setTasks(res.data);
      })
      .catch((err) =>
        enqueueSnackbar("Data load failure", {
          variant: "error",
        })
      )
      .finally(() => {
        setLoading(false);
      });
  };

  const onTaskChange = () => {
    setSubmissionResult(emptyResultObject);
  };

  useEffect(() => {
    initTasks();
  }, []);

  const onSubmit = (solution) => {
    setLoading(true);
    submitSolution(solution)
      .then((res) => {
        setSubmissionResult(res.data);
        if (res.data.success) {
          enqueueSnackbar("Solution is succesfully submitted!", {
            variant: "success",
          });
        } else {
          enqueueSnackbar("Invalid Submission!", {
            variant: "error",
          });
        }
      })
      .catch((err) =>
        enqueueSnackbar(err.response.data, {
          variant: "error",
        })
      )
      .finally(() => {
        setLoading(false);
      });
  };

  return (
    <Task
      tasks={tasks}
      onSubmit={onSubmit}
      submissionResult={submissionResult}
      onTaskChange={onTaskChange}
      isLoading={loading}
    />
  );
};

export default TaskContainer;

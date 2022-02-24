import Button from "@material-ui/core/Button";
import FormControl from "@material-ui/core/FormControl";
import Grid from "@material-ui/core/Grid";
import InputLabel from "@material-ui/core/InputLabel";
import Paper from "@material-ui/core/Paper";
import Select from "@material-ui/core/Select";
import { makeStyles } from "@material-ui/core/styles";
import TextField from "@material-ui/core/TextField";
import { useState } from "react";

const useStyles = makeStyles((theme) => ({
  root: {
    flexGrow: 1,
  },
  paper: {
    padding: theme.spacing(1),
    color: theme.palette.text.secondary,
    height: "620px",
  },
  field: {
    width: "100%",
    marginTop: 15,
  },
}));

const Task = ({ tasks, onSubmit, submissionResult, onTaskChange }) => {
  const classes = useStyles();

  const [solution, setSolution] = useState({});
  const [description, setDescription] = useState("");

  const onValueChange = (e) => {
    setSolution({ ...solution, [e.target.name]: e.target.value });

    if (e.target.name === "taskId") {
      setDescription(getTaskDescription(e.target.value));
      onTaskChange();
    }
  };

  const getTaskOption = (task) => {
    return (
      <option key={task.id} value={task.id}>
        {task.name}
      </option>
    );
  };

  const getTaskDescription = (taskId) => {
    if (tasks && taskId && taskId > 0) {
      const task = tasks.find((t) => t.id == taskId);
      return task ? task.description : "";
    }
    return "";
  };

  return (
    <div className={classes.root}>
      <Grid container spacing={1}>
        <Grid container item xs={12} spacing={3}>
          <Grid item xs={5}>
            <Paper className={classes.paper}>
              <TextField
                className={classes.field}
                variant="outlined"
                name="userName"
                label="Name"
                value={solution.userName}
                onChange={onValueChange}
              />
              <FormControl variant="outlined" className={classes.field}>
                <InputLabel htmlFor="taskSelect">Select Task</InputLabel>
                <Select
                  native
                  value={solution.taskId ? solution.taskId : ""}
                  onChange={onValueChange}
                  label="Select Task"
                  inputProps={{
                    name: "taskId",
                    id: "taskSelect",
                  }}
                >
                  <option aria-label="None" value="" />
                  {tasks.map((task) => getTaskOption(task))}
                </Select>
              </FormControl>
              <TextField
                name="description"
                className={classes.field}
                label="Description"
                multiline
                rows={20}
                variant="outlined"
                value={description}
                disabled
              />
            </Paper>
          </Grid>
          <Grid item xs={7}>
            <Paper className={classes.paper}>
              <TextField
                name="input"
                className={classes.field}
                label="Solution Code in Java"
                multiline
                rows={15}
                variant="outlined"
                value={solution.input}
                onChange={onValueChange}
              />
              <TextField
                name="output"
                className={classes.field}
                label="Output"
                multiline
                rows={8}
                variant="outlined"
                value={submissionResult.resultMessage}
                disabled
              />
              <Button
                className={classes.field}
                variant="contained"
                color="primary"
                onClick={() => onSubmit(solution)}
                disabled={submissionResult.success}
              >
                Submit
              </Button>
            </Paper>
          </Grid>
        </Grid>
      </Grid>
    </div>
  );
};

export default Task;

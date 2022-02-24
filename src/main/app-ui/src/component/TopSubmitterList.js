import Grid from "@material-ui/core/Grid";
import Paper from "@material-ui/core/Paper";
import Table from "@material-ui/core/Table";
import TableBody from "@material-ui/core/TableBody";
import TableCell from "@material-ui/core/TableCell";
import TableContainer from "@material-ui/core/TableContainer";
import TableHead from "@material-ui/core/TableHead";
import TableRow from "@material-ui/core/TableRow";
import { makeStyles } from "@material-ui/core/styles";

const useStyles = makeStyles((theme) => ({
  root: {
    flexGrow: 1,
  },
  table: {
    width: "100%",
    padding: theme.spacing(1),
    color: theme.palette.text.secondary,
    height: "620px",
  },
}));

const getTaskNames = (tasks) => {
  let result = "";
  tasks.map((task) => (result += task.name + "; "));
  return result;
};

const TopSubmitterList = ({ rows }) => {
  const classes = useStyles();
  return (
    <div className={classes.root}>
      <Grid container spacing={1}>
        <TableContainer className={classes.table} component={Paper}>
          <Table>
            <TableHead>
              <TableRow>
                <TableCell>Name</TableCell>
                <TableCell>Success Solutions</TableCell>
                <TableCell>Tasks</TableCell>
              </TableRow>
            </TableHead>
            <TableBody>
              {rows.map((row) => (
                <TableRow key={row.userName}>
                  <TableCell>{row.userName}</TableCell>
                  <TableCell>{row.count}</TableCell>
                  <TableCell component="th" scope="row">
                    {getTaskNames(row.tasks)}
                  </TableCell>
                </TableRow>
              ))}
            </TableBody>
          </Table>
        </TableContainer>
      </Grid>
    </div>
  );
};

export default TopSubmitterList;

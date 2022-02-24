import { SnackbarProvider } from "notistack";
import { makeStyles } from "@material-ui/core";

const useStyles = makeStyles(() => ({
  root: {
    marginBottom: "5px",
  },
}));

const SnackBar = ({ children }) => {
  const classes = useStyles();
  return (
    <SnackbarProvider
      className={classes.root}
      maxSnack={3}
      anchorOrigin={{ vertical: "bottom", horizontal: "left" }}
      autoHideDuration={2000}
    >
      {children}
    </SnackbarProvider>
  );
};

export default SnackBar;

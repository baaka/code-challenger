import AppBar from "@material-ui/core/AppBar";
import Button from "@material-ui/core/Button";
import CssBaseline from "@material-ui/core/CssBaseline";
import { makeStyles } from "@material-ui/core/styles";
import Toolbar from "@material-ui/core/Toolbar";
import Typography from "@material-ui/core/Typography";
import { withRouter } from "react-router-dom";

const useStyles = makeStyles(() => ({
  title: {
    flexGrow: 1,
  },
  opened: {
    color: "red",
  },
}));

const Header = ({ title, menuItems, history }) => {
  const classes = useStyles();

  const redirectRo = (routeName) => {
    history.push(routeName);
  };

  const getButtonClassnameByPathName = (pathName) => {
    return history.location.pathname === pathName ? classes.opened : "";
  };

  const getMenuButton = (title, path, key) => {
    return (
      <Button
        key={key}
        className={getButtonClassnameByPathName(path)}
        color="inherit"
        onClick={() => redirectRo(path)}
      >
        {title}
      </Button>
    );
  };

  return (
    <>
      <CssBaseline />
      <AppBar>
        <Toolbar>
          <Typography variant="h6" className={classes.title}>
            {title}
          </Typography>
          {menuItems.map((menuItem, index) =>
            getMenuButton(menuItem.title, menuItem.path, `menuItem_${index}`)
          )}
        </Toolbar>
      </AppBar>
      <Toolbar />
    </>
  );
};

export default withRouter(Header);

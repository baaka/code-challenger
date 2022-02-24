import Container from "@material-ui/core/Container";
import {
  BrowserRouter as Router,
  Redirect,
  Route,
  Switch,
} from "react-router-dom";
import Header from "./component/Header";
import TaskContainer from "./container/TaskContainer";
import TopSubmittersContainer from "./container/TopSubmittersContainer";
import { appRoute } from "./util/appUtil";

const menuItems = [
  { title: "Tasks", path: appRoute.task },
  { title: "Top 3", path: appRoute.topUsers },
];

function App() {
  return (
    <div style={{ padding: 10 }}>
      <Router>
        <Header title="Code Challenger" menuItems={menuItems} />
        <Container>
          <Switch>
            <Route path={appRoute.task} render={() => <TaskContainer />} />
            <Route
              path={appRoute.topUsers}
              render={() => <TopSubmittersContainer />}
            />
            <Redirect to={appRoute.task} />
          </Switch>
        </Container>
      </Router>
    </div>
  );
}

export default App;

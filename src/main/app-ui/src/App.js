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
import SnackBar from "./component/common/SnackBar";
import { useState } from "react";

const menuItems = [
  { title: "Tasks", path: appRoute.task },
  { title: "Top 3", path: appRoute.topUsers },
];

function App() {
  const [loading, setLoading] = useState(true);

  return (
    <div style={{ padding: 10 }}>
      <Router>
        <Header
          title="Code Challenger"
          menuItems={menuItems}
          isLoading={loading}
        />
        <SnackBar>
          <Container>
            <Switch>
              <Route
                path={appRoute.task}
                render={() => (
                  <TaskContainer loading={loading} setLoading={setLoading} />
                )}
              />
              <Route
                path={appRoute.topUsers}
                render={() => (
                  <TopSubmittersContainer
                    loading={loading}
                    setLoading={setLoading}
                  />
                )}
              />
              <Redirect to={appRoute.task} />
            </Switch>
          </Container>
        </SnackBar>
      </Router>
    </div>
  );
}

export default App;

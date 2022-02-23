import {
  BrowserRouter as Router,
  Redirect,
  Route,
  Switch,
} from "react-router-dom";
import Challenge from "./component/Challenge";
import TopUserList from "./component/TopUserList";
import Container from "@material-ui/core/Container";
import Header from "./component/Header";
import { appRoute } from "./util/appUtil";

const menuItems = [
  { title: "Challenge", path: appRoute.challenge },
  { title: "Top 3", path: appRoute.topUsers },
];

function App() {
  return (
    <div style={{ padding: 10 }}>
      <Router>
        <Header title="Code Challenger" menuItems={menuItems} />
        <Container>
          <Switch>
            <Route path={appRoute.challenge} render={() => <Challenge />} />
            <Route path={appRoute.topUsers} render={() => <TopUserList />} />
            <Redirect to={appRoute.challenge} />
          </Switch>
        </Container>
      </Router>
    </div>
  );
}

export default App;

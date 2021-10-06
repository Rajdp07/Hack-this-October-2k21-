import logo from './logo.svg';
import './App.css';

import ListProfileComponent from './components/ListOfProfileComponent';
import HeaderComponent from './components/HeaderComponent'
import FooterComponent from './components/FooterComponent'
import CreateProfileComponent from './components/CreateProfileComponent';
import UpdateProfileComponent from './components/UpdateProfileComponent';
import ListOfOrderComponent from './components/ListOfOrderComponent';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import EnrichOrderComponent from './components/EnrichOrderComponent';


function App() {
  return (
    <div>
      <Router>

        <HeaderComponent />
        <div className="container">
          <Switch>
            <Route path="/" exact component={ListProfileComponent}></Route>
            <Route path="/profile" component={ListProfileComponent}></Route>
            <Route path="/addprofile" component={CreateProfileComponent}></Route>
            <Route path="/updateprofile/:profileId" component={UpdateProfileComponent}></Route>
            <Route path="/enrichorder" component={EnrichOrderComponent}></Route>
            <Route path="/orders" component={ListOfOrderComponent}></Route>

          </Switch>


        </div>

        <FooterComponent />

      </Router>
    </div>

  );
}

export default App;

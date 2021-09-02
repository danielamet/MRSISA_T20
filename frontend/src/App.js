import logo from './logo.svg';
import './App.css';
import { BrowserRouter as Router, Route, Switch} from 'react-router-dom';
import Navbar from './components/Navbar';
import Home from './components/Home';
import AddMedicine from './components/AddMedicineComponent';
import AddPharmacy from './components/AddPharmacyComponent';

function App() {
  return (
    <Router>
      <div className="App">
        <Navbar />
        <div className="content">
          <Switch>
            <Route exact path="/">
              <Home/>
            </Route>
            <Route path="/addMed">
              <AddMedicine/>
            </Route>
            <Route path="/addPharmacy">
              <AddPharmacy/>
            </Route>
          </Switch>
        </div>
      </div>
    </Router>
  );
}

export default App;

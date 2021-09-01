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
            <Route path="/">
              <Home/>
            </Route>
          </Switch>
        </div>
        {/* <AddMedicine/> */}
        {/* <AddPharmacy/> */}
      </div>
    </Router>
  );
}

export default App;

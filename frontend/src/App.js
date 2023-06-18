import React from 'react';
import {BrowserRouter as Router, Routes, Route} from 'react-router-dom';
import SignupForm from './pages/signup';
import LoginForm from './pages/login';
import Home from './pages/home';

function App() {
  return (
    <div className="App">
      <Router>
          <Routes>
            <Route path='/signup' Component={SignupForm}/>
            <Route path='/login' Component={LoginForm}/>
            <Route path='/' Component={Home}/>
          </Routes>
      </Router>
    </div>
  );
}

export default App;

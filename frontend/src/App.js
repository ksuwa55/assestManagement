import React from 'react';
import {BrowserRouter as Router, Routes, Route, Navigate} from 'react-router-dom';
import SignupForm from './pages/signup';
import LoginForm from './pages/login';
import Home from './pages/home';
import 'bootstrap/dist/css/bootstrap.min.css';

function App() {
  
  const isLoggedIn = localStorage.getItem('authentificated'); // Replace with the auth logic

  return (
    <div className="App">
      <Router>
          <Routes>
            <Route path='/signup' Component={SignupForm}/>
            <Route path='/login' Component={LoginForm}/>
            <Route path='/' 
            element={isLoggedIn ? <Home />: <Navigate to={"/login"} replace/>}
            />
          </Routes>
      </Router>
    </div>
  );
}

export default App;

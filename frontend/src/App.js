import React from 'react';
import { BrowserRouter as Router, Routes, Route, Navigate } from 'react-router-dom';
import SignupForm from './pages/signup';
import LoginForm from './pages/login';
import Home from './pages/home';
import Search from './pages/search';
import Portfolio from './pages/portfolio';

import 'bootstrap/dist/css/bootstrap.min.css';

const App = () => {
  const isLoggedIn = localStorage.getItem('authenticated');

  return (
    <div className="App">
      <Router>
        <Routes>
          <Route path="/signup" element={<SignupForm />} />
          <Route path="/login" element={<LoginForm />} />
          <Route path="/search" element={<Search />} />
          <Route path="/portfolio" element={<Portfolio />} />

          <Route
            path="/"
            element={
              isLoggedIn ? (
                <Home />
              ) : (
                <Navigate to="/login" replace />
              )
            }
          />
        </Routes>
      </Router>
    </div>
  );
};

export default App;

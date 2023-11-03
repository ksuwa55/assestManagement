import React from 'react';
import { BrowserRouter as Router, Routes, Route, Navigate } from 'react-router-dom';
import SignupForm from './pages/signup';
import LoginForm from './pages/login';
import Home from './pages/home';
import Search from './pages/search';
import Portfolio from './pages/portfolio';
import { AuthProvider, useAuth } from './provider/AuthProvider';

import 'bootstrap/dist/css/bootstrap.min.css';

const App = () => {
  return (
    <div className="App">
      <AuthProvider>
        <Router>
          <Routes>
            <Route path="/signup" element={<SignupForm />} />
            <Route path="/login" element={<LoginForm />} />
            <Route path="/search" element={<Search />} />
            <Route path="/portfolio" element={<Portfolio />} />
            <Route
              path="/"
              element={
                <CheckAuthentication>
                  <Home />
                </CheckAuthentication>
              }
            />
          </Routes>
        </Router>
      </AuthProvider>
    </div>
  );
};

const CheckAuthentication = ({ children }) => {
  const { authenticated } = useAuth();
  return authenticated ? children : <Navigate to="/login" replace />;
};

export default App;

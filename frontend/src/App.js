import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import SignupForm from './pages/signup';
import LoginForm from './pages/login';
import Home from './pages/home';
import Search from './pages/search';
import Portfolio from './pages/portfolio';
import { AuthProvider} from './provider/AuthProvider';

import 'bootstrap/dist/css/bootstrap.min.css';

const App = () => {
  return (
    <div className="App">
      <AuthProvider>
        <Router>
          <Routes>
            <Route path="/signup" element={<SignupForm />} />
            <Route path="/login" element={<LoginForm />} />
            <Route path="/" element={<LoginForm />} />
            <Route path="/search/:username/:userid" element={<Search />} />
            <Route path="/portfolio" element={<Portfolio />} />
            <Route
              path="/home/:username/:userid"
              element={
                  <Home />
              }
            />
          </Routes>
        </Router>
      </AuthProvider>
    </div>
  );
};

export default App;

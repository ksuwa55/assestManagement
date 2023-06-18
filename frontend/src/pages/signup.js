import React, { useState } from "react";
import { useNavigate } from 'react-router-dom';
import axios from 'axios';

const  SignupForm = () => {
    const navigate = useNavigate();
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');

    const handleUsernameChange = (event) => {
        setUsername(event.target.value);
    }

    const handlePasswordChange = (event) => {
        setPassword(event.target.value);
    }

    const handleSubmit = async (event) => {
        event.preventDefault();

            try {
            // Send signup request to backend
            const response = await axios.post('/api/signup', {
              username,
              password,
            });

            setUsername('');
            setPassword('');
            // Navigate to the login page after successful signup
            navigate.push('/login');
          } catch (error) {
            console.error(error);
          }

    }

    return (
      <div className="container">
        <div className="row justify-content-center">
          <div className="col-md-6">
            <h2 className="text-center mb-4">Sign Up</h2>
            <form onSubmit={handleSubmit}>
              <div className="form-group">
                <label>Username</label>
                <input
                  type="text"
                  className="form-control"
                  placeholder="Enter username"
                  value={username}
                  onChange={handleUsernameChange}
                  required
                />
              </div>
              <div className="form-group">
                <label>Password</label>
                <input
                  type="password"
                  className="form-control"
                  placeholder="Enter password"
                  value={password}
                  onChange={handlePasswordChange}
                  required
                />
              </div>
              <button type="submit" className="btn btn-primary btn-block">
                Sign Up
              </button>
            </form>
          </div>
        </div>
      </div>
    );
  };
  
  export default SignupForm;
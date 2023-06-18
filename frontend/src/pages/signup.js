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

    const handleSubmit = async(event) => {
        event.preventDefault();

            try {
            // Send signup request to backend
            const response = await axios.post('http://localhost:8080/api/signup', {
              username,
              password,
            });

            setUsername('');
            setPassword('');
            // Navigate to the login page after successful signup
            navigate('/login');
          } catch (error) {
            console.error(error);
          }

    }


    return (
      <div className="container">
        <div className="row justify-content-center">
          <div className="col-md-6 mt-5">
            <div className="card">
              <div className="card-body">
                <h2 className="card-title text-center mb-4">Sign Up</h2>
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
                  <div className="form-group mt-3">
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
                  <div className="text-center mt-3">
                    <button type="submit" className="btn btn-primary btn-block">
                      Sign Up
                    </button>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    );
  };
  
  export default SignupForm;
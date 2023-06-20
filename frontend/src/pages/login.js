import React, { useState } from "react";
import { useNavigate } from 'react-router-dom';
import axios from 'axios';

const  LoginForm = () => {
    const navigate = useNavigate();
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [error, setError] = useState('');

    const handleUsernameChange = (event) => {
        setUsername(event.target.value);
    }

    const handlePasswordChange = (event) => {
        setPassword(event.target.value);
    }

    const handleSubmit = async (event) => {
        event.preventDefault();

            // Send login request to backend
          try {
            const response = await axios.post('http://localhost:8080/api/login', {
              username,
              password,
            });

            // Check if login was successful
            if(response.data.success) {
              // Set authentification flag in localStrage
              localStorage.setItem('authentificated', 'true');

              // Redirect to the home page
              navigate('/home');
            } else {
              setError('Invalid username or password');
            }
          }catch (error) {
              setError('An error occurred during login');
            }
    };
    

    return (
      <div className="container">
        <div className="row justify-content-center">
          <div className="col-md-6 mt-5">
            <div className="card">
              <div className="card-body">
                <h2 className="card-title text-center mb-4">Login</h2>
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
                  {error && <div className="text-center mt-3"> {error}</div>}
                    <button type="submit" className="btn btn-primary btn-block mt-3">
                      Login
                    </button>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    );
  };
  
  export default LoginForm;
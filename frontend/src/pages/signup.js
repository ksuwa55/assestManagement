import React, { useState } from "react";
import { useHistory } from 'react-router-dom';

const  SignupForm = () => {
    const history = useHistory();
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');

    const handleUsernameChange = (event) => {
        setUsername(event.target.value);
    }

    const handlePasswordChange = (event) => {
        setPassword(event.target.value);
    }

    const handleSubmit = (event) => {
        event.preventDefault();

            // TODO: Send signup request to backend

            setUsername('');
            setPassword('');
            // Navigate to the login page after successful signup
            history.push('/login');

    }

    return (
        <form onSubmit={handleSubmit}>
        <h2>Sign Up</h2>
        <input
          type="text"
          placeholder="Username"
          value={username}
          onChange={handleUsernameChange}
          required
        />
        <input
          type="password"
          placeholder="Password"
          value={password}
          onChange={handlePasswordChange}
          required
        />
        <button type="submit">Sign Up</button>
      </form>
    );
};

export default SignupForm;
import React from 'react';
import { useNavigate } from 'react-router-dom';


const Home = () => {

    const navigate = useNavigate();

    const handleLogout = () =>{
        // Remove  the auth flag from localstrage
        localStorage.removeItem('authenticated');

        // Navigate to the login page
        navigate('/login');

    }

    return (
        <div>
            <h1>Welcome to the home page</h1>
            <p>This is the home page</p>
            <button type="submit" className="btn btn-primary btn-block" onClick={handleLogout}>
                      Logout
            </button>
        </div>
        
    )
}

export default Home;
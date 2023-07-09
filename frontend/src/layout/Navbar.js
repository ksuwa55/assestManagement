import React from 'react';
import { Link } from 'react-router-dom';
import { useNavigate } from 'react-router-dom';

export default function Navbar() {
    const navigate = useNavigate();

    const handleLogout = () =>{
        // Remove  the auth flag from localstrage
        localStorage.removeItem('authenticated');

        // Navigate to the login page
        navigate('/login');
    }

  return (
    <div>
        <nav className="navbar navbar-expand-lg navbar-dark bg-primary">
        <div className="container-fluid">
            <Link className="navbar-brand" to="/">
                Your Market Info
            </Link>
            <div>
                <Link className='btn btn-outline-light me-2' to="/search" >Seach</Link>
                <Link className='btn btn-outline-light me-2' to="/portfolio">Portfolio</Link>
                <button className='btn btn-outline-light me-2' onClick={handleLogout}>Logout</button>
            </div>
        </div>
        </nav>
    </div>
  )
}

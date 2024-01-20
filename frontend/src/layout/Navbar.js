import React from 'react';
import { Link } from 'react-router-dom';
import { useNavigate } from 'react-router-dom';
import { useAuth } from '../provider/AuthProvider';
import { useParams } from 'react-router-dom';

export default function Navbar() {
    const navigate = useNavigate();
    const { logout } = useAuth();

    const handleLogout = () =>{
        logout();
        // Navigate to the login page
        navigate('/login');
    }
    
    const {username, userid} = useParams();

  return (
    <div>
        <nav className="navbar navbar-expand-lg navbar-dark bg-primary">
        <div className="container-fluid">
            <Link className="navbar-brand" to="/">
                Your Market Info
            </Link>
            <div>
                <Link className='btn btn-outline-light me-2' to={`/search/${username}/${userid}`} >Seach</Link>
                <Link className='btn btn-outline-light me-2' to={`/portfolio/${userid}`}>Portfolio</Link>
                <button className='btn btn-outline-light me-2' onClick={handleLogout}>Logout</button>
            </div>
        </div>
        </nav>
    </div>
  )
}

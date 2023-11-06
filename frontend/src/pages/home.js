import React from 'react';
import Navbar from '../layout/Navbar';
import Sidebar from '../layout/Sidebar';
import { useParams } from 'react-router-dom';

const Home = () => {
  const {username, userid} = useParams();
  return (
    <div className="d-flex flex-column" style={{ minHeight: '100vh' }}>
      <Navbar />
      <div className="flex-grow-1 d-flex">
        <Sidebar />
        <div className="flex-grow-1 d-flex align-items-center justify-content-center" style={{ flex: '1' }}>
          <div className="text-center">
            <h1>Hi {username} (ID: {userid})!</h1>
            <h1>Welcome to the home page</h1>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Home;

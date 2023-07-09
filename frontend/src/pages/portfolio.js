import React from 'react';
import Navbar from '../layout/Navbar';
import Sidebar from '../layout/Sidebar';

const Portfolio = () => {
  return (
    <div className="d-flex flex-column" style={{ minHeight: '100vh' }}>
      <Navbar />
      <div className="flex-grow-1 d-flex">
        <Sidebar />
        <div className="flex-grow-1 d-flex align-items-center justify-content-center" style={{ flex: '1' }}>
          <div className="text-center">
            <h1>Welcome to the Poftfolio page</h1>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Portfolio;

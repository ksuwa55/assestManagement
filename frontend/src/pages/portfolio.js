import React from 'react';
import Navbar from '../layout/Navbar';
import Sidebar from '../layout/Sidebar';

const Portfolio = () => {
  return (
    <div className="d-flex flex-column" style={{ minHeight: '100vh' }}>
      <Navbar />
      <div className="flex-grow-1 d-flex">
        <Sidebar />
        <div className="flex-grow-1 d-flex align-items-center justify-content-center p-5" style={{ flex: '1' }}>
          <table className="table table-striped table-bordered border-dark">
            <thead>
              <tr>
                <th scope="col">Name</th>
                <th scope="col">Price</th>
                <th scope="col">Market Capitalization</th>
                <th scope="col"></th>
              </tr>
            </thead>
            <tbody>
                <tr>
                  <td>AAAA</td>
                  <td>AAAA</td>
                  <td>AAAA</td>
                  <td>
                    <button type="button" className="btn btn-danger">×</button>
                  </td>
                </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  );
};

export default Portfolio;

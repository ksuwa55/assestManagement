import React, { useEffect, useState } from 'react';
import Navbar from '../layout/Navbar';
import Sidebar from '../layout/Sidebar';
import axios from 'axios';
import { useParams } from 'react-router-dom';

const Portfolio = () => {
  const [portfolio, setPortfolio] = useState([]);
  const { userid } = useParams();
  
  console.log(userid)

  useEffect(() => {
    console.log('User ID:', userid);
    handlePortfolio();
  }, [userid]);

  const handlePortfolio = () => {
    console.log('Fetching data for user ID:', userid);
    axios.get(`http://localhost:8080/api/portfolio/${userid}`)
      .then(response => {
        console.log('Response from backend:', response);
        setPortfolio(response.data);
      })
      .catch(error => {
        console.error('Error from backend:', error);
      });
  };
  

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
              {portfolio.map(stock => (
                <tr key={stock.symbol}>
                  <td>{stock.name}</td>
                  <td>{stock.price}</td>
                  <td>{stock.market_capita}</td>
                  <td>
                    <button type="button" className="btn btn-danger">×</button>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </div>
    </div>
  );
};

export default Portfolio;

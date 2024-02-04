import axios from 'axios';
import React, { useState } from 'react';
import Navbar from '../layout/Navbar';
import Sidebar from '../layout/Sidebar';
import { useParams } from 'react-router-dom';

const Search = () => {
  const [price, setPrice] = useState(0);
  const [market_capita, setMarketCapita] = useState(0);
  const [result, setResult] = useState([]);
  const { userid } = useParams();

  console.log(userid);
  const handleSearch = () => {
    axios.get(`http://localhost:8080/api/stocks?price=${price}&market_capita=${market_capita}`)
    .then(response => {
      setResult(response.data);
      // console.log(response.data)
    })
    .catch(error => {
      console.error(error);
    })
  }

  const handleSubmitStockToPortfolio = async (stockSymbol) => {
    try {
      const response = await axios.post(`http://localhost:8080/api/send-to-portfolio`, null, {
        params: {
          stockSymbol: stockSymbol.toString(),
          userId: userid,
        }
      });
    
    } catch (error) {
      console.error(error);
    }  
  };

  return (
    <div className="d-flex flex-column" style={{ minHeight: '100vh' }}>
      <Navbar />
      <div className="flex-grow-1 d-flex">
        <Sidebar />
        <div className='container'>
          <div className="row justify-content-center mt-5">
            <div className="col-md-3">
              <div className="card mb-3">
                <div className="card-body">
                  <label className="form-label text-uppercase">Price</label>
                  <input
                    type="number"
                    value={price}
                    onChange={e => setPrice(e.target.value)}
                    className="form-control mb-3"
                  />
                </div>
              </div>
            </div>
            <div className="col-md-3">
              <div className="card mb-3">
                <div className="card-body">
                  <label className="form-label text-uppercase">Market Capitalization</label>
                  <input
                    type="number"
                    value={market_capita}
                    onChange={e => setMarketCapita(e.target.value)}
                    className="form-control mb-3"
                  />
                </div>
              </div>
            </div>
          </div>
          
          <div className="row justify-content-center">
            <div className="col-md-2">
              <button type="button" onClick={handleSearch} className="btn btn-primary w-100">Search</button>
            </div>
           </div>
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
                {/* Display the result */}
                {result.map(stock => (
                  <tr key={stock.symbol}>
                    <td>{stock.name}</td>
                    <td>{stock.price}</td>
                    <td>{stock.market_capita}</td>
                    <td>
                      <button type="button" onClick={() => handleSubmitStockToPortfolio(stock.symbol)} className="btn btn-primary">+</button>
                    </td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Search;

import axios from 'axios';
import React, { useState } from 'react';
import Navbar from '../layout/Navbar';
import Sidebar from '../layout/Sidebar';

const Search = () => {
  const [price, setPrice] = useState(0);
  const [market_capita, setMarketCapita] = useState(0);
  const [result, setResult] = useState([]);

  const handleSearch = () => {
    axios.get(`http://localhost:8080/api/stocks?price=${price}&market_capita=${market_capita}`)
    .then(response => {
      setResult(response.data);
      console.log(response.data)
    })
    .catch(error => {
      console.error(error);
    })
  }
  return (
    <div className="d-flex flex-column" style={{ minHeight: '100vh' }}>
      <Navbar />
      <div className="flex-grow-1 d-flex">
        <Sidebar />
        <div className='container'>
        <div class="input-group input-group-sm mb-3">
          <div className=' m-5 '>
            <p class="text-uppercase">Price</p>
            <input type="number" value={price} onChange={e => setPrice(e.target.value)} className="form-control border-dark mb-3" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm"/>
            <button type="button" onClick={handleSearch} className="btn btn-primary">Search</button>
          </div>
          <div className=' m-5 '>
            <p class="text-uppercase">Market Capitalization</p>
            <input type="number" value={market_capita} onChange={e => setMarketCapita(e.target.value)} className="form-control border-dark mb-3" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm"/>
          </div>
        </div>
        <div className="flex-grow-1 d-flex align-items-center justify-content-center p-5" style={{ flex: '1' }}>
          <table className="table table-bordered border-dark">
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
                    <button type="button" className="btn btn-primary">+</button>
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

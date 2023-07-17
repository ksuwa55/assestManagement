import React from 'react';
import Navbar from '../layout/Navbar';
import Sidebar from '../layout/Sidebar';

const Search = () => {
  return (
    <div className="d-flex flex-column" style={{ minHeight: '100vh' }}>
      <Navbar />
      <div className="flex-grow-1 d-flex">
        <Sidebar />
        <div className='container'>
        <div class="input-group input-group-sm mb-3">
          <div className=' m-5 '>
            <p class="text-uppercase">PER</p>
            <input type="number" className="form-control border-dark mb-3" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm"/>
            <button type="button" className="btn btn-primary">Search</button>
          </div>
          <div className=' m-5 '>
            <p class="text-uppercase">PBR</p>
            <input type="number" className="form-control border-dark mb-3" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm"/>
          </div>
          <div className=' m-5 '>
            <p class="text-uppercase">ROE</p>
            <input type="number" className="form-control border-dark mb-3" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm"/>
          </div>        
        </div>
        <div className="flex-grow-1 d-flex align-items-center justify-content-center p-5" style={{ flex: '1' }}>
          <table className="table table-bordered border-dark">
            <thead>
              <tr>
                <th scope="col"></th>
                <th scope="col">Name</th>
                <th scope="col">Price</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <th scope="row"> 
                  <button type="button" className="btn btn-primary">+</button>
                </th>
                <td>Otto</td>
                <td>@mdo</td>
              </tr>
              <tr>
                <th scope="row">
                  <button type="button" className="btn btn-primary">+</button>
                </th>
                <td>Thornton</td>
                <td>@fat</td>
              </tr>
              <tr>
                <th scope="row">
                  <button type="button" className="btn btn-primary">+</button>
                </th>
                <td>Larry the Bird</td>
                <td>@twitter</td>
              </tr>
            </tbody>
          </table>
        </div>
        </div>
      </div>
    </div>
  );
};

export default Search;

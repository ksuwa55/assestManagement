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
            <input type="text" class="form-control border-dark mb-3" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm"/>
            <button type="button" class="btn btn-primary">Primary</button>
          </div>
          <div className=' m-5 '>
            <input type="text" class="form-control border-dark mb-3" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm"/>
            <button type="button" class="btn btn-primary">Primary</button>
          </div>
          <div className=' m-5 '>
            <input type="text" class="form-control border-dark mb-3" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm"/>
            <button type="button" class="btn btn-primary">Primary</button>
          </div>        
        </div>
        <div className="flex-grow-1 d-flex align-items-center justify-content-center p-5" style={{ flex: '1' }}>
          <table class="table table-bordered border-dark">
            <thead>
              <tr>
                <th scope="col">#</th>
                <th scope="col">First</th>
                <th scope="col">Last</th>
                <th scope="col">Handle</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <th scope="row">1</th>
                <td>Mark</td>
                <td>Otto</td>
                <td>@mdo</td>
              </tr>
              <tr>
                <th scope="row">2</th>
                <td>Jacob</td>
                <td>Thornton</td>
                <td>@fat</td>
              </tr>
              <tr>
                <th scope="row">3</th>
                <td>Larry the Bird</td>
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

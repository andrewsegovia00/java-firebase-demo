import React, { useState, useEffect } from 'react';
import Spinner from 'react-bootstrap/Spinner';
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';

function App() {
  const [products, setProducts] = useState([]);
  const [loading, setLoading] = useState(true); 

  useEffect(() => {

    fetch('http://localhost:8080/api/products')
      .then(response => response.json()) 
      .then(data => {
        setProducts(data);
        setLoading(false); 
      })
      .catch(error => {
        console.error('Error fetching products:', error);
        setLoading(false); 
      });
  }, []); 

  return (
    <div className="App">
    <Container>
      <Row className="justify-content-md-center">
        <Col>
          <h1>Products List</h1>
        </Col>
      </Row>
      <Row className="justify-content-md-center">
        <Col>
        <h4>
        {loading ? (
          <Spinner animation="border" variant="primary">
            <span className="visually-hidden">Loading...</span>
          </Spinner>
        ) : (
          <table>
            <thead>
              <tr>
                <th>Product Name</th>
              </tr>
            </thead>
            <tbody>
              {products.map((product, index) => (
                <tr key={index}>
                  <td>{product.name}</td>
                </tr>
              ))}
            </tbody>
          </table>
        )}
        </h4>
        </Col>
      </Row>
    </Container>
      
    </div>
  );
}

export default App;

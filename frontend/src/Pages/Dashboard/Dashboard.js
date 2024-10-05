import React, { useState, useEffect } from 'react';
import Spinner from 'react-bootstrap/Spinner';
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';

const Dashboard = () => {
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
    return  (
    <>
    <div className="App">
    <Container>
        <Row className="justify-content-md-center">
            <Col md="auto">
                <h1>Products List</h1>
            </Col>
        </Row>
        <Row className="justify-content-md-center">
            {loading ? (
            <Col md="auto" >
                <Spinner animation="border" variant="primary">
                <span className="visually-hidden">Loading...</span>
                </Spinner>
            </Col>
            ) : (
            <Col md="auto" >
                {products.map((product, index) => (
                    <h4 key={index}>
                    <span>{product.name}</span>
                    </h4>
                )
                )}
            </Col>
            )}
        </Row>
        </Container>
        </div>
    </>
    )
}
export default Dashboard;
import React, { useState, useEffect } from 'react';
import Spinner from 'react-bootstrap/Spinner';
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import Table from "react-bootstrap/Table"
import Button from "react-bootstrap/Button";

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

    const handleDelete = async (empId) => {
        try{
            fetch('http://localhost:8080/api/products/${empId}', {
            method: 'DELETE',
            });
        } catch (error) {
            console.error("Error deleting employee: ", error.message);
        }
    }

    const handleUpdate = (e) => {
        e.preventDefault();
        fetch('http://localhost:8080/api/${e.id}')

    }
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
                <Table striped bordered hover responsive>
                    <thead>
                        <tr>
                            <th>Employee Name</th>
                            <th>Employee ID</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        {products.map((product, index) => (
                        <tr key={index}>
                            <td>{product.name}</td>
                            <td>{product.number}</td>
                            <td>
                                <Button onClick={handleDelete} variant="outline-secondary">Update</Button>{" "}
                                <Button onClick={handleUpdate} variant="outline-danger">Delete</Button>
                            </td>
                        </tr>
                        )
                        )}
                    </tbody>
                </Table>
            </Col>
            )}
        </Row>
        </Container>
        </div>
    </>
    )
}
export default Dashboard;
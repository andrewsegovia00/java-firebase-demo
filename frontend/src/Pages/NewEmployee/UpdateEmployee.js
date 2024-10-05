import { useState } from 'react';
import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button"
import "./NewEmployee.css";
import { useNavigate } from "react-router-dom"
import { useEffect } from 'react';
import {  useParams } from "react-router-dom";


const UpdateEmployee = () => {
    const {id} = useParams();
    const navigate = useNavigate();

    const [formData, setFormData] = useState({
        name: '',
        number: ''   
    })

    const handleFormChange =(event) => {
        const {name, value} = event.target;
        setFormData({
            ...formData,
            [name]: value
        });
    } 

    useEffect(() =>{
        const fetchProduct = async () => {
            try{
                // console.log(id)
                const response = await fetch(`http://localhost:8080/api/products/${id}`, {
                    method: 'GET',
                    headers: {"Content-Type": "application/json"},
                });
                console.log(response)
                const data = await response.json();
                console.log(data)
                setFormData(data);
            } catch (error) {
                console.error("Error fetching product : ", error.message);
            }
        }
        fetchProduct();
    }, [id]);

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const response = await fetch(`http://localhost:8080/api/products/${id}`,
            {
                method: "PATCH",
                headers: {"Content-Type": "application/json"},
                body: JSON.stringify(formData)
            })

            const data = await response.text();
            navigate("/dashboard")
        }   catch (error) {
            console.log("Error creating employee: ", error.message)
        }
    }

    return(
    <>
        <div className="center-form">
            <h1>Update Employee</h1>
                <Form onSubmit={handleSubmit}>
                    <Form.Group controlId="formBasicName">
                        <Form.Control 
                        type="text"
                        name="name"
                        placeholder="Name of Employee"
                        value={formData.name}
                        onChange={handleFormChange}
                        />
                    </Form.Group>

                    <Form.Group controlId="formBasicName">
                        <Form.Control 
                        type="text"
                        name="number"
                        placeholder="Employee ID"
                        value={formData.number}
                        onChange={handleFormChange}
                        />
                    </Form.Group>

                    <Button variant="primary" type="submit" className="w-100">
                        Save
                    </Button>
                </Form>
        </div>
    </>
    )
}

export default UpdateEmployee;
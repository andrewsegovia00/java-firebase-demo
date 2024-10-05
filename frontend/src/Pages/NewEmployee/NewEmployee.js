import { useState } from 'react';
import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button"
import "./NewEmployee.css";

const NewEmployee = () => {

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

const handleSubmit = async (e) => {
    e.preventDefault();
    // console.log(formData);
}

    return(
    <>
        <div className="center-form">
            <h1>Add New Employee</h1>
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

export default NewEmployee;
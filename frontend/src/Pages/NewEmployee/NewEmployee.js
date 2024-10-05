import { useState } from 'react';
import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button"

const NewEmployee = () => {

    const [formData, setFormData] = useState({
        name: '',
        number: ''   
    })

const handleFormChange =(e) => {
    const (name, number) = e.target;
    setFormData{(
        ...formData,
        [name]: value,
    )}
} 

    return(
    <>
        <div className="center-form">
            <h1>Add New Employee</h1>
                <Form>
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
                        placeholder="Name of Employee"
                        value={formData.name}
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
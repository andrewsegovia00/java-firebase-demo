import Container from "react-bootstrap/esm/Container"
import Nav from "react-bootstrap/Nav";
import Navbar from "react-bootstrap/Navbar";
import { Link } from "react-router-dom"

const Navigationbar =  () => {
    
    return(
        <>
            <Navbar bg="primary" variant="dark">
                <Container>
                    <Navbar.Brand as={Link} to="/">
                        <strong>Run your Business</strong>
                    </Navbar.Brand>
                    <Nav className="ml-auto">
                        <Nav.Link as={Link} to="/dashboard" className="nav-link">Dashboard</Nav.Link>
                        <Nav.Link as={Link} to="/employee" className="nav-link">New Employee</Nav.Link>
                    </Nav>
                </Container>
            </Navbar>
        </>
        
    )
}

export default Navigationbar;
import React, { useState, useEffect } from 'react';

import Container from 'react-bootstrap/Container';
import Navbar from 'react-bootstrap/Navbar';
import Nav from 'react-bootstrap/Nav';
import NavDropdown from 'react-bootstrap/NavDropdown';
import Button from 'react-bootstrap/Button';

import { NavLink, Link, useNavigate } from 'react-router-dom';
// import tokenUtils from '../../utils/TokenUtils';

// import AuthService from '../../services/AuthService';
// import { toastSuccessMessage, toastErrorMessage } from '../../toast/toastMessages';

const NavBar = () => {
    //   const [user, setUser] = useState({ ROLE: 'NONE' });
    const navigate = useNavigate();

    useEffect(() => {
        // setUser(tokenUtils.getUser());
    }, []);


    return (
        <Navbar bg="light" expand="lg">
            <Container>
                <Navbar.Brand as={Link} to="/">Psych.io</Navbar.Brand>
                <Navbar.Toggle aria-controls="basic-navbar-nav" />
                <Navbar.Collapse id="basic-navbar-nav">
                    <Nav className="me-auto">
                    <Nav.Link as={Link} to="/register">Register</Nav.Link>
                    <Nav.Link as={Link} to="/login">Log in</Nav.Link>
                    <Nav.Link as={Link} to="/new-appointment">Start new appointment</Nav.Link>

                        <NavDropdown title="Account" id="basic-nav-dropdown">
                            <NavDropdown.Item as={Link} to="/">Log out</NavDropdown.Item>
                        </NavDropdown>
                    </Nav>
                </Navbar.Collapse>
            </Container>
        </Navbar>
    );
};

export default NavBar;

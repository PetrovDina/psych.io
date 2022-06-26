import React, { useState, useEffect } from 'react';

import Container from 'react-bootstrap/Container';
import Navbar from 'react-bootstrap/Navbar';
import Nav from 'react-bootstrap/Nav';
import NavDropdown from 'react-bootstrap/NavDropdown';

import { Link, useNavigate } from 'react-router-dom';

// import { toastSuccessMessage, toastErrorMessage } from '../../toast/toastMessages';

const NavBar = ({ loggedUser, setLoggedUser }) => {
    const navigate = useNavigate();

    const logOut = () => {
        localStorage.removeItem("LOGGED_USERNAME");
        localStorage.removeItem("LOGGED_ROLE");
        setLoggedUser({ username: "", role: "" })
        navigate("/login");
    }

    return (
        <Navbar bg="light" expand="lg">
            <Container>
                <Navbar.Brand as={Link} to="/">Psych.io</Navbar.Brand>
                <Navbar.Toggle aria-controls="basic-navbar-nav" />
                <Navbar.Collapse id="basic-navbar-nav">
                    <Nav className="me-auto">

                        {/* Guest links */}
                        {loggedUser.role === "" && (
                            <Nav.Link as={Link} to="/register">Register</Nav.Link>
                        )}
                        {loggedUser.role === "" && (
                            <Nav.Link as={Link} to="/login">Log in</Nav.Link>
                        )}

                        {/* Patient links */}
                        {loggedUser.role === "PATIENT" && (
                            <Nav.Link as={Link} to="/new-appointment">Start new appointment</Nav.Link>
                        )}
                        {loggedUser.role === "PATIENT" && (
                            <Nav.Link as={Link} to={`/patients/${loggedUser.username}`}>My examinations</Nav.Link>
                        )}

                        {/* Doctor links */}
                        {loggedUser.role === "DOCTOR" && (
                            <Nav.Link as={Link} to="/patients">My patients</Nav.Link>
                        )}
                        {loggedUser.role === "DOCTOR" && (
                            <Nav.Link as={Link} to="/symptoms">Symptom lookup</Nav.Link>
                        )}

                        {/* keep dropdown at the end */}
                        {loggedUser.role !== "" && (
                            <NavDropdown title="Account" id="basic-nav-dropdown">
                                <NavDropdown.Item as={Link} to="/login" onClick={() => logOut()}>Log out</NavDropdown.Item>
                            </NavDropdown>
                        )}

                    </Nav>
                </Navbar.Collapse>
            </Container>
        </Navbar>
    );
};

export default NavBar;

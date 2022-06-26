import React, { useState } from 'react';
import Modal from 'react-bootstrap/Modal';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import Container from 'react-bootstrap/Container';
import Table from "react-bootstrap/Table"

const StatementsModal = ({ show, statements, onClose }) => {

    return (
        <Modal show={show} onHide={onClose} centered>
            <Modal.Header closeButton>
                <Modal.Title>Statements</Modal.Title>
            </Modal.Header>
            <Modal.Body>
                <Container>
                    <Table striped bordered hover>

                        <thead>
                            <tr>
                                <td>Statement</td>
                                <td>Answer</td>
                            </tr>

                        </thead>
                        <tbody>
                            {statements.map((statement) => (
                                <tr key={statement.id}>
                                    <td>{statement.statement}</td>
                                    <td>{statement.response}</td>

                                </tr>
                            ))}
                        </tbody>
                    </Table>
                </Container>
            </Modal.Body>
            <Modal.Footer>

            </Modal.Footer>
        </Modal>
    );
};

export default StatementsModal;

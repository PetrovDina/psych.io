import React, { useState } from 'react';
import Modal from 'react-bootstrap/Modal';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import Container from 'react-bootstrap/Container';
import Table from "react-bootstrap/Table"

const SymptomsModal = ({ show, symptoms, onClose }) => {

    return (
        <Modal show={show} onHide={onClose} centered>
            <Modal.Header closeButton>
                <Modal.Title>Symptoms</Modal.Title>
            </Modal.Header>
            <Modal.Body>
                <Container>
                    <Table striped bordered hover>

                        <thead>
                            <tr>
                                <td>Symptom</td>
                                <td>Frequency</td>
                            </tr>

                        </thead>
                        <tbody>
                            {symptoms.map((symptomFrequency) => (
                                <tr key={symptomFrequency.symptom.id}>
                                    <td>{symptomFrequency.symptom.description}</td>
                                    <td>{symptomFrequency.frequency}</td>

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

export default SymptomsModal;

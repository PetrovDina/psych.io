import React, { useState } from 'react';
import Card from 'react-bootstrap/Card';
import ListGroup from 'react-bootstrap/ListGroup';
import ListGroupItem from 'react-bootstrap/ListGroupItem';
import Button from 'react-bootstrap/Button';
import Row from 'react-bootstrap/Row';
import { useNavigate } from 'react-router-dom';
import Table from "react-bootstrap/Table"
import moment from 'moment'
import StatementsModal from './StatamentsModal';
import SymptomsModal from './SymptomsModal';

const ExaminationCard = ({ examination }) => {
    const nav = useNavigate();
    const [showSymptomsModal, setshowSymptomsModal] = useState(false);
    const [showStatementsModal, setShowStatementsModal] = useState(false);


    return (

        <Card style={{ margin: '50px' }} >
            <Card.Body>
                <Card.Title style={{ fontSize: '80%' }}>Examination id: {examination.id}</Card.Title>
                {/* <Card.Img src="https://www.svgrepo.com/show/155531/test.svg" style={{ width: '40%' }} /> */}
            </Card.Body>
            <ListGroup className="list-group-flush" style={{ fontSize: '70%' }}>
                <ListGroupItem style={{ textAlign: 'left' }}>
                    <b>Date: </b> {moment(examination.date).format("DD. MMM YYYY. HH:mm")}
                </ListGroupItem>
                <ListGroupItem style={{ textAlign: 'left' }}>
                    <b>Patient height: </b> {examination.height} cm
                </ListGroupItem>
                <ListGroupItem style={{ textAlign: 'left' }}>
                    <b>Patient weight: </b> {examination.weight} kg
                </ListGroupItem>
                <ListGroupItem style={{ textAlign: 'left' }}>
                    <b>Comment: </b> {examination.comment}
                </ListGroupItem>
                <ListGroupItem style={{ textAlign: 'left' }}>
                    <Table striped bordered hover>

                        <thead>
                            <tr>
                                <td>Diagnosis ID</td>
                                <td>Diagnosis name</td>
                                <td>Probability</td>
                            </tr>

                        </thead>
                        <tbody>
                            {examination.diagnosisProbabilities.map((diagnosis) => (
                                <tr key={diagnosis.diagnosisId}>
                                    <td>{diagnosis.diagnosisId}</td>
                                    <td>{diagnosis.diagnosisName}</td>
                                    <td>{diagnosis.probability}%</td>

                                </tr>
                            ))}
                        </tbody>
                    </Table>
                </ListGroupItem>

                <ListGroupItem style={{ textAlign: 'left' }}>
                    <Table striped bordered hover>

                        <thead>
                            <tr>
                                <td>Therapy ID</td>
                                <td>Therapy name</td>
                                <td>Probability</td>
                            </tr>

                        </thead>
                        <tbody>
                            {examination.therapyProbabilities.map((therapyProbability) => (
                                <tr key={therapyProbability.therapy.id}>
                                <td>{therapyProbability.therapy.id}</td>
                                <td>{therapyProbability.therapy.name}</td>
                                <td>{therapyProbability.probability}%</td>

                            </tr>
                            ))}
                        </tbody>
                    </Table>
                </ListGroupItem>

            </ListGroup>
            <Card.Body>
                <Button variant="primary" onClick={() => setshowSymptomsModal(true)} size="sm" style={{ margin: '5px' }}>
                    See symptoms
                </Button>
                <Button variant="primary" onClick={() => setShowStatementsModal(true)} size="sm" style={{ margin: '5px' }}>
                    See statements
                </Button>
            </Card.Body>
            <StatementsModal
                show={showStatementsModal}
                statements={examination.statements}
                onClose={() => setShowStatementsModal(false)}
            />
            <SymptomsModal
                show={showSymptomsModal}
                symptoms={examination.symptoms}
                onClose={() => setshowSymptomsModal(false)}
            />
        </Card>
    );
};

export default ExaminationCard;
import React from 'react';
import Card from 'react-bootstrap/Card';
import ListGroup from 'react-bootstrap/ListGroup';
import ListGroupItem from 'react-bootstrap/ListGroupItem';
import Button from 'react-bootstrap/Button';
import Row from 'react-bootstrap/Row';
import { useNavigate } from 'react-router-dom';
import Table from "react-bootstrap/Table"
import moment from 'moment'

const ExaminationCard = ({ examination }) => {
    const nav = useNavigate();

    return (
        <Card as={Row} md="2" style={{ margin: '10px' }} className="mb-2 p-2">
            <Card.Body>
                <Card.Title style={{ fontSize: '80%' }}>Examination id: {examination.id}</Card.Title>
                {/* <Card.Img src="https://www.svgrepo.com/show/155531/test.svg" style={{ width: '40%' }} /> */}
            </Card.Body>
            <ListGroup className="list-group-flush" style={{ fontSize: '70%' }}>
                <ListGroupItem style={{ textAlign: 'left' }}>
                    <b>Date: </b> {moment(examination.date).format("DD. MMM YYYY. HH:mm")}
                </ListGroupItem>
                <ListGroupItem style={{ textAlign: 'left' }}>
                    <b>Patient height: </b> {examination.height}
                </ListGroupItem>
                <ListGroupItem style={{ textAlign: 'left' }}>
                    <b>Patient weight: </b> {examination.weight}
                </ListGroupItem>
                <ListGroupItem style={{ textAlign: 'left' }}>
                    <b>Comment: </b> {examination.comment}
                </ListGroupItem>
                <ListGroupItem style={{ textAlign: 'left' }}>
                    <Table striped bordered hover>

                        <thead>
                            <tr>
                                <td>Id</td>
                                <td>Diagnosis</td>
                                <td>Probability</td>
                            </tr>

                        </thead>
                        <tbody>
                            {examination.diagnosisProbabilities.map((diagnosis) => (
                                <tr key={diagnosis.diagnosisId}>
                                    <td>{diagnosis.diagnosisId}</td>
                                    <td>{diagnosis.diagnosisName}</td>
                                    <td>{diagnosis.probability}</td>

                                </tr>
                            ))}
                        </tbody>
                    </Table>
                </ListGroupItem>

            </ListGroup>
            <Card.Body>
                <Button variant="primary" onClick={() => {}} size="sm">
                    Examinations
                </Button>

            </Card.Body>
        </Card>
    );
};

export default ExaminationCard;
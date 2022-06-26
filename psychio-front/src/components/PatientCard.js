import React from 'react';
import Card from 'react-bootstrap/Card';
import ListGroup from 'react-bootstrap/ListGroup';
import ListGroupItem from 'react-bootstrap/ListGroupItem';
import Button from 'react-bootstrap/Button';
import Col from 'react-bootstrap/Col';


const PatientCard = ({ patient }) => {
    return (
        <Card as={Col} md="2" style={{ margin: '10px' }} className="mb-2 p-2">
            <Card.Body>
                <Card.Title style={{ fontSize: '80%' }}>{patient.username}</Card.Title>
                <Card.Img src="https://www.svgrepo.com/show/4529/user.svg" style={{ width: '60%' }} />
            </Card.Body>
            <ListGroup className="list-group-flush" style={{ fontSize: '70%' }}>
                <ListGroupItem style={{ textAlign: 'left' }}>
                    <b>First name: </b> {patient.firstName}
                </ListGroupItem>
                <ListGroupItem style={{ textAlign: 'left' }}>
                    <b>Last name: </b> {patient.lastName}
                </ListGroupItem>
                <ListGroupItem style={{ textAlign: 'left' }}>
                    <b>Gender: </b> {patient.gender}
                </ListGroupItem>
                <ListGroupItem style={{ textAlign: 'left' }}>
                    <b>Marital status: </b> {patient.maritalStatus}
                </ListGroupItem>
                <ListGroupItem style={{ textAlign: 'left' }}>
                    <b>Employment status: </b> {patient.employmentStatus}
                </ListGroupItem>

            </ListGroup>
            {/* <Card.Body>
                <Button variant="primary" onClick={() => onChangeRole(user)} size="sm">
                    Change role
                </Button>
                <Button variant="primary" onClick={() => onManageHouseholds(user)} size="sm">
                    Manage households
                </Button>
                <Button variant="danger" onClick={handleDelete} size="sm">
                    Delete
                </Button>
            </Card.Body> */}
        </Card>
    );
};

export default PatientCard;
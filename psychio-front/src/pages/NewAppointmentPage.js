import { useState, useEffect } from "react";
import SymptomService from "../services/SymptomService";
import Table from "react-bootstrap/Table"
import Form from 'react-bootstrap/Form'

const NewAppointmentPage = () => {

    const [symptoms, setSymptoms] = useState([]);
    const [height, setHeight] = useState(0);
    const [weight, setWeight] = useState(0);
    const [comment, setComment] = useState('');

    const frequencies = ["NEVER", "SOMETIMES", "OFTEN"]

    const [statementsLoaded, setStatementsLoaded] = useState(false);
    const [statements, setStatements] = useState([]);

    const statementResponses = ["STRONGLY_DISAGREE", "DISAGREE", "NA", "AGREE", "STRONGLY_AGREE"]


    useEffect(() => {
        SymptomService.getAll()
            .then((response) => {
                console.log("FETCHED SYMPTOMS")
                setSymptoms(response.map(symptom => ({ ...symptom, frequency: "NEVER" })));
            })
    }, []);

    function onFrequencyChange(symptomIndex, frequency) {
        let updatedSymptoms = [...symptoms];
        updatedSymptoms[symptomIndex].frequency = frequency;
        setSymptoms(updatedSymptoms);

    }

    function submitSymptoms() {
        let frequencies = symptoms.map(symptom => ({ symptomId: symptom.id, frequency: symptom.frequency }))
        let object = {}
        object.username = "john89"; //change to logged user lol
        object.weight = weight;
        object.height = height;
        object.comment = comment;
        object.symptoms = frequencies;
        console.log(object);

        SymptomService.submitSymptomFrequencies(object)
            .then((response) => {
                console.log(response);
                setStatements(response.statements);
                setStatementsLoaded(true);

            })
    }

    function onStatementResponseChange(statementIndex, response) {
        let updatedStatements = [...statements];
        updatedStatements[statementIndex].response = response;
        setStatements(updatedStatements);

    }

    function submitStatements() {

        console.log(statements);

        // SymptomService.submitSymptomFrequencies(statements)
        //     .then((response) => {
        //         console.log(response);
        //         setStatements(response.statements);
        //         setStatementsLoaded(true);

        //     })
    }

    return (
        <>
            {!statementsLoaded && <div style={{ margin: '50px 200px' }}>
                <h1>Start new appointment</h1>
                <div style={{ margin: '50px' }}>
                    <Form.Group className="mb-3" controlId="formBasicEmail">
                        <Form.Label>Height</Form.Label>
                        <Form.Control type="number" placeholder="Enter height in cm" value={height} onChange={(event) => setHeight(event.target.value)} />
                    </Form.Group>

                    <Form.Group className="mb-3" controlId="formBasicPassword">
                        <Form.Label>Weight</Form.Label>
                        <Form.Control type="number" placeholder="Enter current weight in kg" value={weight} onChange={(event) => setWeight(event.target.value)} />
                    </Form.Group>
                </div>


                <h3>In the last two weeks, I have experienced the following symptoms: </h3>
                <Table striped bordered hover>
                    <thead>
                        <tr>
                            <td></td>
                            <td>Never</td>
                            <td>Sometimes</td>
                            <td>Often</td>
                        </tr>
                    </thead>
                    <tbody>
                        {symptoms.map((symptom, index) =>
                            <tr key={symptom.id}>
                                <td>{symptom.description}</td>

                                {frequencies.map(frequency =>
                                    <td key={frequency}>
                                        <Form.Check
                                            name={`radioButton${symptom.id}`}
                                            type="radio"
                                            defaultChecked={symptom.frequency === frequency}
                                            onClick={(() => onFrequencyChange(index, frequency))}
                                        />
                                    </td>)}
                            </tr>
                        )}
                    </tbody>
                </Table>
                <div style={{ margin: '50px' }}>
                    <h3>Write a little bit about how you have been feeling recently</h3>
                    <textarea style={{ width: '80%', height: '300px' }} value={comment} onChange={(event) => setComment(event.target.value)}></textarea>
                </div>

                <button onClick={() => submitSymptoms()}>Submit</button>
            </div >}
            {statementsLoaded &&
                <div>
                    <h1>Statements Quiz</h1>
                    <h3>Please fill out how much you relate to the following statements: </h3>
                    <Table striped bordered hover>
                        <thead>
                            <tr>
                                <td></td>
                                <td>Strongly disagree</td>
                                <td>Disagree</td>
                                <td>No answer</td>
                                <td>Agree</td>
                                <td>Strongly agree</td>

                            </tr>
                        </thead>
                        <tbody>
                            {statements.map((statement, index) =>
                                <tr key={statement.statementId}>
                                    <td>{statement.statement}</td>

                                    {statementResponses.map(response =>
                                        <td key={response}>
                                            <Form.Check
                                                name={`radioButton${statement.statementId}`}
                                                type="radio"
                                                defaultChecked={statement.response === response}
                                                onClick={(() => onStatementResponseChange(index, response))}
                                            />
                                        </td>)}
                                </tr>
                            )}
                        </tbody>
                    </Table>
                    <button onClick={() => submitStatements()}>Submit</button>


                </div>}
        </>

    );
};

export default NewAppointmentPage;
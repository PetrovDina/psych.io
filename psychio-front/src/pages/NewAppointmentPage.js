import { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";

import SymptomService from "../services/SymptomService";
import DiagnosisService from "../services/DiagnosisService";
import SubstanceGroupService from "../services/SubstanceGroupService";

import Table from "react-bootstrap/Table";
import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";

import { toast } from "react-toastify";

const NewAppointmentPage = () => {
    const [height, setHeight] = useState(180);
    const [weight, setWeight] = useState(50);
    const [symptoms, setSymptoms] = useState([]);
    const [comment, setComment] = useState("");

    const frequencyValues = ["NEVER", "SOMETIMES", "OFTEN"];

    const [examinationId, setExaminationId] = useState(null);
    const [statementsLoaded, setStatementsLoaded] = useState(false);
    const [statements, setStatements] = useState([]);

    const [substances, setSubstances] = useState([]);

    const statementResponseValues = [
        "STRONGLY_DISAGREE",
        "DISAGREE",
        "NA",
        "AGREE",
        "STRONGLY_AGREE",
    ];

    const navigate = useNavigate();

    useEffect(() => {
        SymptomService.getAll().then((response) => {
            setSymptoms(
                response.map((symptom) => ({ ...symptom, frequency: "NEVER" }))
            );
        });

        SubstanceGroupService.getAll().then((response) => {
            setSubstances(
                response.map((substance) => ({
                    ...substance,
                    isChecked: false,
                }))
            );
        });
    }, []);

    function onFrequencyChange(symptomIndex, frequency) {
        let updatedSymptoms = [...symptoms];
        updatedSymptoms[symptomIndex].frequency = frequency;
        setSymptoms(updatedSymptoms);
    }

    function submitSymptoms() {
        if (
            !localStorage.getItem("LOGGED_USERNAME") ||
            localStorage.getItem("LOGGED_ROLE") !== "PATIENT"
        ) {
            toast.error("You must be logged in as a patient first!");
            return;
        }
        let frequencies = symptoms.map((symptom) => ({
            symptomId: symptom.id,
            frequency: symptom.frequency,
        }));
        let object = {};
        object.username = localStorage.getItem("LOGGED_USERNAME");
        object.weight = weight;
        object.height = height;
        object.comment = comment;
        object.symptoms = frequencies;
        object.substances = substances.filter((item) => item.isChecked);
        console.log(object);

        SymptomService.submitSymptomFrequencies(object).then((response) => {
            console.log(response);
            if (response.disorderGroupProbabilities.length === 0) {
                toast.error(
                    "You can not start more than one examination in the same day."
                );
                return;
            }
            setExaminationId(response.id);
            setStatements(response.statements);
            setStatementsLoaded(true);
        });
    }

    function onStatementResponseChange(statementIndex, response) {
        let updatedStatements = [...statements];
        updatedStatements[statementIndex].response = response;
        setStatements(updatedStatements);
    }

    function submitStatements() {
        let object = {};
        object.id = examinationId;
        object.username = localStorage.getItem("LOGGED_USERNAME");
        object.statements = statements;

        console.log(object);

        DiagnosisService.submitStatementResponses(object).then((response) => {
            console.log(response);
            navigate("/");
            toast.success("Successfully submitted examination!");
        });
    }

    function handleCheckSubstance(index, substance) {
        let updatedSubstances = [...substances];
        updatedSubstances[index].isChecked = !substance.isChecked;
        setSubstances(updatedSubstances);
    }

    return (
        <>
            {!statementsLoaded && (
                <div style={{ margin: "50px 200px" }}>
                    <h1>New appointment</h1>
                    <div style={{ margin: "50px" }}>
                        <Row>
                            <Form.Label>Height</Form.Label>

                            <Col md={2} className="offset-5">
                                <Form.Control
                                    type="number"
                                    placeholder="Enter height in cm"
                                    value={height}
                                    onChange={(event) =>
                                        setHeight(event.target.value)
                                    }
                                />
                            </Col>
                        </Row>

                        <Row>
                            <Form.Label>Weight</Form.Label>
                            <Col md={2} className="offset-5">
                                <Form.Control
                                    type="number"
                                    placeholder="Enter current weight in kg"
                                    value={weight}
                                    onChange={(event) =>
                                        setWeight(event.target.value)
                                    }
                                />
                            </Col>
                        </Row>
                    </div>

                    <h3>
                        In the last two weeks, I have experienced the following
                        symptoms:{" "}
                    </h3>
                    <Table striped bordered hover>
                        <thead>
                            <tr>
                                <td>Symptom</td>
                                <td>Never</td>
                                <td>Sometimes</td>
                                <td>Often</td>
                            </tr>
                        </thead>
                        <tbody>
                            {symptoms.map((symptom, index) => (
                                <tr key={symptom.id}>
                                    <td>{symptom.description}</td>

                                    {frequencyValues.map((frequency) => (
                                        <td key={frequency}>
                                            <Form.Check
                                                name={`radioButton${symptom.id}`}
                                                type="radio"
                                                defaultChecked={
                                                    symptom.frequency ===
                                                    frequency
                                                }
                                                onClick={() =>
                                                    onFrequencyChange(
                                                        index,
                                                        frequency
                                                    )
                                                }
                                            />
                                        </td>
                                    ))}
                                </tr>
                            ))}
                        </tbody>
                    </Table>

                    <h3>
                        In the last two weeks, I have consumed the following
                        substances:{" "}
                    </h3>
                    <Table striped bordered hover>
                        <thead>
                            <tr>
                                <td>Substance</td>
                                <td>Cunsumed</td>
                            </tr>
                        </thead>
                        <tbody>
                            {substances.map((substance, index) => (
                                <tr key={substance.id}>
                                    <td>{substance.name}</td>

                                    <td>
                                        <Form.Check
                                            type="checkbox"
                                            onChange={() =>
                                                handleCheckSubstance(
                                                    index,
                                                    substance
                                                )
                                            }
                                        />
                                    </td>
                                </tr>
                            ))}
                        </tbody>
                    </Table>

                    <div style={{ margin: "50px" }}>
                        <h3>
                            Write a little bit about how you have been feeling
                            recently
                        </h3>
                        <Form.Control
                            as="textarea"
                            rows={5}
                            value={comment}
                            placeholder="Lately, I have felt..."
                            onChange={(event) => setComment(event.target.value)}
                        ></Form.Control>
                    </div>

                    <Button variant="success" onClick={() => submitSymptoms()}>
                        Submit
                    </Button>
                </div>
            )}
            {statementsLoaded && (
                <div>
                    <h1>Statements Quiz</h1>
                    <h3>
                        Please fill out how much you relate to the following
                        statements:{" "}
                    </h3>
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
                            {statements.map((statement, index) => (
                                <tr key={statement.statementId}>
                                    <td>{statement.statement}</td>

                                    {statementResponseValues.map((response) => (
                                        <td key={response}>
                                            <Form.Check
                                                name={`radioButton${statement.statementId}`}
                                                type="radio"
                                                defaultChecked={
                                                    statement.response ===
                                                    response
                                                }
                                                onClick={() =>
                                                    onStatementResponseChange(
                                                        index,
                                                        response
                                                    )
                                                }
                                            />
                                        </td>
                                    ))}
                                </tr>
                            ))}
                        </tbody>
                    </Table>
                    <Button
                        variant="success"
                        onClick={() => submitStatements()}
                    >
                        Submit
                    </Button>
                </div>
            )}
        </>
    );
};

export default NewAppointmentPage;

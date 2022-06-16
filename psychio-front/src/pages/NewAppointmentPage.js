import { useState, useEffect } from "react";
import SymptomService from "../services/SymptomService";
import Table from "react-bootstrap/Table"
import Form from 'react-bootstrap/Form'

const NewAppointmentPage = () => {

    const [symptoms, setSymptoms] = useState([]);
    const frequencies = ["NEVER", "SOMETIMES", "OFTEN"]

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

    return (
        <div>
            <h1>Start new appointment</h1>
            <h2>In the last two weeks, I have experienced the following symptoms: </h2>
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
                    {symptoms.map((s, index) =>
                        <tr key={s.id}>
                            <td>{s.description}</td>

                            {frequencies.map(frequency =>
                                <td key={frequency}>
                                    <Form.Check
                                        name={`radioButton${s.id}`}
                                        type="radio"
                                        defaultChecked={s.frequency === frequency}
                                        onClick={(() => onFrequencyChange(index, frequency))}
                                    />
                                </td>)}
                        </tr>
                    )}
                </tbody>
            </Table>
            <button>Submit</button>
        </div >
    );
};

export default NewAppointmentPage;
import { useEffect, useState } from "react";
import SymptomService from "../services/SymptomService";
import Table from "react-bootstrap/Table"


const SymptomsPage = ({ loggedUser }) => {

    const [symptoms, setSymptoms] = useState([]);
    const [allSymptomsSelected, setAllSymptomsSelected] = useState(true);

    useEffect(() => {
        SymptomService.getAll()
            .then((response) => {
                setSymptoms(response);
            })
    }, []);

    const onDisorderGroupSelected = (disorderGroupId) => {
        if (!disorderGroupId) {
            
            SymptomService.getAll()
                .then((response) => {
                    setSymptoms(response);
                    setAllSymptomsSelected(true);
                })
        }
        else{
            
            SymptomService.getAllByDisorderGroup(disorderGroupId)
                .then((response) => {
                    setSymptoms(response);
                    setAllSymptomsSelected(false);
                })
        }
    }

    return (
        <div>
            <h1>Symptoms</h1>
            <select style={{margin:"20px"}} onChange={(event) => onDisorderGroupSelected(event.target.value)}>
                <option value="">All disorder groups</option>
                <option value="1">Mood disorders</option>
                <option value="2">Anxiety disorders</option>
                <option value="3">Eating disorders</option>
                <option value="4">Psychotic disorders</option>
                <option value="5">Personality disorders</option>

            </select>
            {allSymptomsSelected ? (
                <Table striped bordered hover>
                <thead>
                    <tr>
                        <td>Symptom ID</td>
                        <td>Description</td>
                    </tr>

                </thead>
                <tbody>
                    {symptoms.map((symptom) => (
                        <tr key={symptom.id}>
                            <td>{symptom.id}</td>
                            <td>{symptom.description}</td>

                        </tr>
                    ))}
                </tbody>
            </Table>
            ) : (
                <Table striped bordered hover>
                <thead>
                    <tr>
                        <td>Symptom ID</td>
                        <td>Description</td>
                        <td>Occurence</td>

                    </tr>

                </thead>
                <tbody>
                    {symptoms.map((symptomOccurence) => (
                        <tr key={symptomOccurence.symptom.id}>
                            <td>{symptomOccurence.symptom.id}</td>
                            <td>{symptomOccurence.symptom.description}</td>
                            <td>{symptomOccurence.occurence}</td>

                        </tr>
                    ))}
                </tbody>
            </Table>
            )}
            
        </div>
    );
};

export default SymptomsPage;
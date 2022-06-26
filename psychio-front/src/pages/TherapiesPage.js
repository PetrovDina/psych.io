import { useEffect, useState } from "react";
import SubstanceGroupService from "../services/SubstanceGroupService";
import Table from "react-bootstrap/Table"


const TherapiesPage = ({ loggedUser }) => {

    const [therapies, setTherapies] = useState([]);
    const [allTherapiesSelected, setAllTherapiesSelected] = useState(true);

    useEffect(() => {
        SubstanceGroupService.getAllTherapies()
            .then((response) => {
                setTherapies(response);
            })
    }, []);

    const onDiagnosisSelected = (diagnosisId) => {
        if (!diagnosisId) {

            SubstanceGroupService.getAllTherapies()
                .then((response) => {
                    setTherapies(response);
                })
        }
        else {

            SubstanceGroupService.getAllTherapiesByDiagnosis(diagnosisId)
            .then((response) => {
                setTherapies(response);
            })
        }
    }

    return (
        <div>
            <h1>Therapies</h1>
            <select style={{ margin: "20px" }} onChange={(event) => onDiagnosisSelected(event.target.value)}>
                <option value="">All diagnoses</option>
                <option value="1">Depressive disorder</option>
                <option value="2">Bipolar disorder</option>
                <option value="3">Post-traumatic stress disorder</option>
                <option value="4">Generalized anxiety disorder</option>
                <option value="5">Social anxiety disorder</option>
                <option value="6">Panic disorder</option>
                <option value="7">Anorexia nervosa</option>
                <option value="8">Bulimia nervosa</option>
                <option value="9">Schizophrenia</option>
                <option value="10">Borderline personality disorder</option>
                <option value="11">Obsessive-compulsive disorder</option>
                <option value="12">Antisocial personality disorder</option>
                <option value="13">Paranoid personality disorder</option>

            </select>
            {allTherapiesSelected ? (
                <Table striped bordered hover>
                    <thead>
                        <tr>
                            <td>Therapy ID</td>
                            <td>Name</td>
                        </tr>

                    </thead>
                    <tbody>
                        {therapies.map((therapy) => (
                            <tr key={therapy.id}>
                                <td>{therapy.id}</td>
                                <td>{therapy.name}</td>

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
                    {/* <tbody>
                    {symptoms.map((symptomOccurence) => (
                        <tr key={symptomOccurence.symptom.id}>
                            <td>{symptomOccurence.symptom.id}</td>
                            <td>{symptomOccurence.symptom.description}</td>
                            <td>{symptomOccurence.occurence}</td>

                        </tr>
                    ))}
                </tbody> */}
                </Table>
            )}

        </div>
    );
};

export default TherapiesPage;
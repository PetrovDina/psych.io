import { useEffect, useState } from "react";
import { useParams } from 'react-router-dom';

import ExaminationService from "../services/ExaminationService";
import Row from 'react-bootstrap/Row';
import PatientCard from "../components/PatientCard";

const PatientsExaminationsPage = () => {

    const { patientUsername } = useParams();
    const [examinations, setExaminations] = useState([]);

    useEffect(() => {
        ExaminationService.getAllPatientsExaminations(patientUsername)
            .then((response) => {
                setExaminations(response);
            })
    }, []);

    return (
    <div>
      {examinations.length === 0 ? (
        <h1>There are currently no examinations for patient {patientUsername}</h1>
      ) : (
        <Row style={{ margin: '20px' }}>
          {examinations.map((examination) => (
            "here"
          ))}
        </Row>
      )}
    </div>
  );
};
export default PatientsExaminationsPage;
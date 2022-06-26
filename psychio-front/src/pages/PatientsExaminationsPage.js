import { useEffect, useState } from "react";
import { useParams } from 'react-router-dom';

import ExaminationService from "../services/ExaminationService";
import ExaminationCard from "../components/ExaminationCard";

const PatientsExaminationsPage = () => {

    const { patientUsername } = useParams();
    const [examinations, setExaminations] = useState([]);

    useEffect(() => {
        ExaminationService.getAllPatientsExaminations(patientUsername)
            .then((response) => {
                console.log(response);
                setExaminations(response);
            })
    }, []);

    return (
    <div>
      {examinations.length === 0 ? (
        <h1>There are currently no examinations for patient {patientUsername}</h1>
      ) : (
        <div style={{ margin: '20px' }}>
          {examinations.map((examination) => (
            <ExaminationCard examination={examination} key={examination.id}/>
          ))}
        </div>
      )}
    </div>
  );
};
export default PatientsExaminationsPage;
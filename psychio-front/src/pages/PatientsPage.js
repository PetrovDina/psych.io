import { useEffect, useState } from "react";
import UserService from "../services/UserService";
import Row from 'react-bootstrap/Row';
import PatientCard from "../components/PatientCard";

const PatientsPage = () => {

    const [patients, setPatients] = useState([]);

    useEffect(() => {
        UserService.getAllPatients()
            .then((response) => {
                console.log(response);
                setPatients(response);
            })
    }, []);

    return (
    <div>
      {patients.length === 0 ? (
        <h1>There are currently no patients registered</h1>
      ) : (
        <Row style={{ margin: '20px' }}>
          {patients.map((patient) => (
            <PatientCard
              key={patient.username}
              patient={patient}
            />
          ))}
        </Row>
      )}
    </div>
  );
};
export default PatientsPage;
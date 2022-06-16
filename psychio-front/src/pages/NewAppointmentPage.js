import { useState, useEffect } from "react";
import SymptomService from "../services/SymptomService";

const NewAppointmentPage = () => {

    const [symptoms, setSymptoms] = useState([]);

    useEffect(() => {
        SymptomService.getAll()
          .then((response) => {
            setSymptoms(response);
            console.log(response);
          })
          .catch((err) => {});
      }, []);

    return (
      <div>
        <h1>Start new appointment</h1>
      </div>
    );
  };
  
  export default NewAppointmentPage;
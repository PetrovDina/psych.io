import httpClient from '../config/httpClient.js';

const ExaminationService = {

    getAllPatientsExaminations: function(patientUsername) {
        return httpClient({
            url: 'examination/getAllByUsername',
            method: 'GET',
            params: {patientUsername: patientUsername}
          });
    }


};
  
export default ExaminationService;
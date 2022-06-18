import httpClient from '../config/httpClient.js';

const DiagnosisService = {

    submitStatementResponses: function(examination) {
        return httpClient({
            url: 'diagnosis/probability',
            method: 'POST',
            data: examination
          });
    }


};
  
export default DiagnosisService;
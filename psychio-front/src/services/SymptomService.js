import httpClient from '../config/httpClient.js';

const SymptomService = {

    getSymptoms: function() {
        return httpClient({
            url: 'symptom/all',
            method: 'GET',
          });
    }


};
  
export default SymptomService;
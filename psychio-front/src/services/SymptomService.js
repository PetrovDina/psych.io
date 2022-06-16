import httpClient from '../config/httpClient';

const SymptomService = {

    getSymptoms: function() {
        return httpClient({
            url: 'symptom/all',
            method: 'GET',
          });
    }


};
  
export default SymptomService;
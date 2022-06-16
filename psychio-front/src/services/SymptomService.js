import httpClient from '../config/httpClient.js';

const SymptomService = {

    getAll: function() {
        return httpClient({
            url: 'symptom/all',
            method: 'GET',
          });
    }


};
  
export default SymptomService;
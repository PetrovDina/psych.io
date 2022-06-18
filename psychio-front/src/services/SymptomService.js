import httpClient from '../config/httpClient.js';

const SymptomService = {

    getAll: function() {
        return httpClient({
            url: 'symptom/all',
            method: 'GET',
          });
    },

    submitSymptomFrequencies: function(examination) {
        return httpClient({
            url: 'disorder-group/probability',
            method: 'POST',
            data: examination
          });
    }


};
  
export default SymptomService;
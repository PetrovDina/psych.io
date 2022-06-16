import httpClient from '../config/httpClient.js';

const SymptomService = {

    getAll: function() {
        return httpClient({
            url: 'symptom/all',
            method: 'GET',
          });
    },

    submitSymptomFrequencies: function(symptomFrequencies) {
        console.log(symptomFrequencies);
        return httpClient({
            url: 'disorder-group/probability',
            method: 'POST',
            data: symptomFrequencies
          });
    }


};
  
export default SymptomService;
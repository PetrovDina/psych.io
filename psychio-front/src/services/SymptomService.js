import httpClient from '../config/httpClient.js';

const SymptomService = {

    getAll: function() {
        return httpClient({
            url: 'symptom/all',
            method: 'GET',
          });
    },

    getAllByDisorderGroup: function(disorderGroupId) {
        return httpClient({
            url: 'symptom/allByDisorderGroup',
            method: 'GET',
            params: {disorderGroupId}
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
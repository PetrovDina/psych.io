import httpClient from '../config/httpClient.js';

const PatientService = {

    getAllPatients: function () {
        return httpClient({
            url: 'patient/all',
            method: 'GET'
        });
    }
};

export default PatientService;
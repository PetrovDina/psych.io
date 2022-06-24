import httpClient from '../config/httpClient.js';

const UserService = {

    register: function(patient) {
        return httpClient({
            url: 'auth/registerPatient',
            method: 'POST',
            data: patient
          });
    }


};
  
export default UserService;
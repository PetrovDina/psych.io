import httpClient from '../config/httpClient.js';

const UserService = {

    register: function(patient) {
        return httpClient({
            url: 'auth/registerPatient',
            method: 'POST',
            data: patient
          });
    },

    login: function(loginInfo) {
        return httpClient({
            url: 'auth/login',
            method: 'POST',
            data: loginInfo
          });
    }


};
  
export default UserService;
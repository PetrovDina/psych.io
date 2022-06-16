import axios from 'axios';
import config from './config';

import errorHandler from './errorHandler';

const httpClient = axios.create({
//   withCredentials: true, //ovo cemo morati da vratimo ja msm ako budemo radili token i to
  baseURL: config.apiHost + config.apiUrlPrefix,
//   headers: {
//     Authorization: `Bearer ${sessionStorage.getItem('token')}`,
//   }, //i ovo isto
});

httpClient.interceptors.response.use(
  (response) => {
    return response.data;
  },
  (error) => {
    errorHandler(error.response);
    return Promise.reject(error);
  },
);

export default httpClient;

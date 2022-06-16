import axios from 'axios';
import config from '../config/config';

import errorHandler from './errorHandler';

const httpClient = axios.create({
  withCredentials: true,
  baseURL: config.apiHost + config.apiUrlPrefix,
  headers: {
    Authorization: `Bearer ${sessionStorage.getItem('token')}`,
  },
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

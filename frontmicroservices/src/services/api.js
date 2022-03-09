import axios from 'axios';

const api = axios.create({
  baseURL: 'http://localhost:8082/api/v1/',
});

export default api
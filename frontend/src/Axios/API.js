import axios from 'axios';

const employeeAPI =  axios.create({
  baseURL: 'https://6164f6e709a29d0017c88ed9.mockapi.io/fetest/employees'
});

export default employeeAPI;
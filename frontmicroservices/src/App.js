import React from 'react';
import { ToastContainer } from 'react-toastify'
import { Router } from 'react-router-dom';
import Routes from './routes/index';
import history from './services/history';
import Globalstyles from './styles/global'



export default function App() {
  
  return (
   
      <Router history={history}>
        <Routes />
        <Globalstyles />
        < ToastContainer  autoClose={3000} />
      </Router>
      
  );
}

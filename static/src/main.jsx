import axios from 'axios'
import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App';

// Set the base URL for all requests
axios.defaults.baseURL = location.origin;

ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    <App />
  </React.StrictMode>,
)

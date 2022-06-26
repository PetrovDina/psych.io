import { Route, Routes } from 'react-router-dom';
import { ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import './App.css';
import NavBar from './components/NavBar';
import HomePage from './pages/HomePage';
import LoginPage from './pages/LoginPage';
import NewAppointmentPage from './pages/NewAppointmentPage';
import RegisterPage from './pages/RegisterPage';
import { useState } from 'react';
import PatientsPage from './pages/PatientsPage';
import PatientsExaminationsPage from './pages/PatientsExaminationsPage';
import SymptomsPage from './pages/SymptomsPage';


function App() {

    const [loggedUser, setLoggedUser] = useState({ username: localStorage.getItem("LOGGED_USERNAME"), role: localStorage.getItem("LOGGED_ROLE") })

    return (
        <div className="App">
            <NavBar loggedUser={loggedUser} setLoggedUser={setLoggedUser}></NavBar>
            <Routes>
                <Route path='*' element={<HomePage loggedUser={loggedUser} />} />
                {loggedUser.role === "" && (<Route path='/register' element={<RegisterPage />} />)}
                {loggedUser.role === "" && (<Route path='/login' element={<LoginPage loggedUser={loggedUser} setLoggedUser={setLoggedUser} />} />)}
                {loggedUser.role === "PATIENT" && (<Route path='/new-appointment' element={<NewAppointmentPage />} />)}
                {loggedUser.role === "DOCTOR" && (<Route path='/patients' element={<PatientsPage />} />)}
                {loggedUser.role !== '' && (
                    <Route path="/patients/:patientUsername" element={<PatientsExaminationsPage />} />
                )}
                {loggedUser.role === 'DOCTOR' && (
                    <Route path="/symptoms" element={<SymptomsPage />} />
                )}
            </Routes>
            <ToastContainer />
        </div>
    );
}

export default App;

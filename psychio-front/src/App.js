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


function App() {

    const [loggedUser, setLoggedUser] = useState({username:"", role:""})

    return (
        <div className="App">
            <NavBar loggedUser={loggedUser} setLoggedUser={setLoggedUser}></NavBar>
            <Routes>
                <Route path='*' element={<HomePage loggedUser={loggedUser}/>} />
                <Route path='/register' element={<RegisterPage />} />
                <Route path='/login' element={<LoginPage loggedUser={loggedUser} setLoggedUser={setLoggedUser}/>} />
                <Route path='/new-appointment' element={<NewAppointmentPage />} />
            </Routes>
            <ToastContainer />
        </div>
    );
}

export default App;

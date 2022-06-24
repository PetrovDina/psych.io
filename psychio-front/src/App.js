import { Route, Routes } from 'react-router-dom';
import { ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import './App.css';
import NavBar from './components/NavBar';
import HomePage from './pages/HomePage';
import LoginPage from './pages/LoginPage';
import NewAppointmentPage from './pages/NewAppointmentPage';
import RegisterPage from './pages/RegisterPage';

function App() {
    return (
        <div className="App">
            <NavBar></NavBar>
            <Routes>
                <Route path='*' element={<HomePage />} />
                <Route path='/register' element={<RegisterPage />} />
                <Route path='/login' element={<LoginPage />} />
                <Route path='/new-appointment' element={<NewAppointmentPage />} />
            </Routes>
            <ToastContainer />
        </div>
    );
}

export default App;

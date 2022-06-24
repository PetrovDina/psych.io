import './App.css';
import { Routes, Route } from 'react-router-dom';
import { ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import NewAppointmentPage from './pages/NewAppointmentPage';
import HomePage from './pages/HomePage';
import NavBar from './components/NavBar';
import RegisterPage from './pages/RegisterPage';

function App() {
    return (
        <div className="App">
            <NavBar></NavBar>
            <Routes>
                <Route path='*' element={<HomePage />} />
                <Route path='/register' element={<RegisterPage />} />
                <Route path='/new-appointment' element={<NewAppointmentPage />} />
            </Routes>
            <ToastContainer />
        </div>
    );
}

export default App;

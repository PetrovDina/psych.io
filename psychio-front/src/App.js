import './App.css';
import { Routes, Route } from 'react-router-dom';
import { ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import NewAppointmentPage from './pages/NewAppointmentPage';
import HomePage from './pages/HomePage';

function App() {
    return (
        <div className="App">
            <Routes>
                <Route path='*' element={<HomePage />}/>
                <Route path='/new-appointment' element={<NewAppointmentPage />}/>
            </Routes>
            <ToastContainer />
        </div>
    );
}

export default App;

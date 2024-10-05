import Navigationbar from './Components/Navigationbar/Navigationbar';
import Dashboard from './Pages/Dashboard/Dashboard'
import ErrorPage from './Pages/ErrorPage/ErrorPage'
import { Route, Routes } from 'react-router-dom';

function App() {

  return (
    <>
      <Navigationbar />
      <Routes>
        <Route path="/dashboard" element={<Dashboard/>} />
        <Route path="*" element={<ErrorPage/>} />
      </Routes>
    </>
  );
}

export default App;

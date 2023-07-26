import { BrowserRouter, Route, Routes } from 'react-router-dom'
import Layout from './pages/Layout'
import Home from './pages/Home'
import Customers from './pages/Customers'
import './App.css';

function App() {
  return (
    <div className="App">
        <BrowserRouter>
            <Routes>
              <Route path={'/'} element={<Layout/>}>
                <Route index element={<Home/>}/>
                <Route path={"customers"} element={<Customers/>}/>
              </Route>
            </Routes>
        </BrowserRouter>
    </div>
  );
}

export default App;

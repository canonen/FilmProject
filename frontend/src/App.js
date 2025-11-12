import React from "react";
import { useEffect, useState } from "react";
import {BrowserRouter as Router, Routes, Route, Link} from "react-router-dom";
import LoginPage from "./pages/LoginPage";
import RegisterPage from './pages/RegisterPage';
import Navbar from './components/Navbar'
import HomePage from "./pages/HomePage";
import axios from "axios";
import { Navigate } from "react-router-dom";
import FilmList from "./components/FilmList";

function App() {
  const [user, setUser] = useState(null)

  useEffect(() => {
    axios.get("http://localhost:8080/api/kullanici/me", {withCredentials:true})
    .then(res => setUser(res.data))
    .catch(()=> setUser(null))
  }, []);

  return (
    <Router>
      <Navbar user = {user} setUser = {setUser} />
      <div className="container mt-4">
        <Routes>
          <Route path="/" element={<HomePage />} />
          <Route path="/login" element={user ? <Navigate to = "/" /> : <LoginPage setUser = {setUser} />} />
          <Route path="/register" element={user ? <Navigate to = "/" /> : <RegisterPage />} />
          <Route path="/new-movies" element={<FilmList />} />
          <Route path="/film/:id" element= {<FilmDetail/>} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;

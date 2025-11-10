import React from "react";
import { Link } from "react-router-dom";
import { Dropdown } from "react-bootstrap";
import axios from "axios";
import { useNavigate } from "react-router-dom";


function Navbar({user, setUser}) {

  const navigate = useNavigate();

  return (
    <nav className="navbar navbar-light bg-light px-3 shadow-sm d-flex justify-content-between">
      <div className="d-flex align-items-center">
        <a className="navbar-brand" href="/">FilmProject</a>
        <a className="nav-link ms-3" href="/new-movies">Yeni Eklenenler</a>
      </div>

      <div>
        {!user ? (
          <>
            <a href="/login" className="btn btn-outline-primary me-2">Login</a>
            <a href="/register" className="btn btn-success">Register</a>
          </>
        ) : (
          <Dropdown>
            <Dropdown.Toggle variant="light" id="dropdown-basic">
              <img 
                src="https://cdn-icons-png.flaticon.com/512/149/149071.png" 
                alt="avatar" 
                style={{ width: "30px", marginRight: "8px" }}
              />
              {user.kullaniciAdi}
            </Dropdown.Toggle>

            <Dropdown.Menu>
              <Dropdown.Item href="#/action-1">asd1</Dropdown.Item>
              <Dropdown.Item href="#/action-2">asd2</Dropdown.Item>
              <Dropdown.Divider />
              <Dropdown.Item 
                onClick={() => {
                  axios.post("http://localhost:8080/api/auth/logout", {}, { withCredentials: true })
                    .then(() => setUser(null))
                    .then(() => navigate("/"));
                }}
              >
                Çıkış Yap
              </Dropdown.Item>
            </Dropdown.Menu>
          </Dropdown>
        )}
      </div>
    </nav>
  )
};

export default Navbar;
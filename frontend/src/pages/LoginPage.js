import { useState } from "react";
import { useNavigate } from "react-router-dom";
import React from "react";
import axios from "axios";

function LoginPage(){

  const navigate = useNavigate();

  const [showWarningMessage, setShowWarningMessage] = useState(false);
  const [message, setMessage] = useState("");

  const [formData, setFormData] = useState({
    usernameOrEmail: "",
    password: ""
  })

  const handleWarningMessage = (e) => {
    setShowWarningMessage(false)
    setMessage("")
  }

  const handleChange = (e) => {
    setFormData({
      ...formData,
      [e.target.name] : e.target.value
    })
  }

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const response = await axios.post("http://localhost:8080/api/auth/login", formData, {withCredentials:true})
      if(response.status == 200) //Success
        navigate("/")

    } catch (error) {
      setShowWarningMessage(true);
      setMessage(error.response.data.message)
    }
  }

  return(
  <div className="d-flex justify-content-center align-items-center" style={{ minHeight: "80vh" }}>
      <div className="card p-4 shadow" style={{ width: "400px" }}>
        <h3 className="text-center mb-3">Login</h3>
        <form onSubmit={handleSubmit}>
          <div className="mb-3">
            <input 
              type="text" 
              className="form-control"
              placeholder="Kullanıcı adı"
              name="usernameOrEmail"
              value={formData.usernameOrEmail}
              onChange={handleChange}
              required
            />
          </div>
          <div className="mb-3">
            <input 
              type="password" 
              className="form-control"
              placeholder="Şifre"
              name="password"
              value={formData.password}
              onChange={handleChange}
              required
            />
          </div>
          <button type="submit" className="btn btn-primary w-100">Giriş Yap</button>
        </form>
      </div>

      {showWarningMessage && (
  <div
    className="modal fade show"
    style={{ display: "block", backgroundColor: "rgba(0,0,0,0.5)" }}
  >
    <div className="modal-dialog modal-dialog-centered">
      <div className="modal-content shadow-lg rounded-3 border-0">
        <div className="modal-header bg-danger text-white">
          <h5 className="modal-title">
            <i className="bi bi-exclamation-triangle-fill me-2"></i> Hata!
          </h5>
          <button
            type="button"
            className="btn-close btn-close-white"
            onClick={handleWarningMessage}
          ></button>
        </div>
        <div className="modal-body text-center">
          <p className="fs-5 text-dark">{message}</p>
        </div>
        <div className="modal-footer border-0">
          <button
            type="button"
            className="btn btn-danger w-100"
            onClick={handleWarningMessage}
          >
            Tamam
          </button>
        </div>
      </div>
    </div>
  </div>
)}

    </div>
  ) 
};  

export default LoginPage;
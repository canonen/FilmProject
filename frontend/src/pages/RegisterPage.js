import { useState } from "react";
import { useNavigate } from "react-router-dom";
import React from "react";
import axios from "axios";

function RegisterPage() {
    /////////////////////////////////////////////////////////
    //States
    /////////////////////////////////////////////////////////

    const navigate = useNavigate();

    const [formData, setFormData] = useState({
        kullaniciAdi : "",
        adi : "",
        soyadi : "",
        email : "",
        sifre : "",
        rol : "USER",
        dogumTarihi : "",
    })

    const [showSuccesfulMessage, setShowSuccessfulMessage] = useState(false);

    /////////////////////////////////////////////////////////
    const handleSuccessfulMessage = () =>{
        setShowSuccessfulMessage(false)
        navigate("/login")
    }

    const handleChange = (e) => {
        setFormData({
            ...formData,
            [e.target.name]: e.target.value
        }   
        );
    };

    const handleSubmit = async (e) => {
        e.preventDefault();

        try{
            const response = await axios.post("http://localhost:8080/api/auth/register", formData);
            console.log("Kayıt başarılı!");
            setShowSuccessfulMessage(true);
        }
        catch(error){
            console.error("HATA:", error)
        }
  };

    return (
        
        <div className="d-flex justify-content-center align-items-center" style={{ minHeight: "80vh" }}>
            {/* Main */}
            <div className="card p-4 shadow" style={{ width: "450px" }}>
                <h3 className="text-center mb-3">Register</h3>
                <form onSubmit={handleSubmit}>
                <div className="mb-3">
                    <input 
                    type="text" 
                    className="form-control"
                    name="kullaniciAdi"
                    placeholder="Kullanıcı Adı"
                    value={formData.kul}
                    onChange={handleChange}
                    required
                    />
                </div>
                <div className="mb-3">
                    <input 
                    type="text" 
                    className="form-control"
                    name="adi"
                    placeholder="Ad"
                    value={formData.ad}
                    onChange={handleChange}
                    required
                    />
                </div>
                <div className="mb-3">
                    <input 
                    type="text" 
                    className="form-control"
                    name="soyadi"
                    placeholder="Soyad"
                    value={formData.soyad}
                    onChange={handleChange}
                    required
                    />
                </div>
                <div className="mb-3">
                    <input 
                    type="email" 
                    className="form-control"
                    name="email"
                    placeholder="E-mail"
                    value={formData.mail}
                    onChange={handleChange}
                    required
                    />
                </div>
                <div className="mb-3">
                    <input 
                    type="password" 
                    className="form-control"
                    name="sifre"
                    placeholder="Şifre"
                    value={formData.sifre}
                    onChange={handleChange}
                    required
                    />
                </div>
                <div className="mb-3">
                    <input 
                    type="date" 
                    className="form-control"
                    name="dogumTarihi"
                    value={formData.dogumTarihi}
                    onChange={handleChange}
                    required
                    />
                </div>
                <button type="submit" className="btn btn-success w-100">Kayıt Ol</button>
                </form>
            </div>

            {/* ✅ Modal */}
         {showSuccesfulMessage && (
            <div
          className="modal fade show"
          style={{ display: "block", backgroundColor: "rgba(0,0,0,0.5)" }}
            >
          <div className="modal-dialog modal-dialog-centered">
            <div className="modal-content shadow-lg rounded-3">
              <div className="modal-header bg-success text-white">
                <h5 className="modal-title">Başarılı!</h5>
                <button
                  type="button"
                  className="btn-close btn-close-white"
                  onClick={() => handleSuccessfulMessage()}
                ></button>
              </div>
              <div className="modal-body text-center">
                <p className="fs-5">🎉 Başarıyla kayıt oldunuz! <br/> Giriş Yap sayfasına yönlendirileceksiniz.</p>
              </div>
              <div className="modal-footer">
                <button
                  type="button"
                  className="btn btn-success w-100"
                  onClick={() => handleSuccessfulMessage()}
                >
                  Tamam
                </button>
              </div>
            </div>
          </div>
        </div>
          )}
    </div>
    );
}
export default RegisterPage;
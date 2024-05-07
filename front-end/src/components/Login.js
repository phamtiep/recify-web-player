import "../components/login.css";
import {useState} from "react";
import { useNavigate } from "react-router-dom";
function Login(){
    const navigate = useNavigate();

    const handleLogin = () =>{
      if(username&&password){
        navigate("/")
      }
    }
    const [username, setUsername] = useState("")
    const [password, setPassword] = useState("")
  
      return (
          <div className="login">
            <div className="loginWrapper">
              <div className="loginLeft">
                <h3 className="loginLogo">Recify</h3>
                <span className="loginDesc">
                 Explore your own music
                </span>
              </div>
              <div className="loginRight">
                <div className="loginBox">
                  <input type = "text" placeholder="Username"   value={username} onChange={(event) => setUsername(event.target.value)}className="loginInput" />
                  <input type = "password" placeholder= "Password" value={password} onChange={(event) => setPassword(event.target.value)} className="loginInput" />
                  <button className="loginButton" onClick={()=> handleLogin()}>
                    Sign In
                    
                  </button>
                </div>
              </div>
            </div>
          </div>
        );
}
export default Login;
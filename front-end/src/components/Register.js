import "../components/register.css";
import {useState} from "react";
import { useNavigate } from "react-router-dom";
export default function Register() {
    const navigate = useNavigate();

    const handleRegister = () =>{
      if(password.length >= 6){
        if((username&&password)&&(password === password2)){
          const users = JSON.parse(localStorage.getItem("users")) || [];
          const userExists = users.some(user => user.username === username);
          if(userExists){
            setErrorMessage("Username already exists. Please choose another.");
          }else{
            users.push({ username, password });
            localStorage.setItem("users", JSON.stringify(users));
            navigate("/login");
          }

         
        }
        else{
          setErrorMessage("Passwords do not match or some fields are empty."); // Set error message
        }
      }      
      else{
        setErrorMessage("Passwords must be at least 6 character long."); // Set error message
      }
    }
    const [username, setUsername] = useState("")
    const [password, setPassword] = useState("")
    const [password2, setPassword2] = useState("")
    const [errorMessage, setErrorMessage] = useState("");
  
  return (
    <div className="register">
      <div className="registerWrapper">
        <div className="registerLeft">
          <h3 className="registerLogo">Recify</h3>
          <span className="registerDesc">
            Explore your music
          </span>
        </div>
        <div className="registerRight">
          <div className="registerBox">
            <input 
                type = "text" 
                placeholder="Username"  
                value={username} 
                onChange={(event) => setUsername(event.target.value)}
                className="registerInput"
            />
            <input 
                type = "password" 
                placeholder="password"  
                value={password} 
                onChange={(event) => setPassword(event.target.value)}
                className="registerInput"
            />
            <input type = "password" 
                placeholder="password again "  
                value={password2} 
                onChange={(event) => setPassword2(event.target.value)}
                className="registerInput"/>
            <button className="registerButton" 
              onClick={()=> handleRegister()}>
              Sign Up
              </button>
              {errorMessage && <p>{errorMessage}</p>} {/* Display error message if it exists */}
          </div>
        </div>
      </div>
    </div>
  );
}
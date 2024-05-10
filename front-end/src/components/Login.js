import "../components/login.css";
import {useState} from "react";
import { useNavigate } from "react-router-dom";
function Login(){
  const navigate = useNavigate();
  

  const handleLogin = () =>{
    
    //if(username&&password){
    //  navigate("/")
    //}
    if(password.length >= 6){
      if(username&&password){
        setIsLoggedIn(true)
        setUsername("")
        setPassword("")
      }else{
        setErrorMessage("Passwords incorrect or some fields are empty."); // Set error message
      }

    }else{
      setErrorMessage("Passwords must be at least 6 character long");
    }
    
    
  }
  const handleLogout = () => {
    // Clear any user authentication state
    setIsLoggedIn(false);
    // Navigate user to the login page
    navigate("/login");
  };
  const handleBackHome = () => {
    navigate("/")
    setIsLoggedIn(true)
  }
  const [errorMessage, setErrorMessage] = useState("");
  const [username, setUsername] = useState("")
  const [password, setPassword] = useState("")
  const [isLoggedIn, setIsLoggedIn] = useState(false); // Track login status
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
            {!isLoggedIn && (
              <div className="loginBox">
                <input type = "text" 
                  placeholder="Username"  
                  value={username} 
                  onChange={(event) => setUsername(event.target.value)}
                  className="loginInput" />
                <input type = "password" placeholder= "Password" value={password} onChange={(event) => setPassword(event.target.value)} className="loginInput" />
                <button className="loginButton" onClick={()=> handleLogin()}>
                  Sign In
                  
                </button>
                {errorMessage && <p>{errorMessage}</p>} {/* Display error message if it exists */}
              </div>
            )}
                {isLoggedIn && (
                  <div className="logoutBox">
                  <button className="logoutButton" onClick={handleLogout}>
                    Logout
                  </button>
                  <button className="logoutButton" onClick={handleBackHome}>
                    Home
                  </button>
                  </div>
                )}
              </div>
            </div>
          </div>

      );
}
export default Login;
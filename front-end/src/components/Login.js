import "../components/login.css";
import {useState,useEffect } from "react";
import { useNavigate } from "react-router-dom";
function Login({isLoggedIn ,setIsLoggedIn}){
  const navigate = useNavigate();
  
  useEffect(() => {
    const loggedIn = localStorage.getItem("isLoggedIn") === "true";
    setIsLoggedIn(loggedIn);
  }, [setIsLoggedIn]);

  const handleLogin = () =>{
    const users = JSON.parse(localStorage.getItem("users")) || [];
    const user = users.find(user => user.username === username && user.password === password);

    //if(username&&password){
    //  navigate("/")
    //}
    
    if (user) {
      setIsLoggedIn(true);
      localStorage.setItem("isLoggedIn", "true");
      setUsername("");
      setPassword("");
      navigate("/");
    } else {
      setErrorMessage("Invalid username or password.");
    }
    
    
  }
  const handleLogout = () => {
    // Clear any user authentication state
    
    // Navigate user to the login page
    localStorage.setItem("isLoggedIn", "false");
    setIsLoggedIn(false);
    navigate("/login");
    
  };
  const handleBackHome = () => {
    navigate("/")
    setIsLoggedIn(true)
  }
  const [errorMessage, setErrorMessage] = useState("");
  const [username, setUsername] = useState("")
  const [password, setPassword] = useState("")

 // Track login status
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
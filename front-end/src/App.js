import {Routes, Route} from "react-router-dom";
import Home from "./components/Home";
import Navbar from "./components/Navbar";
import Login from "./components/Login";
import Register from "./components/Register";
import Player from "./components/Player";
import {useState} from "react";
function App() {
  const [isLoggedIn, setIsLoggedIn] = useState("");
  return (
    <>
    <Navbar />

    <Routes >
      <Route path="/" element={ <Home /> } />
      <Route path="/login" element={ <Login isLoggedIn = {isLoggedIn} setIsLoggedIn={setIsLoggedIn}/> }  />
      <Route path="/register" element={ <Register /> } />
      <Route path="/player" element={ <Player /> } />
    </Routes>
    </>
  );
}

export default App;
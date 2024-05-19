import {Routes, Route} from "react-router-dom";
import Home from "./components/Home";
import Navbar from "./components/Navbar";
import Login from "./components/Login";
import Register from "./components/Register";
import Player from "./components/Player";
import Library from "./components/Library";
import Allmusic from "./components/Allmusic";
import {useState} from "react";
function App() {
  const [isLoggedIn, setIsLoggedIn] = useState("");
  const [allPlaylists,setAllPlaylists] = useState([]);
  return (
    <>
    <Navbar />

    <Routes >
      <Route path="/" element={ <Home /> } />
      <Route path="/login" element={ <Login isLoggedIn = {isLoggedIn} setIsLoggedIn={setIsLoggedIn}/>  }  />
      <Route path="/allmusic" element={ <Allmusic /> } />
      <Route path="/library" element={ <Library allPlaylists={ = {allPlaylists}} setAllPlaylists={setAllPlaylists}/> } />
      <Route path="/register" element={ <Register /> } />
      <Route path="/player" element={ <Player /> } />
    </Routes>
    </>
  );
}

export default App;
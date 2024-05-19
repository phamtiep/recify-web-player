import React, { useRef, useState, useEffect } from 'react';
import useSound from "use-sound";
import { FaPause, FaPlay } from "react-icons/fa";
import { IoMdSkipBackward, IoMdSkipForward, IoMdTabletLandscape } from "react-icons/io";
import song1 from "../MusicUpload/chill-music/ChacAiDoSeVe-SonTungMTP-3597661.mp3"
import song2 from "../MusicUpload/chill-music/good-night-160166.mp3"
import song3 from "../MusicUpload/chill-music/lofi-chill-medium-version-159456.mp3"
//import "../MusicUpload/study-music"
//import "../MusicUpload/workout-music"

import "../components/allmusic.css";

function Allmusic() {
    const audioPlayer = useRef();
    const defaultplaylist = [song1,song2, song3];

    // State to manage new playlist name and all playlists
    const [playlistName, setPlaylistName] = useState("");
    const [expandedPlaylists, setExpandedPlaylists] = useState({});
    const [playlistcurrent, setPlaylistcurrent] = useState([]);
    const [index, setIndex] = useState(0);
    const [isPlaying, setIsPlaying] = useState(false);
    const [musicList, setMusicList] = useState([]);
    const [currentpath, setCurrentpath] = useState("");
    const [data3, setData3] = useState(null)
    let playlist = [];
    
    if (playlistcurrent.length === 0) {
        playlist = defaultplaylist;
    } else {
        playlist = playlistcurrent.songs;
    }

    const togglePlay = () => {
        if (!isPlaying) {
            audioPlayer.current.play();
        } else {
            audioPlayer.current.pause();
        }
        setIsPlaying(prev => !prev);
    }

    const toggleSkipForward = () => {
        if (index >= playlist.length - 1) {
            setIndex(0);
            audioPlayer.current.src = playlist[0];
            audioPlayer.current.play();
        } else {
            setIndex(prev => prev + 1);
            audioPlayer.current.src = playlist[index + 1];
            audioPlayer.current.play();
        }
    }

    const toggleSkipBackward = () => {
        if (index > 0) {
            setIndex(prev => prev - 1);
            audioPlayer.current.src = playlist[index - 1];
            audioPlayer.current.play();
        }
    }
    const handleAllMusic = async () => {
        const link = `http://192.168.1.183:7057/api/music/getAllMusic/`;
        const option = {
          method: 'GET',
        };
    
        try {
          const response = await fetch(link, option);
          if (!response.ok) {
            throw new Error('Network response was not ok ' + response.statusText);
          }
          
          const data = await response.json();
          setMusicList(data); 
        } catch (error) {
          console.error('There was a problem with the fetch operation:', error);
        }
      };
      const PlayPlaylist = async (playlistID) => {
        
        const link = `http://192.168.1.183:7057/api/music/getFile/${playlistID}`;
        

        try {
            const response = await fetch(link);
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            const result = await response.json();
            setData3(result['pathFile'])
            setCurrentpath(data3.toString())
            console.log(data3.toString());
            
            // Assuming the result contains the playlist details including songs
    
        } catch (error) {
            console.error('Error fetching data:', error);
        }
    };


    return(
        <div className='background'>
            <div className='all-music'>
        <button className='all-music-bt2' onClick={handleAllMusic}>
            <strong> All music </strong>
        </button>

        <div className='list-container'>
        <ul >
        {musicList.map(song => (
            <li  key={song.id} className='box-2' onClick={() => PlayPlaylist(song.id)}>
                <strong>{song.name}</strong>
             </li>
            ))}
        </ul>

        </div>
        
    
    </div>
    <div className='custom-paper'>
                <div className='controls'>
                    <IoMdSkipBackward className='button' onClick={toggleSkipBackward} />
                    {!isPlaying
                        ? <FaPlay className= 'button' onClick={togglePlay} />
                        : <FaPause className='button' onClick={togglePlay} />
                    }
                    <IoMdSkipForward className = 'button' onClick={toggleSkipForward} />
                </div>
        </div>



        </div>
        


        
    )
    
}
    

export default Allmusic;

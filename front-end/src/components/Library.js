import React, { useRef, useState, useEffect } from 'react';
import useSound from "use-sound";
import { FaPause, FaPlay } from "react-icons/fa";
import { IoMdSkipBackward, IoMdSkipForward, IoMdTabletLandscape } from "react-icons/io";
import song1 from "../MusicUpload/chill-music/ChacAiDoSeVe-SonTungMTP-3597661.mp3"
import song2 from "../MusicUpload/chill-music/good-night-160166.mp3"
import song3 from "../MusicUpload/chill-music/lofi-chill-medium-version-159456.mp3"
//import "../MusicUpload/study-music"
//import "../MusicUpload/workout-music"

import "../components/library.css";

function Library({ allPlaylists, setAllPlaylists, token }) {
    const [currentPlaylist, setCurrentPlaylist] = useState(null);
    const [data, setData] = useState(null);
    const [data2, setData2] = useState(null);
    const [data3, setData3] = useState(null)
    const link = "http://192.168.1.183:7057/api/user/getAllPlaylist/";

    const makeResponse = async () => {
        const option = {
            method: 'GET',
            headers: { 'Authorization': "Bearer " + token }
        }

        try {
            const response = await fetch(link, option);
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            const result = await response.json();
            setData(result);
        } catch (error) {
            console.error('Error fetching data:', error);
        }
    }

    const makeResponse2 = async (playlistID) => {
        const link = `http://192.168.1.183:7057/api/playlist/getAllMusicPlaylist/${playlistID}`;

        const option = {
            method: 'GET',
            headers: { 'Authorization': "Bearer " + token }
        }

        try {
            const response = await fetch(link, option);
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            const result = await response.json();
            console.log(result);

            setAllPlaylists(prevPlaylists =>
                prevPlaylists.map(playlist =>
                    playlist.id === playlistID ? { ...playlist, songs: result } : playlist
                )
            );
        } catch (error) {
            console.error('Error fetching data:', error);
        }
    }
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

    
    useEffect(() => {
        makeResponse();
    }, []);

    useEffect(() => {
        if (data) {
            setAllPlaylists(data);
        } else {
            console.log("error");
        }
    }, [data, setAllPlaylists]);
    useEffect(() => {
        if (data3) {
            setCurrentpath(data3);
            console.log(currentpath)
            
        } else {
            console.log("error");
        }
    }, [data3]);

    // Array of songs
    const songs = [song1, song2, song3];

    // State to manage new playlist name and all playlists
    const [playlistName, setPlaylistName] = useState("");
    const [expandedPlaylists, setExpandedPlaylists] = useState({});
    const [playlistcurrent, setPlaylistcurrent] = useState([]);
    const [index, setIndex] = useState(0);
    const [isPlaying, setIsPlaying] = useState(false);

    const handleAddPlaylist = async (e) => {
        if(token){
            const params = new URLSearchParams({
                name: playlistName
              });
            const link  = `http://192.168.1.183:7057/api/user/createNewPlaylist?${params.toString()}`;
            const option = {
                method: 'POST',
                headers: { 'Authorization': "Bearer " + token }
            }
    
            if (playlistName) {
                const updatedPlaylists = [...allPlaylists];
                updatedPlaylists.push({
                    id: Date.now(),
                    name: playlistName,
                    songs: [...songs]
                });
                setAllPlaylists(updatedPlaylists);
                setPlaylistName("");
                const response = await fetch(link, option)
                console.log(response.json())
    
            }

        }
        
    };

    const togglePlaylist = (index) => {
        setExpandedPlaylists(prevState => ({
            ...prevState,
            [index]: !prevState[index]
        }));
    };

    const handlePlayPlaylist = (index) => {
        setPlaylistcurrent(allPlaylists[index]);
    };

    const handleDelete = async(id) => {
        const link  = `http://192.168.1.183:7057/api/music/deleteMusic/${id}`;
        const option = {
            method: 'DELETE',
            headers: { 'Authorization': "Bearer " + token }
        }
        const response = await fetch(link, option)
        console.log(response)
        const updatedPlaylists = [...allPlaylists];
        updatedPlaylists.splice(index, 1);
        setAllPlaylists(updatedPlaylists);
    };

    const handleRemoveSong = (playlistIndex, songIndex) => {
        const updatedPlaylists = [...allPlaylists];
        updatedPlaylists[playlistIndex].songs.splice(songIndex, 1);
        setAllPlaylists(updatedPlaylists);
    };

    const defaultplaylist = [song1,song2, song3];
    let playlist = [];
    if (playlistcurrent.length === 0) {
        playlist = defaultplaylist;
    } else {
        playlist = playlistcurrent.songs;
    }
    const audioPlayer = useRef();
    const [currentpath, setCurrentpath] = useState("");

    const [currentSong ] = useState(playlist[index]);


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
    const [musicList, setMusicList] = useState([]);

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
      setMusicList(data.slice(0, 6)); 
    } catch (error) {
      console.error('There was a problem with the fetch operation:', error);
    }
  };

  useEffect(() => {
    handleAllMusic();
  }, []);

    return (
        <div className='background'>
            <div className='all-music'>
                <button className='all-music-bt' onClick={handleAllMusic}>
                    <strong> All music -> </strong>
                </button>
    

                <ul className='display-music'>
                {musicList.map(song => (
                    <li className = 'box-music'key={song.id}  onClick={() => PlayPlaylist(song.id)}>
                        <strong>{song.name}</strong>
                     </li>
                    ))}
                </ul>
            
            </div>
            <div className='container'>
                <input className='input-box'
                    type="text"
                    placeholder="Enter playlist name"
                    value={playlistName}
                    onChange={(event) => setPlaylistName(event.target.value)}
                />
                <button className="new-playlist" onClick={handleAddPlaylist}>
                    <strong>Add new playlist </strong>
                </button>
            </div>
        
            <div className='display-playlist'>
                {allPlaylists.map((playlist, index) => (
                    <div key={index}>
                        <h3 className='playlist-name'> <strong>{playlist.name} </strong></h3>
                       
                        <button className='select-playlist' onClick = {() => PlayPlaylist (playlist.songs.name)}>
                            <strong>play playlist </strong>
                        </button>
                        <button className='select-playlist' onClick = {() => handleDelete (index)}>
                            <strong>delete playlist </strong>
                        </button>
                        <button className = 'select-playlist' onClick={() => makeResponse2(playlist.id)}> <strong>all song</strong></button>
                        {playlist.songs && (
                            <ul>
                                {playlist.songs.map((song, songIndex) => (
                            
                                    <li className = 'box' key={song.id}  onClick={() => PlayPlaylist(song.id)}>
                                        <strong> {song.name} </strong>
                                    </li>
                                ))}
                            </ul>
                        )}
                    </div>
                ))}

            </div>
            <audio src={currentpath} ref={audioPlayer} />

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
    );
    
}

export default Library;

import React, {useState, useEffect, useRef} from 'react'
import {
    styled, Typography, Slider,
    Paper, Stack, Box
} from '@mui/material';
import Backgrimg from "../assets/background.png";
import MyVideo from "../assets/videobg2.mp4";
// #region ------------ ICONS ---------
import VolumeDownIcon from '@mui/icons-material/VolumeDown';
import VolumeUpIcon from '@mui/icons-material/VolumeUp';
import VolumeOffIcon from '@mui/icons-material/VolumeOff';
import VolumeMuteIcon from '@mui/icons-material/VolumeMute';

import PauseIcon from '@mui/icons-material/Pause';
import FastRewindIcon from '@mui/icons-material/FastRewind';
import FastForwardIcon from '@mui/icons-material/FastForward';
import PlayArrowIcon from '@mui/icons-material/PlayArrow';
import SkipNextIcon from '@mui/icons-material/SkipNext';
import SkipPreviousIcon from '@mui/icons-material/SkipPrevious';
// #endregion ------------ ICONS ---------

// #region ------- Tracts -------------------------------------------------------
import song1 from "../song/song1.mp3";
import song2 from "../song/song2.mp3";
import song3 from "../song/song3.mp3";
import song4 from "../song/song4.mp3";
// #endregion ---------------------------------------------------------------

// #region -------- Styled Components -----------------------------------------
const Div = styled('div')(({ theme }) => ({ 
    //position : 'relative',
    height: 'calc(100vh - 64px)', // 64px là chiều cao của thanh công cụ trình duyệt, bạn có thể thay đổi giá trị này tùy thuộc vào thiết kế của trang web
    width: '100vw',
    paddingTop: theme.spacing(1),
    overflow: 'hidden',
  }));

const CustomPaper = styled(Paper)(({theme}) => ({
    backgroundColor: 'rgba(0, 0, 0, 0.3)',
    //marginLeft: theme.spacing(5),
    //marginRight: theme.spacing(5),
    padding: theme.spacing(2),
    bottom: 0,
    left: 0,
    right:0,
    position: 'fixed' ,
    flexDirection: 'column',
    zIndex : 1, 
    //justifyContent: 'flex-end', // Đảm bảo phần tử luôn nằm ở đáy của cửa sổ
}))

const PSlider = styled(Slider)(({theme, ...props}) => ({
    zIndex: 1,
    color: 'white',
    height: 2,
    '&:hover': {
        cursor: 'auto',
    },
    '& .MuiSlider-thumb': {
        width: '13px',
        height: '13px',
        display: props.thumbless ? 'none' : 'block',
    }
}))
const QueueBar = styled(Paper)(({ theme }) => ({
    backgroundColor: 'rgba(0, 0, 150, 0.1)',
    padding: theme.spacing(1),
    height: '10%', // Sử dụng chiều cao 100% để phù hợp với chiều cao của cửa sổ
    width: '20vw', // Sử dụng 20% của chiều rộng của cửa sổ
    position: 'fixed',
    top: 55,
    right: 0,
    color: 'white'
  }));

// #endregion ---------------------------------------------------------------


const playlist = [song1, song2, song3, song4];


export default function Player() {
    const audioPlayer = useRef()

    const [index, setIndex] = useState(0);

    const [currentSong] = useState(playlist[index]);

    const [isPlaying, setIsPlaying] = useState(false);
    const [volume, setVolume] = useState(30);
    const [mute, setMute] = useState(false);

    const [elapsed, setElapsed] = useState(0);
    const [duration, setDuration] = useState(0);

    useEffect(() => {
        if(audioPlayer){
            audioPlayer.current.volume = volume / 100;
        }

        
        if(isPlaying){
            setInterval(() => {
                const _duration = Math.floor(audioPlayer?.current?.duration);
                const _elapsed = Math.floor(audioPlayer?.current?.currentTime);

                setDuration(_duration);
                setElapsed(_elapsed);
            }, 100);
        }

    }, [
        volume, isPlaying
    ]);

    function formatTime(time) {
        if(time && !isNaN(time)){
            const minutes = Math.floor(time / 60) < 10 ? `0${Math.floor(time / 60)}` : Math.floor(time / 60);
            const seconds = Math.floor(time % 60) < 10 ? `0${Math.floor(time % 60)}` : Math.floor(time % 60);

            return `${minutes}:${seconds}`;
        }
        return '00:00';
    }

    const togglePlay = () => {
        if(!isPlaying) {
            audioPlayer.current.play()
        }else {
            audioPlayer.current.pause()
        }
        setIsPlaying(prev => !prev)
    }

    const toggleForward = () => {
        audioPlayer.current.currentTime += 10;
    }

    const toggleBackward = () => {
        audioPlayer.current.currentTime -= 10;
    }

    const toggleSkipForward = () => {
        if(index >= playlist.length - 1) {
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
        if(index > 0) {
            setIndex(prev => prev - 1);
            audioPlayer.current.src = playlist[index - 1];
            audioPlayer.current.play();
        }
    }
    
    function VolumeBtns(){
        return mute
            ? <VolumeOffIcon sx={{color: 'white', '&:hover': {color: 'blue'}}} onClick={() => setMute(!mute)} />
            : volume <= 20 ? <VolumeMuteIcon sx={{color: 'lime', '&:hover': {color: 'white'}}} onClick={() => setMute(!mute)} />
            : volume <= 75 ? <VolumeDownIcon sx={{color: 'lime', '&:hover': {color: 'white'}}} onClick={() => setMute(!mute)} />
            : <VolumeUpIcon sx={{color: 'lime', '&:hover': {color: 'white'}}} onClick={() => setMute(!mute)} />
    }

    return (
        <Div>
            
            <audio src={currentSong} ref={audioPlayer} muted={mute} />
            <QueueBar>
                Next in queue
                <div>
                    next song
                </div>
            </QueueBar>
            <CustomPaper>
                <Box sx={{display: 'flex', justifyContent: 'space-between'}}>
                    <Stack direction='row' spacing={1} 
                        sx={{
                            display: 'flex',
                            justifyContent: 'flex-start',
                            width: '25%',
                            alignItems: 'center'
                        }}
                    >
                        <VolumeBtns  />

                        <PSlider min={0} max={100} value={volume}
                            onChange={(e, v) => setVolume(v)}
                        />
                    </Stack>

                    <Stack direction='row' spacing={1}
                        sx={{
                            display: 'flex',
                            width: '40%',
                            alignItems: 'center'
                        }}>
                        <SkipPreviousIcon 
                            sx={{
                                color: 'white', 
                                '&:hover': {color:'lime'}
                            }} 
                            onClick={toggleSkipBackward} disabled={true}/>
                        <FastRewindIcon sx={{color: 'white', '&:hover': {color: 'lime'}}} onClick={toggleBackward}/>

                        {!isPlaying
                            ?   <PlayArrowIcon fontSize={'large'} sx={{color: 'white', '&:hover': {color: 'lime'}}} onClick={togglePlay}/>
                            :   <PauseIcon fontSize={'large'} sx={{color: 'white', '&:hover': {color: 'lime'}}} onClick={togglePlay}/>
                        }


                        <FastForwardIcon sx={{color: 'white', '&:hover': {color: 'lime'}}} onClick={toggleForward} />
                        <SkipNextIcon sx={{color: 'white', '&:hover': {color: 'lime'}}} onClick={toggleSkipForward}/>
                    </Stack>

                    <Stack sx={{
                        display: 'flex',
                        justifyContent: 'flex-end',
                    }} />
                </Box>
                <Stack spacing={1} direction='row' sx={{
                    display: 'flex',
                    alignItems: 'center'
                }}>
                    <Typography sx={{color: 'white'}}>{formatTime(elapsed)}</Typography>
                    <PSlider thumbless value={elapsed} max={duration} />
                    <Typography sx={{color: 'white'}}>{formatTime(duration - elapsed)}</Typography>
                </Stack>
            </CustomPaper>
            <video autoPlay loop muted style={{ position: 'absolute', top: 0, left: 0, width: '100%', height: '100%', objectFit: 'cover', zIndex: -1, opacity: 1 }}>
                <source src={MyVideo} type="video/mp4" />
            </video>
            
        </Div>
    )
}
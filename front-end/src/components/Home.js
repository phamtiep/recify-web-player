import React from 'react'
import { NavLink } from 'react-router-dom'
import "../components/home.css";
function Home() {
  return (
<section class="pt-24 homepage">
    <div class="px-12 mx-auto max-w-7xl">
        <div class="w-full mx-auto text-left md:w-11/12 xl:w-9/12 md:text-center">
            <h1 class="mb-8 text-4xl font-extrabold leading-none tracking-normal text-white md:text-6xl md:tracking-tight">
                <span>Start</span> <span> discover your favourite music </span>
            </h1>
            <p className="px-0 mb-8 text-lg text-white md:text-xl lg:px-24 text-animation">
                 Welcome to Recify - your ultimate destination for all things music! 
            </p>
            <div class="mb-4 space-x-0 md:space-x-8 md:mb-8">
                <NavLink to={"/player"}>
                    
                    <a href="#_" class="inline-flex items-center justify-center w-full px-10 py-10 mb-2 text-xl text-white bg-gray-600 rounded-2xl sm:w-auto sm:mb-0">
                        Player
                    </a>
                    
                </NavLink>
                <NavLink to={"/player"}>
                    
                    <a href="#_" class="inline-flex items-center justify-center w-full px-10 py-10 mb-2 text-xl text-white bg-gray-600 rounded-2xl sm:w-auto sm:mb-0">
                        Player
                    </a>
                    
                </NavLink>
                <NavLink to={"/player"}>
                    
                    <a href="#_" class="inline-flex items-center justify-center w-full px-10 py-10 mb-2 text-xl text-white bg-gray-600 rounded-2xl sm:w-auto sm:mb-0">
                        Player
                    </a>
                    
                </NavLink>
            </div>
        </div>
    </div>
</section>
  )
}

export default Home
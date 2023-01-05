import React, { Fragment, useState } from 'react'
import { Link, useNavigate } from 'react-router-dom';
import './Player.css'


const Player = ({ player, addPlayer }) => {


    const url = "/players/" + player.id;

    let navPlayer = useNavigate();
    function handlePlayerClick() {
        navPlayer(url);
    }

    const handleChange = () => {
        player.selected = !player.selected
        addPlayer(player)
    }

    return (
        <>

            <article id='article'>
                <input type="checkbox" id="article-input" onChange={handleChange} />
                <div id='article-div'>
                    {player.name}
                </div>

            </article>




        </>



    )
}

export default Player;


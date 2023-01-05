import React, { useState } from 'react';
import "./PlayerSelection.css"
import Player from './Player';

import { Link } from 'react-router-dom';


const PlayerSelection = ({ players, onCreate, addPlayer, populateTournament, getSeeding }) => {

    const [statePlayer, setStatePlayer] = useState(
        {
            name: "",
            rating: 1200,
        }
    )

    const allPlayers = players.map((player, index) => {

        return (<div className='player-btns'>
            <Player
                player={player}
                key={player.id}
                addPlayer={addPlayer} />
        </div>)
    })

    const handleChange = function (event) {
        let propertyName = event.target.name;
        let copiedPlayer = { ...statePlayer }
        copiedPlayer[propertyName] = event.target.value;
        setStatePlayer(copiedPlayer)
    }

    const handleSubmit = function (event) {
        event.preventDefault();
        onCreate(statePlayer)
    }

    const handleClick = () => {
        populateTournament()
    }

    const handleChangeSeeding = (event) => {

        console.log(event.target.value)
        if (event.target.value == "Random") {
            getSeeding(false)
        }
        else {
            getSeeding(true)
        }
    }

    return (
        <>

            <h3>Select Players:</h3>

            <div id='conatainer'>
                {allPlayers}
            </div>
            <form onSubmit={handleSubmit}>
                <input
                    id='input-name-box'
                    className="input-box"
                    type="text"
                    placeholder="Enter Player Name"
                    name="name"
                    value={statePlayer.name}
                    onChange={handleChange}
                    required minLength="1" />
                <button id='button-general' className='add-btn' type="add-new-player">Add</button>

            </form>

            <div onChange={handleChangeSeeding}>
                <h3>Seeding:</h3>
                <input type="radio" id="Random" name="drone" value="Random" >
                </input><label>Unseeded</label>
                <input type="radio" id="Seeded" name="drone" value="Seeded">
                </input><label>Seeded</label>
            </div>

            <Link to="/tournament/show"><button id='button-general' onClick={handleClick} >Generate Tournament</button></Link>
        </>
    )
}

export default PlayerSelection;
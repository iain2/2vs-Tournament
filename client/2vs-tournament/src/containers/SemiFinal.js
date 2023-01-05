import React from "react";
import Game from "../components/Game/Game";


const SemiFinal = ({ players, getfinalist, updatePlayer }) => {


    return (
        <div id='round'>
            <div id='semi-final'>

                <Game name={"Semi-Final"} gameNumber={0} player1={players[0]} player2={players[1]} getWinners={getfinalist} updatePlayer={updatePlayer} />
                <Game name={"Semi-Final"} gameNumber={1} player1={players[2]} player2={players[3]} getWinners={getfinalist} updatePlayer={updatePlayer} />
            </div>
        </div>
    )


}

export default SemiFinal;
import React from "react";
import Game from "../components/Game/Game";


const Round16 = ({ players, getQuarterFinalists, updatePlayer }) => {


    return (
        <div id='round'>

            <Game name={"Round of 16"} gameNumber={0} player1={players[0]} player2={players[1]} getWinners={getQuarterFinalists} updatePlayer={updatePlayer} />
            <Game name={"Round of 16"} gameNumber={1} player1={players[2]} player2={players[3]} getWinners={getQuarterFinalists} updatePlayer={updatePlayer} />
            <Game name={"Round of 16"} gameNumber={2} player1={players[4]} player2={players[5]} getWinners={getQuarterFinalists} updatePlayer={updatePlayer} />
            <Game name={"Round of 16"} gameNumber={3} player1={players[6]} player2={players[7]} getWinners={getQuarterFinalists} updatePlayer={updatePlayer} />
            <Game name={"Round of 16"} gameNumber={4} player1={players[8]} player2={players[9]} getWinners={getQuarterFinalists} updatePlayer={updatePlayer} />
            <Game name={"Round of 16"} gameNumber={5} player1={players[10]} player2={players[11]} getWinners={getQuarterFinalists} updatePlayer={updatePlayer} />
            <Game name={"Round of 16"} gameNumber={6} player1={players[12]} player2={players[13]} getWinners={getQuarterFinalists} updatePlayer={updatePlayer} />
            <Game name={"Round of 16"} gameNumber={7} player1={players[14]} player2={players[15]} getWinners={getQuarterFinalists} updatePlayer={updatePlayer} />
        </div>
    )


}

export default Round16

    ;
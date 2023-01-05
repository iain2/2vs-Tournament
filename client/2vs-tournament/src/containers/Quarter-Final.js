import React from "react";
import Game from "../components/Game/Game";


const QuarterFinal = ({ players, getSemiFinalists, updatePlayer }) => {


    return (
        <div id='round'>

            <Game name={"Quarter-Final"} gameNumber={0} player1={players[0]} player2={players[1]} getWinners={getSemiFinalists} updatePlayer={updatePlayer} />
            <Game name={"Quarter-Final"} gameNumber={1} player1={players[2]} player2={players[3]} getWinners={getSemiFinalists} updatePlayer={updatePlayer} />
            <Game name={"Quarter-Final"} gameNumber={2} player1={players[4]} player2={players[5]} getWinners={getSemiFinalists} updatePlayer={updatePlayer} />
            <Game name={"Quarter-Final"} gameNumber={3} player1={players[6]} player2={players[7]} getWinners={getSemiFinalists} updatePlayer={updatePlayer} />
        </div>
    )


}

export default QuarterFinal;
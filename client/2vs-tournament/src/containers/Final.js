import React from "react";
import Game from "../components/Game/Game";

const Final = ({ finalists, saveTournament, updatePlayer }) => {

    function handleFinalGame() {
        console.log("Picked a winner")
        saveTournament();
    }
    return (
        <div id="round">
            <Game name={"Final"} player1={finalists[0]} player2={finalists[1]} handleFinalGame={handleFinalGame} updatePlayer={updatePlayer} />
        </div>
    )


}

export default Final;
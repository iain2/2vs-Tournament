import React, { useEffect } from "react";
import { useState } from "react";

const Game = ({ player1, player2, name, getWinners, handleFinalGame, updatePlayer, gameNumber }) => {

    const [complete, setComplete] = useState(false)

    const changeRatings = (winner, loser) => {
        var d = winner.rating + loser.rating;
        var p = winner.rating / d;

        var d1 = 1 - p;
        var d2 = 32 * d1;
        winner.rating += d2;
        loser.rating -= d2;
        return [winner, loser];
    }

    const winner1 = () => {

        if (name !== "Final") {
            if (complete == false) {
                if (player1.name === "BYE") {
                    return
                }
                let playerList = changeRatings(player1, player2)
                updatePlayer(playerList[0])
                updatePlayer(playerList[1])
                getWinners(playerList[0], gameNumber)
                setComplete(true)
            }
            return
        }

        handleFinalGame()
        let playerList = changeRatings(player1, player2)
        updatePlayer(playerList[0])
        updatePlayer(playerList[1])
        setComplete(true)

    }
    const winner2 = () => {
        if (name !== "Final") {
            if (complete == false) {
                if (player1.name != "BYE") {
                    let playerList = changeRatings(player2, player1)
                    updatePlayer(playerList[0])
                    updatePlayer(playerList[1])
                    getWinners(playerList[0], gameNumber)
                }
                else {
                    getWinners(player2, gameNumber)
                }
                setComplete(true)
            }
            return
        }

        handleFinalGame()
        let playerList = changeRatings(player1, player2)
        updatePlayer(playerList[0])
        updatePlayer(playerList[1])
        setComplete(true)

    }

    let gameStyle = "game"
    let buttonStyle = 'button'
    if (complete == true) {
        gameStyle = "game-complete"
        buttonStyle = "button-complete"
    }





    return (
        <div id={gameStyle}>
            <h2 className="game-title"> {name}</h2>
            <div id='game-details'>
                <button id={buttonStyle} onClick={winner1}>{player1["name"]} </button>
                <h4>Vs.</h4>
                <button id={buttonStyle} onClick={winner2}>{player2["name"]}</button>
            </div>
        </div>
    )


}

export default Game;
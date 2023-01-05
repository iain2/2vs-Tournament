import React from "react";
import PlayerSelection from '../components/players/PlayerSelection';


const TournamentContainer = ({ players, onCreate, addPlayer, populateTournament, getSeeding }) => {

    return (
        <>

            <PlayerSelection players={players} onCreate={onCreate} addPlayer={addPlayer} populateTournament={populateTournament} getSeeding={getSeeding} />
        </>
    )

}

export default TournamentContainer;
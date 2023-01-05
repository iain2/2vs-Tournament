
import React from "react";
import { useState, useEffect } from "react";
import Final from "./Final";
import QuarterFinal from "./Quarter-Final";
import SemiFinal from "./SemiFinal";
import Round16 from "./Round16";





const ShowTournamentContainer = ({ finalists, semiFinalists, quarterFinalists,
    getSemiFinalists, getfinalists, selectedPlayers, saveTournament, round16, getQuarterFinalists, updatePlayer }) => {





    return (
        <div id='tournament'>
            {selectedPlayers.length > 8 ? <Round16 players={round16} getQuarterFinalists={getQuarterFinalists} updatePlayer={updatePlayer} /> : null}
            {selectedPlayers.length > 4 ? <QuarterFinal players={quarterFinalists} getSemiFinalists={getSemiFinalists} updatePlayer={updatePlayer} /> : null}
            {selectedPlayers.length > 2 ? <SemiFinal players={semiFinalists} getfinalist={getfinalists} updatePlayer={updatePlayer} /> : null}
            {selectedPlayers.length > 1 ? <Final finalists={finalists} saveTournament={saveTournament} updatePlayer={updatePlayer} /> : null}

        </div >

    )
}

export default ShowTournamentContainer;
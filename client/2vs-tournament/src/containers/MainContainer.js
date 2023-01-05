import React, { useEffect, useState } from 'react';
import './MainContainer.css';
import HomePageContainer from './HomePageContainer';
import TournamentContainer from './TournamentContainer'
import { BrowserRouter as Router, Routes, Route, useParams } from 'react-router-dom';
import Header from '../components/Header/Header';
import PlayerDetail from '../components/players/PlayerDetail';
import Request from "../helpers/request";
import ShowTournamentContainer from './ShowTournament';
import About from '../components/About/About';




const MainContainer = () => {

  const [players, setPlayers] = useState([])
  const [selectedPlayers, setSelectedPlayers] = useState([])
  const [round16, setRound16] = useState([{ name: "" }, { name: "" }, { name: "" }, { name: "" }, { name: "" }, { name: "" }, { name: "" }, { name: "" }, { name: "" }, { name: "" }, { name: "" }, { name: "" }, { name: "" }, { name: "" }, { name: "" }, { name: "" }])
  const [quarterFinalists, setQurterFinalists] = useState([{ name: "" }, { name: "" }, { name: "" }, { name: "" }, { name: "" }, { name: "" }, { name: "" }, { name: "" }])
  const [finalists, setFinalists] = useState([{ name: "" }, { name: "" }])
  const [semiFinalists, setSemiFinalists] = useState([{ name: "" }, { name: "" }, { name: "" }, { name: "" }])
  const [seeding, setSeeding] = useState(false);



  useEffect(() => {
    getPlayers()
  }, [])

  const getPlayers = () => {
    fetch("http:///localhost:8080/api/players")
      .then(res => res.json())
      .then(playersData => setPlayers(playersData))
  }

  const createPlayer = (player) => {
    console.log("create player called", player);
    const request = new Request();
    request.post("http://localhost:8080/api/players", player)
      .then(() => window.location = '/tournament')
  }

  const updatePlayer = (player) => {
    console.log("update player called", player);
    const request = new Request();
    request.put("http://localhost:8080/api/players/{player.id}", player)

  }

  const handleDelete = (id) => {
    const request = new Request();
    const url = "http://localhost:8080/api/players/" + id;
    request.delete(url).then(() => {
      window.location = '/tournament';
    });
  }

  const findPlayerById = (id) => {
    return players.find((player) => {
      return player.id === parseInt(id);
    })
  }

  const PlayerDetailWrapper = () => {
    const { id } = useParams();
    let foundPlayer = findPlayerById(id)
    return <PlayerDetail player={foundPlayer} handleDelete={handleDelete} />;
  }

  const addPlayer = (player) => {
    let selectedPlayersCopy = [...selectedPlayers];
    selectedPlayersCopy.push(player)
    let filteredSelectedPlayers = selectedPlayersCopy.filter(player => player.selected === true);
    setSelectedPlayers(filteredSelectedPlayers)
  }

  const getSeeding = (seeding) => {
    setSeeding(seeding)
  }

  const sortPlayers = (players) => {

    if (seeding) {
      return players.sort((a, b) => parseFloat(b.rating) - parseFloat(a.rating))
    }
    else {
      return players.sort(() => Math.random() - 0.5)
    }


  }

  const populateTournament = () => {


    const BYE = {
      name: "BYE",
      rating: 0,
    }
    const selectedPlayersRandom = sortPlayers(selectedPlayers)

    let data = {
      "name": "React Test",
      "noOfRounds": 2,
      "players": selectedPlayers
    }

    const request = new Request();
    request.post("http://localhost:8080/api/tournaments", data)

    if (selectedPlayers.length == 2) {

      setFinalists(selectedPlayersRandom)
      return
    }
    if (selectedPlayers.length < 4) {
      let c = 4 - selectedPlayers.length
      for (let i = 0; i < c; i++) {
        selectedPlayersRandom.splice(i * 2, 0, BYE)
      }
    }
    if (selectedPlayers.length == 4) {
      let sortedPlayers = [selectedPlayersRandom[0],
      selectedPlayersRandom[3],
      selectedPlayersRandom[1],
      selectedPlayersRandom[2]
      ]
      setSemiFinalists(sortedPlayers)
      return
    }
    if (selectedPlayers.length < 8) {
      let c = 8 - selectedPlayers.length
      for (let i = 0; i < c; i++) {
        selectedPlayers.splice(i * 2, 0, BYE)
      }
      if (seeding) {
        let sortedPlayers = sortPlayers(selectedPlayers)
      }
    }
    if (selectedPlayers.length == 8) {
      let sortedPlayers = [selectedPlayersRandom[0],
      selectedPlayersRandom[7],
      selectedPlayersRandom[3],
      selectedPlayersRandom[4],
      selectedPlayersRandom[2],
      selectedPlayersRandom[5],
      selectedPlayersRandom[1],
      selectedPlayersRandom[6]
      ]
      setQurterFinalists(sortedPlayers)
      return
    }

    if (selectedPlayers.length < 16) {
      let c = 16 - selectedPlayers.length
      for (let i = 0; i < c; i++) {
        selectedPlayers.splice(i * 2, 0, BYE)
      }
      if (seeding) {
        let sortedPlayers = sortPlayers(selectedPlayers)
      }
    }
    if (selectedPlayers.length == 16) {
      let sortedPlayers = [selectedPlayersRandom[0],
      selectedPlayersRandom[15],
      selectedPlayersRandom[7],
      selectedPlayersRandom[8],
      selectedPlayersRandom[4],
      selectedPlayersRandom[11],
      selectedPlayersRandom[3],
      selectedPlayersRandom[12],
      selectedPlayersRandom[2],
      selectedPlayersRandom[13],
      selectedPlayersRandom[5],
      selectedPlayersRandom[10],
      selectedPlayersRandom[6],
      selectedPlayersRandom[9],
      selectedPlayersRandom[1],
      selectedPlayersRandom[14]
      ]
      setRound16(sortedPlayers)
      return
    }

    return
  }

  const getfinalists = (winner, gameNumber) => {

    const finalistsCopy = [...finalists]
    finalistsCopy[gameNumber] = winner
    setFinalists(finalistsCopy)
    return
  }

  const getSemiFinalists = (winner, gameNumber) => {
    const semiFinalistsCopy = [...semiFinalists]
    semiFinalistsCopy[gameNumber] = winner
    setSemiFinalists(semiFinalistsCopy)
    return

  }


  const getQuarterFinalists = (winner, gameNumber) => {
    const quarterFinalistsCopy = [...quarterFinalists]
    quarterFinalistsCopy[gameNumber] = winner
    setQurterFinalists(quarterFinalistsCopy)
    return

  }


  function saveTournament(winner) {
    console.log("This is save tournament")
    console.log(selectedPlayers)
    console.log(quarterFinalists)
    console.log(semiFinalists)
    console.log(finalists)
    let data = {
      "name": "React Test",
      "noOfRounds": 2
    }
    const request = new Request();
    request.post("http://localhost:8080/api/tournaments", data)
  }



  return (
    <>

      <Router>
        <Header />

        <Routes>
          {/*  ___________________________________________HOME______________________________________________________ */}
          <Route path="/" element={

            <HomePageContainer />} />


          {/*  ___________________________________________TOURNAMENT_________________________________________________*/}

          <Route path='/tournament' element={

            <TournamentContainer
              players={players}
              onCreate={createPlayer}
              addPlayer={addPlayer}
              populateTournament={populateTournament}
              getSeeding={getSeeding} />} />


          <Route path="/tournament/show" element={<ShowTournamentContainer selectedPlayers={selectedPlayers} finalists={finalists}
            semiFinalists={semiFinalists} quarterFinalists={quarterFinalists} getSemiFinalists={getSemiFinalists}
            getfinalists={getfinalists} saveTournament={saveTournament} round16={round16} getQuarterFinalists={getQuarterFinalists} updatePlayer={updatePlayer} />} />


          {/*  ___________________________________________PLAYER_________________________________________________*/}

          <Route path="/players/:id" element={

            <PlayerDetailWrapper />} />

          {/*  ___________________________________________ABOUT_________________________________________________*/}


          <Route path="/about" element={
            <About />} />

        </Routes>
      </Router>
    </>
  )

}

export default MainContainer;
// This file contains configuration settings for the game, such as initial values for game parameters.

const settings = {
    boardSize: {
        rows: 20,
        cols: 20
    },
    initialLives: {
        runner: 3,
        chaser: 1
    },
    gameSpeed: 100, // milliseconds between game updates
    maxMoves: 50,
    colors: {
        runner: "#32CD32", // LimeGreen
        chaser: "#FF4500"  // OrangeRed
    },
    level: 1
};

export default settings;
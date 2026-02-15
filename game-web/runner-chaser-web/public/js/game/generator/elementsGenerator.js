// This file contains functions to generate game elements based on the current level and board size.

function generateElements(board, level) {
    const elements = [];
    const numberOfRunners = Math.floor(Math.random() * (level * 2)) + 1; // 1 to level * 2 runners
    const numberOfChasers = Math.floor(Math.random() * (level * 2)) + 1; // 1 to level * 2 chasers

    for (let i = 0; i < numberOfRunners; i++) {
        const runner = new Runner(); // Assuming Runner is defined in runner.js
        elements.push(runner);
    }

    for (let i = 0; i < numberOfChasers; i++) {
        const chaser = new Chaser(); // Assuming Chaser is defined in chaser.js
        elements.push(chaser);
    }

    return elements;
}
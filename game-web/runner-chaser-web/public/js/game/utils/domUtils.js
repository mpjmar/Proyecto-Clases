// This file provides utility functions for manipulating the DOM, such as updating the display of the game state.

function updateGameStateDisplay(runners, chasers) {
    const runnersElement = document.getElementById('runners-count');
    const chasersElement = document.getElementById('chasers-count');

    if (runnersElement) {
        runnersElement.textContent = runners;
    }

    if (chasersElement) {
        chasersElement.textContent = chasers;
    }
}

function clearBoardDisplay() {
    const boardElement = document.getElementById('game-board');
    if (boardElement) {
        boardElement.innerHTML = '';
    }
}

function renderBoardElement(element) {
    const boardElement = document.getElementById('game-board');
    if (boardElement) {
        const elementDiv = document.createElement('div');
        elementDiv.className = element.className; // Assuming each element has a className property
        elementDiv.style.position = 'absolute';
        elementDiv.style.left = `${element.x}px`; // Assuming elements have x and y properties
        elementDiv.style.top = `${element.y}px`;
        boardElement.appendChild(elementDiv);
    }
}
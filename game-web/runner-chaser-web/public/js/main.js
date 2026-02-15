const ROWS = 10;
const COLS = 10;

function createBoard(rows, cols) {
    const boardElement = document.getElementById('board');
    // limpiar por si acaso
    boardElement.innerHTML = '';

    // opcional: si quieres que el grid sea dinámico según filas/columnas:
    boardElement.style.gridTemplateColumns = `repeat(${cols}, 30px)`;
    boardElement.style.gridTemplateRows = `repeat(${rows}, 30px)`;

    for (let r = 0; r < rows; r++) {
        for (let c = 0; c < cols; c++) {
            const cell = document.createElement('div');
            cell.classList.add('cell');
            // más adelante: guardar posición, tipo de elemento, etc.
            cell.dataset.row = r;
            cell.dataset.col = c;
            boardElement.appendChild(cell);
        }
    }
}

window.addEventListener('DOMContentLoaded', () => {
    createBoard(ROWS, COLS);

    const startButton = document.getElementById('start-button');
    startButton.addEventListener('click', () => {
        // aquí más adelante arrancaremos la lógica del juego
        document.getElementById('status').textContent = 'Game started!';
    });
});

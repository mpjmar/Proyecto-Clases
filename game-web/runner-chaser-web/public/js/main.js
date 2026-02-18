
// Calcula ROWS y COLS según el tamaño de la pantalla y un tamaño mínimo de celda
function adjustBoardSize() {
    const minCellSize = 12;
    const maxCells = 60;
	const cellSize = 12;

    const viewportWidth  = window.innerWidth;
    const viewportHeight = window.innerHeight;
    const availableW = Math.max(200, viewportWidth * 0.75);
    const availableH = Math.max(200, viewportHeight * 0.75);

    let maxCols = Math.floor(availableW / minCellSize);
    let maxRows = Math.floor(availableH / minCellSize);

    maxCols = Math.max(10, Math.min(maxCols, maxCells));
    maxRows = Math.max(10, Math.min(maxRows, maxCells));

    colsInput.max = maxCols;
    rowsInput.max = maxRows;

    if (!userCols || userCols > maxCols) userCols = maxCols;
    if (!userRows || userRows > maxRows) userRows = maxRows;

    COLS = userCols;
    ROWS = userRows;

    boardElement.style.setProperty('--grid-cols', COLS);
    boardElement.style.setProperty('--grid-rows', ROWS);

	boardElement.style.width  = (COLS * cellSize) + "px";
	boardElement.style.height = (ROWS * cellSize) + "px";

    colsInput.value = COLS;
    rowsInput.value = ROWS;

    const total = ROWS * COLS;
    const approxMaxEntities = Math.floor(total * 0.5);
    immuneInput.max = approxMaxEntities;
    virusInput.max = approxMaxEntities;
}

// Tipos de celda
const CELL = {
    EMPTY:   0,
    OBST:    1,
    IMMUNE:  2, // antes Runner
    VIRUS:   3, // antes Chaser
    HEALER:  4,
    SPEEDER: 5
};

let board = [];
let running = false;
let loopId = null;       // id del setInterval
let speedMs = 300;       // milisegundos entre pasos
let userRows = null;
let userCols = null;

const immuneCountSpan = document.getElementById('immune-count');
const virusCountSpan  = document.getElementById('virus-count');
const statusText      = document.getElementById('status');
const boardElement    = document.getElementById('board');
const speedRange      = document.getElementById('speed-range');
const immuneInput     = document.getElementById('immune-input');
const virusInput      = document.getElementById('virus-input');
const rowsInput = document.getElementById('rows-input');
const colsInput = document.getElementById('cols-input');

// Crear tablero vacío
function createEmptyBoard(rows, cols) {
    const b = [];
    for (let r = 0; r < rows; r++) {
        const row = new Array(cols).fill(CELL.EMPTY);
        b.push(row);
    }
    return b;
}

function populateBoard(b) {
    const total = ROWS * COLS;

    // Unos cuantos “muros”
    for (let i = 0; i < total * 0.1; i++) { // 10% de obstáculos
        const r = Math.floor(Math.random() * ROWS);
        const c = Math.floor(Math.random() * COLS);
        b[r][c] = CELL.OBST;
    }

    // Leer valores pedidos por el usuario
    let desiredImmune = Number(immuneInput.value || 0);
    let desiredVirus  = Number(virusInput.value || 0);

    // Asegurar que no pedimos más de las celdas libres
    const maxEntities = Math.max(0, total - Math.floor(total * 0.1)); // aprox sin muros
    const totalRequested = desiredImmune + desiredVirus;
    if (totalRequested > maxEntities) {
        const factor = maxEntities / totalRequested;
        desiredImmune = Math.floor(desiredImmune * factor);
        desiredVirus  = Math.floor(desiredVirus * factor);
    }

    // Células inmunes
    for (let i = 0; i < desiredImmune; i++) {
        let r, c, tries = 0;
        do {
            r = Math.floor(Math.random() * ROWS);
            c = Math.floor(Math.random() * COLS);
            tries++;
            if (tries > total * 2) break;
        } while (b[r][c] !== CELL.EMPTY);
        if (b[r][c] === CELL.EMPTY) {
            b[r][c] = CELL.IMMUNE;
        }
    }

    // Virus
    for (let i = 0; i < desiredVirus; i++) {
        let r, c, tries = 0;
        do {
            r = Math.floor(Math.random() * ROWS);
            c = Math.floor(Math.random() * COLS);
            tries++;
            if (tries > total * 2) break;
        } while (b[r][c] !== CELL.EMPTY);
        if (b[r][c] === CELL.EMPTY) {
            b[r][c] = CELL.VIRUS;
        }
    }

    // Healers y Speeders: p.ej. un 10% del total de entidades pedidas
    const extraTotal = Math.floor((desiredImmune + desiredVirus) * 0.1);
    const desiredHealers  = Math.floor(extraTotal / 2);
    const desiredSpeeders = extraTotal - desiredHealers;

    // Healers
    for (let i = 0; i < desiredHealers; i++) {
        let r, c, tries = 0;
        do {
            r = Math.floor(Math.random() * ROWS);
            c = Math.floor(Math.random() * COLS);
            tries++;
            if (tries > total * 2) break;
        } while (b[r][c] !== CELL.EMPTY);
        if (b[r][c] === CELL.EMPTY) {
            b[r][c] = CELL.HEALER;
        }
    }

    // Speeders
    for (let i = 0; i < desiredSpeeders; i++) {
        let r, c, tries = 0;
        do {
            r = Math.floor(Math.random() * ROWS);
            c = Math.floor(Math.random() * COLS);
            tries++;
            if (tries > total * 2) break;
        } while (b[r][c] !== CELL.EMPTY);
        if (b[r][c] === CELL.EMPTY) {
            b[r][c] = CELL.SPEEDER;
        }
    }
}

// Pintar tablero en el DOM
function renderBoard(b) {
    boardElement.innerHTML = '';
    boardElement.style.setProperty('--grid-cols', COLS);
    boardElement.style.setProperty('--grid-rows', ROWS);

    let immuneCount = 0;
    let virusCount  = 0;

    for (let r = 0; r < ROWS; r++) {
        for (let c = 0; c < COLS; c++) {
            const cellDiv = document.createElement('div');
            cellDiv.classList.add('cell');
            cellDiv.dataset.row = r;
            cellDiv.dataset.col = c;

            const value = b[r][c];
            switch (value) {
                case CELL.OBST:
                    cellDiv.classList.add('obstacle');
                    break;
                case CELL.IMMUNE:
                    cellDiv.classList.add('immune');
                    immuneCount++;
                    break;
                case CELL.VIRUS:
                    cellDiv.classList.add('virus');
                    virusCount++;
                    break;
                case CELL.HEALER:
                    cellDiv.classList.add('healer');
                    break;
                case CELL.SPEEDER:
                    cellDiv.classList.add('speeder');
                    break;
            }

            boardElement.appendChild(cellDiv);
        }
    }

    immuneCountSpan.textContent = immuneCount;
    virusCountSpan.textContent  = virusCount;
}

// Demo de “un paso de simulación”: de momento solo mueve aleatoriamente
function stepSimulation() {
    const newBoard = createEmptyBoard(ROWS, COLS);

    for (let r = 0; r < ROWS; r++) {
        for (let c = 0; c < COLS; c++) {
            const value = board[r][c];
            if (
				value === CELL.OBST ||
				value === CELL.EMPTY ||
				value === CELL.HEALER ||
				value === CELL.SPEEDER
			) {
				if (value !== CELL.EMPTY) {
					newBoard[r][c] = value;
				}
				continue;
			}

            // movimiento aleatorio sencillo (luego se sustituye por tu IA)
            const moves = [
                [0, 0],
                [-1, 0], [1, 0],
                [0, -1], [0, 1]
            ];
            const [dr, dc] = moves[Math.floor(Math.random() * moves.length)];
            const nr = Math.max(0, Math.min(ROWS - 1, r + dr));
            const nc = Math.max(0, Math.min(COLS - 1, c + dc));

            // no pasar por obstáculo
            if (board[nr][nc] === CELL.OBST) {
                newBoard[r][c] = value;
            } else {
                newBoard[nr][nc] = value;
            }
        }
    }

    board = newBoard;
}

// Iniciar el bucle con el intervalo actual
function startLoop() {
    if (loopId !== null) clearInterval(loopId);
    loopId = setInterval(() => {
        if (!running) return;
        stepSimulation();
        renderBoard(board);
    }, speedMs);
}

// Controles
function startGame() {
    if (running) return;
    running = true;
    statusText.textContent = 'Simulation running...';
    startLoop();
}

function pauseGame() {
    running = false;
    statusText.textContent = 'Paused';
}

function resetGame() {
    if (loopId !== null) {
        clearInterval(loopId);
        loopId = null;
    }
    running = false;
    statusText.textContent = 'Ready';

    board = createEmptyBoard(ROWS, COLS);
    populateBoard(board);   // ← usa immuneInput / virusInput actuales
    renderBoard(board);
}

// Cambio de velocidad desde el slider
function updateSpeedFromSlider() {
    const val = Number(speedRange.value); // 1..5
    // mapeo simple: 1 -> lento, 5 -> rápido
    // por ejemplo 1:800ms, 3:300ms, 5:100ms
    const map = {
        1: 800,
        2: 500,
        3: 300,
        4: 180,
        5: 100
    };
    speedMs = map[val] ?? 300;
    if (running) {
        startLoop(); // reinicia el intervalo con la nueva velocidad
    }
}

function updateBoardFromSizeInputs() {
    if (running) return;

    let r = Number(rowsInput.value);
    let c = Number(colsInput.value);

    if (r < 10) r = 10;
    if (c < 10) c = 10;

    if (r > Number(rowsInput.max)) r = Number(rowsInput.max);
    if (c > Number(colsInput.max)) c = Number(colsInput.max);

    userRows = r;
    userCols = c;

    adjustBoardSize();
    board = createEmptyBoard(ROWS, COLS);
    populateBoard(board);
    renderBoard(board);
}

function regenerateFromInputs() {
    if (running) return; // para no romper una simulación en marcha
    board = createEmptyBoard(ROWS, COLS);
    populateBoard(board);
    renderBoard(board);
}

window.addEventListener('DOMContentLoaded', () => {
    adjustBoardSize();
    board = createEmptyBoard(ROWS, COLS);
    populateBoard(board);
    renderBoard(board);
    statusText.textContent = 'Ready';

    document.getElementById('btn-start').addEventListener('click', startGame);
    document.getElementById('btn-pause').addEventListener('click', pauseGame);
    document.getElementById('btn-reset').addEventListener('click', resetGame);
    speedRange.addEventListener('input', updateSpeedFromSlider);
    updateSpeedFromSlider();

    immuneInput.addEventListener('change', regenerateFromInputs);
    virusInput.addEventListener('change', regenerateFromInputs);
	rowsInput.addEventListener('change', updateBoardFromSizeInputs);
	colsInput.addEventListener('change', updateBoardFromSizeInputs);

    window.addEventListener('resize', () => {
        if (running) return;
        adjustBoardSize();
        board = createEmptyBoard(ROWS, COLS);
        populateBoard(board);
        renderBoard(board);
    });
});

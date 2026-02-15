class Board {
    constructor(rows, cols) {
        this.rows = rows;
        this.cols = cols;
        this.grid = this.createGrid();
    }

    createGrid() {
        return Array.from({ length: this.rows }, () => Array(this.cols).fill(null));
    }

    placeElement(element, row, col) {
        if (this.isValidPosition(row, col)) {
            this.grid[row][col] = element;
        }
    }

    removeElement(row, col) {
        if (this.isValidPosition(row, col)) {
            this.grid[row][col] = null;
        }
    }

    isValidPosition(row, col) {
        return row >= 0 && row < this.rows && col >= 0 && col < this.cols;
    }

    render() {
        const boardElement = document.getElementById('game-board');
        boardElement.innerHTML = '';
        this.grid.forEach(row => {
            const rowElement = document.createElement('div');
            rowElement.className = 'board-row';
            row.forEach(cell => {
                const cellElement = document.createElement('div');
                cellElement.className = 'board-cell';
                if (cell) {
                    cellElement.innerText = cell.getSymbol();
                }
                rowElement.appendChild(cellElement);
            });
            boardElement.appendChild(rowElement);
        });
    }
}
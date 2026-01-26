package board;

import boardElements.*;
import utils.*;

public class Board {

	private int rows;
	private int cols;
	private int[][] board;

	public Board(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		board = new int[rows][cols];
	}

	public int[][] getBoard() {
		return this.board;
	}

	public void setObstacles(int rows, int cols, int level) {
		int totalCells = rows * cols;
		int obstacles = level == 1 ? totalCells / 10 : level == 2 ? totalCells / 6 : totalCells / 4;
		for (int i = 0; i < obstacles; i++) {
			int row = Utils.generateRandom(0, rows);
			int col = Utils.generateRandom(0, cols);
			if (Utils.isEmpty(board, col, row))
				this.board[row][col] = 1;
		}
	}

	@Override
	public String toString() {
		String map = "";

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				map += switch (board[i][j]) {
					case 0 -> " ";
					case 1 -> BoardElement.getSymbol(1);
					case 2 -> BoardElement.getSymbol(2);
					case 3 -> BoardElement.getSymbol(3);
					case 4 -> BoardElement.getSymbol(4);
					default -> "";
				};
			}
			map += "\n";
		}
		return map;
	}
}

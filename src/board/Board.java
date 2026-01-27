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
			if (Utils.isEmpty(board, row, col))
				this.board[row][col] = 1;
		}
	}

	@Override
	public String toString() {
		String map = "\n";
		map += displayLines();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				map += "| " + switch (board[i][j]) {
					case 0 -> Utils.getSymbol(0);
					case 1 -> Utils.getSymbol(1);
					case 2 -> Utils.getSymbol(2);
					case 3 -> Utils.getSymbol(3);
					case 4 -> Utils.getSymbol(4);
					default -> "";
				};
			}
			map += "|\n" + displayLines();
		}
		return map;
	}

	private String displayLines() {
		String map = "";
		for (int i = 0; i < board[0].length; i++)
			map += " ---";
		map += "\n";
		return map;
	}
}

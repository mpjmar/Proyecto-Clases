package board;

import boardElements.*;

public class Board {

	private BoardElement[][] b;
	
	public Board(int height, int width) {
		b = new BoardElement[height][width];
	}

	public BoardElement[][] getBoard() {
		return this.b;
	}

	public void setObstacles(int rows, int cols) {
		int number = (int)(Math.random()).........
	}

	@Override
	public String toString() {
		String map = "";

		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[i].length; j++) {
				if (b[i][j] == null)
					map += " ";
				else 
					map += b[i][j].getSymbol();
			}
			map += "\n";
		}
		return map;
	}
}

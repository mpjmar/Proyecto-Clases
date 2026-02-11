package utils;

public class Position implements Comparable<Position> {
	
	private int row;
	private int col;
	private int dist;

	public Position() {
		this.row = 0;
		this.col = 0;
		this.dist = 0;
	}

	public Position(int row, int col) {
		this.row = row;
		this.col = col;
		this.dist = 0;
	}

	public int getRow() {
		return this.row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return this.col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public int getDist() {
		return this.dist;
	}

	public void setDist(Position pos) {
		this.dist = Math.abs(this.getRow() - pos.getRow()) + Math.abs(this.getCol() - pos.getCol());
	}

	@Override
	public String toString() {
		return "Position: row " + this.row + "| col " + this.col + "\n";
	}

	@Override
	public int compareTo(Position pos) {
		int compareDist = Integer.compare(this.dist, pos.dist);
		if (compareDist != 0)
			return compareDist;

		int distRow = Math.abs(this.row - pos.row);
		int distCol = Math.abs(this.col - pos.col);
		if (distRow > distCol)
			return Integer.compare(this.row, pos.row);
		else if (distRow < distCol)
			return Integer.compare(this.col, pos.col);
		return 0;
	}

	/* // Manhattan distance
	public static int calcDistance(Position p1, Position p2) {
		return Math.abs(p1.getRow() - p2.getRow()) + Math.abs(p1.getCol() - p2.getCol());
	} */

}

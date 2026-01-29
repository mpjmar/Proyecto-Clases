package utils;

public class Position {
	
	private int row;
	private int col;

	public Position(int row, int col) {
		this.col = col;
		this.row = row;
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

	@Override
	public String toString() {
		return "Position: row " + this.row + "| col " + this.col + "\n";
	}
}

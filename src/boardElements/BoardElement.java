package boardElements;

import utils.*;

public abstract class BoardElement {
	
	Position pos;
	private String symbol;

	public BoardElement() {
		this.pos = new Position(0, 0);
		this.symbol = "";
	}
	
	public BoardElement(int row, int col) {
		this.pos = new Position(row, col);
		this.symbol = "";
	}

	public Position getPos() {
		return pos;
	}

	public void setPos(Position pos) {
		this.pos = pos;
	}

	public void setPos(int row, int col) {
		this.pos.setRow(row);
		this.pos.setCol(col);
	}

	public int getRow() {
		return pos.getRow();
	}

	public void setRow(int row) {
		this.pos.setRow(row);
	}

	public int getCol() {
		return pos.getCol();
	}

	public void setCol(int col) {
		this.pos.setCol(col);
	}

	public String getSymbol() {
		return this.symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

}

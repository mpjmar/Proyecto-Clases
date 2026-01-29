package boardElements;

import utils.*;

public abstract class BoardElement {
	
	Position pos;
	private String symbol;
	
	public BoardElement(int row, int col) {
		this.pos = new Position(row, col);
		this.symbol = "";
	}

	public String getSymbol() {
		return this.symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
}

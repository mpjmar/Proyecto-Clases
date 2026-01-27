package boardElements;

import utils.*;

public abstract class BoardElement {
	
	Position pos;

	
	public BoardElement(int row, int col) {
		this.pos = new Position(row, col);
	}

}

package boardElements;

import board.Board;
import java.util.ArrayList;
import utils.ListUtils;
import utils.Position;
import utils.Utils;

public class Chaser extends Role implements Target {

	private Target target;
	Position prevPos;
    
	/* public Chaser() {
		super(0, 0);
		this.target = null;
	} */

	public Chaser(int row, int col) {
		super(row, col);
		this.target = null;
		this.prevPos = new Position(row, col);
	}

	public Target getTarget() {
		return this.target;
	}

	public void setTarget(ArrayList<BoardElement> gameElements) {
		int minDist = Integer.MAX_VALUE;
		Target target = null;
		for (BoardElement e : gameElements) {
			if (e instanceof Runner) {
				int dist = Position.calcDistance(this.getPos(), e.getPos());
				if (dist < minDist) {
					minDist = dist;
					target = (Target) e;
				}
			}
		}
		this.target = target;
	}

	public Position getPrevPos() {
		return prevPos;
	}

	@Override
	public void setPos(int row, int col) {
		this.prevPos = new Position(getRow(), getCol());
		super.setPos(row, col);
	}

	@Override
	public void setPos(Position pos) {
		this.prevPos = new Position(getRow(), getCol());
		super.setPos(pos);
	}
}

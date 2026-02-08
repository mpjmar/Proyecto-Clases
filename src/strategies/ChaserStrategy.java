package strategies;

import java.util.ArrayList;

import board.Board;
import boardElements.BoardElement;
import boardElements.Chaser;
import utils.MovUtils;
import utils.Position;

public class ChaserStrategy {
 
	public static void moveChaser(ArrayList<BoardElement> gameElements, Board board, Chaser c) {
		Position bestPos = calcBestPos(gameElements, board, c);
		c.setRow(bestPos.getRow());
		c.setCol(bestPos.getCol());
		c.setPos(c.getRow(), c.getCol());
	}
    
	/* public static Position calcBestPos(ArrayList<BoardElement> gameElements, Board board, Chaser c) {
		Position[] avalPos = {
			new Position(c.getRow(), c.getCol() + 1),
			new Position(c.getRow() + 1, c.getCol()),
			new Position(c.getRow(), c.getCol() - 1),
			new Position(c.getRow() - 1, c.getCol()),
		};
		
		int minDist = Integer.MAX_VALUE;
		Position bestPos = null;
		for (Position p : avalPos) {
			if (c.getTarget() != null && MovUtils.isWithinLimits(board, p) && MovUtils.isEmpty(gameElements, p.getRow(), p.getCol())) {
				int dist = Position.calcDistance(c.getTarget().getPos(), p);
				if (dist < minDist) {
					minDist = dist;
					bestPos = new Position(p.getRow(), p.getCol());
				}
			}
		}
		if (bestPos == null) {
			do {
				bestPos = MovUtils.randomPos(c.getPos());
			} while (!(MovUtils.isWithinLimits(board, bestPos) && MovUtils.isEmpty(gameElements, bestPos.getRow(), bestPos.getCol())));
		}
		return bestPos;
	} */

	private static Position calcBestPos(ArrayList<BoardElement> gameElements, Board board, Chaser c) {
		Position bestPos = null;
		int mov = 0;
		int distRow = 0;
		int distCol = 0;

		if (c.getTarget() != null) {
			distRow = c.getTarget().getRow() - c.getRow();
			distCol = c.getTarget().getCol() - c.getCol();
		}
		if (Math.abs(distRow) > Math.abs(distCol)) {
			mov = distRow > 0 ? 1 : -1;
			bestPos = new Position(c.getRow() + mov, c.getCol());
		}
		else /* if (Math.abs(distRow) < Math.abs(distCol)) */ {
			mov = distCol > 0 ? 1 : -1;
			bestPos = new Position(c.getRow(), c.getCol() + mov);
		}
		if (bestPos == null || !(MovUtils.isWithinLimits(board, bestPos) && MovUtils.isEmpty(gameElements, bestPos.getRow(), bestPos.getCol()))) {
			do {
				bestPos = MovUtils.randomPos(c.getPos());
			} while (!(MovUtils.isWithinLimits(board, bestPos) && MovUtils.isEmpty(gameElements, bestPos.getRow(), bestPos.getCol())));
		}
		
		return bestPos;
	}
}

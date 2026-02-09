package strategies;

import java.util.ArrayList;

import board.Board;
import boardElements.BoardElement;
import boardElements.Chaser;
import boardElements.Runner;
import utils.MovUtils;
import utils.Position;

public class ChaserStrategy {
 
	public static void moveChaser(ArrayList<BoardElement> gameElements, Board board, Chaser c) {
		Position bestPos = calcBestPos(gameElements, board, c);
		c.setRow(bestPos.getRow());
		c.setCol(bestPos.getCol());
		c.setPos(c.getRow(), c.getCol());
	}
    
	public static Position calcBestPos(ArrayList<BoardElement> gameElements, Board board, Chaser c) {
		Position[] avalPos = {
			new Position(c.getRow(), c.getCol() + 1),
			new Position(c.getRow() + 1, c.getCol()),
			new Position(c.getRow(), c.getCol() - 1),
			new Position(c.getRow() - 1, c.getCol()),
		};
		
		int minDist = Integer.MAX_VALUE;
		Position bestPos = null;
		for (Position p : avalPos) {
			if (c.getTarget() != null && isValid(gameElements, board, p)) {
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
	}

	/* private static Position calcBestPos(ArrayList<BoardElement> gameElements, Board board, Chaser c) {
		Position bestPos = null;
		Position rowMov = null;
		Position colMov = null;
		int distRow = 0;
		int distCol = 0;

		if (c.getTarget() != null) {
			distRow = c.getTarget().getRow() - c.getRow();
			distCol = c.getTarget().getCol() - c.getCol();
		}

		rowMov = moveRow(c, distRow);
		colMov = moveCol(c, distCol);

		if (Math.abs(distRow) > Math.abs(distCol)) {
			if (isValid(gameElements, board, rowMov))
				bestPos = rowMov;
			else if (isValid(gameElements, board, colMov))
				bestPos = colMov;
		}
		else if (Math.abs(distCol) > Math.abs(distRow)) {
			if (isValid(gameElements, board, colMov))
				bestPos = colMov;
			else if (isValid(gameElements, board, rowMov))
				bestPos = rowMov;
		}
		if (bestPos == null) {
			do {
				bestPos = MovUtils.randomPos(c.getPos());
			} while (bestPos == null || !isValid(gameElements, board, bestPos));
		}
		return bestPos;
	} */

	private static Position moveRow(Chaser c, int distRow) {
		int mov = distRow > 0 ? 1 : -1;
		return new Position(c.getRow() + mov, c.getCol());
	}

	private static Position moveCol(Chaser c, int distCol) {
		int mov = distCol > 0 ? 1 : -1;
		return new Position(c.getRow(), c.getCol() + mov);
	}

	private static boolean isValid(ArrayList<BoardElement> gameElements, Board board, Position pos) {
		return MovUtils.isWithinLimits(board, pos) && MovUtils.isEmpty(gameElements, pos.getRow(), pos.getCol());
	}
}

package strategies;

import board.Board;
import boardElements.BoardElement;
import boardElements.Chaser;
import java.util.ArrayList;
import java.util.Collections;

import utils.MovUtils;
import utils.Position;

public class ChaserStrategy {

	public static void chooseNextPos(ArrayList<BoardElement> gameElements, Board board, Chaser c) {
		Position bestPos = calcBestPos(gameElements, board, c);
		c.setNextPos(bestPos.getRow(), bestPos.getCol());
	}

	public static Position calcBestPos(ArrayList<BoardElement> gameElements, Board board, Chaser c) {

		int minDist = Integer.MAX_VALUE;
		Position bestPos = null;
		int distRow = 0;
		int distCol = 0;

		ArrayList<Position> avalPos = new ArrayList<Position>();
	
		avalPos.add(new Position(c.getRow(), c.getCol() + 1));
		avalPos.add(new Position(c.getRow(), c.getCol() - 1));
		avalPos.add(new Position(c.getRow() + 1, c.getCol()));
		avalPos.add(new Position(c.getRow() - 1, c.getCol()));
		
		for (Position p : avalPos) {
			if (c.getTarget() != null) {
				if (MovUtils.isWithinLimits(board, p) && !MovUtils.isObstacle(gameElements, p.getRow(), p.getCol()))
					p.setDist(c.getTarget().getPos());
				else 
					avalPos.remove(p);
			}
		}
		Collections.sort(avalPos);
		for (Position p : avalPos) {
			if (c.getTarget() != null && MovUtils.isEmpty(gameElements, p.getRow(), p.getCol())) {
				return p;
				
		}




		// ----------------------------------------------		

		/* Position[] avalPos = {
			new Position(c.getRow(), c.getCol() + 1),
			new Position(c.getRow(), c.getCol() - 1),
			new Position(c.getRow() + 1, c.getCol()),
			new Position(c.getRow() - 1, c.getCol()),
		}; */
		
		/* int minDist = Integer.MAX_VALUE;
		Position bestPos = null;
		int distRow = 0;
		int distCol = 0;
		for (Position p : avalPos) {
			if (c.getTarget() != null && MovUtils.isWithinLimits(board, p) && !MovUtils.isObstacle(gameElements, p.getRow(), p.getCol())) {
				p.setDist(c.getTarget().getPos());
				minDist = minDist < p.getDist() ? minDist : p.getDist();
			}
		}
		for (Position p : avalPos) {
			if (c.getTarget() != null && p.getDist() == minDist) {
				distRow = Math.abs(c.getTarget().getRow() - p.getRow());
				distCol = Math.abs(c.getTarget().getCol() - p.getCol());
			}
			if (distRow > distCol)
				moveRow 
				bestPos = 
			else
				moveCol
		} */


	
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
			} while (!(isValid(gameElements, board, bestPos)));
		}
		return bestPos;
	}
		
	
	// ----------------------------------------------

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
		return MovUtils.isWithinLimits(board, pos) && !MovUtils.isObstacle(gameElements, pos.getRow(), pos.getCol());
	}
}

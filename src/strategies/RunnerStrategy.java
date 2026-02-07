package strategies;

import java.util.ArrayList;

import board.Board;
import boardElements.BoardElement;
import boardElements.Runner;
import utils.MovUtils;
import utils.Position;


public class RunnerStrategy {

	public static void moveRunner(ArrayList<BoardElement> gameElements, Board board, Runner r) {
		Position bestPos = calcBestPos(gameElements, board, r);
		r.setPos(bestPos);
	}
    
	public static Position calcBestPos(ArrayList<BoardElement> gameElements, Board board, Runner r) {
		Position[] avalPos = {
			new Position(r.getRow() - 1, r.getCol()),
			new Position(r.getRow() + 1, r.getCol()),
			new Position(r.getRow(), r.getCol() + 1),
			new Position(r.getRow(), r.getCol() - 1),
		};
		
		int maxDist = 0;
		Position bestPos = null;
		for (Position p : avalPos) {
			if (r.getTarget() != null && MovUtils.isWithinLimits(board, p) && MovUtils.isEmpty(gameElements, p.getRow(), p.getCol()) && MovUtils.isSafe(gameElements, p)) {
				int dist = Position.calcDistance(r.getTarget().getPos(), p);
				if (dist > maxDist) {
					maxDist = dist;
					bestPos = new Position(p.getRow(), p.getCol());
				}
			}
			else {
				do {
					bestPos = MovUtils.randomPos(r.getPos());
				} while (!(MovUtils.isWithinLimits(board, bestPos) && MovUtils.isEmpty(gameElements, bestPos.getRow(), bestPos.getCol())));
			}
		}
		return bestPos;
	}

}

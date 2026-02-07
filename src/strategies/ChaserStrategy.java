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
		c.setPos(bestPos);
	}
    
	public static Position calcBestPos(ArrayList<BoardElement> gameElements, Board board, Chaser c) {
		Position[] avalPos = {
			new Position(c.getRow() - 1, c.getCol()),
			new Position(c.getRow() + 1, c.getCol()),
			new Position(c.getRow(), c.getCol() + 1),
			new Position(c.getRow(), c.getCol() - 1),
		};
		
		int minDist = Integer.MAX_VALUE;
		Position bestPos = null;
		for (Position p : avalPos) {
			if (MovUtils.isWithinLimits(board, p) && MovUtils.isEmpty(board, p)) {
				int dist = Position.calcDistance(c.getPos(), p);
				if (dist < minDist) {
					minDist = dist;
					bestPos = new Position(p.getRow(), p.getCol());
				}
			}
		}
		return bestPos;
	}
}

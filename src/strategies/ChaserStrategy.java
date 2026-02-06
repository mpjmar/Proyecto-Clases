package strategies;

import board.Board;
import boardElements.Chaser;
import utils.Position;
import utils.Utils;

public class ChaserStrategy {
 
	public static void moveChaser(Board board, Chaser c) {
		int rowC = c.getRow();
		int colC = c.getCol();
		int rowT = c.getTarget().getRow();
		int colT = c.getTarget().getCol();

		int distRow = rowC - rowT;
		int distCol = colC - colT;
		Position pos;

	}
}

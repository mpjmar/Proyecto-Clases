package strategies;

import board.Board;
import boardElements.Runner;
import utils.Position;
import utils.Utils;

public class RunnerStrategy {
    
	public static void moveRunner(Board board, Runner r) {
		int rowC = r.getRow();
		int colC = r.getCol();
		int rowT = r.getTarget().getRow();
		int colT = r.getTarget().getCol();

		int distRow = rowC - rowT;
		int distCol = colC - colT;
		Position pos;

		}
	}
}

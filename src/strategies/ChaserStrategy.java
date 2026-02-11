package strategies;

import board.Board;
import boardElements.BoardElement;
import boardElements.Chaser;
import java.util.ArrayList;
import java.util.Collections;
import utils.MovUtils;
import utils.Position;

public class ChaserStrategy {

	public static Position calcBestPos(ArrayList<BoardElement> gameElements, Board board, Chaser c) {

		Position bestPos = null;
		ArrayList<Position> availPos = MovUtils.generatePos(c.getRow(), c.getCol());
		
		if (c.getTarget() != null) {
			for (Position p : availPos) {
				if (MovUtils.isWithinLimits(board, p) && !MovUtils.isObstacle(gameElements, p.getRow(), p.getCol()))
					p.setDist(c.getTarget().getPos());
			}

			availPos.removeIf(p -> !MovUtils.isWithinLimits(board, p) || MovUtils.isObstacle(gameElements, p.getRow(), p.getCol()));
			Collections.sort(availPos, (p1, p2) -> {
				int compareDist = Integer.compare(p1.getDist(), p2.getDist());
				if (compareDist != 0)
					return compareDist;
			
				int distRowNow = Math.abs(c.getRow() - c.getTarget().getPos().getRow());
				int distColNow = Math.abs(c.getCol() - c.getTarget().getPos().getCol());
				int distRow1 = Math.abs(distRowNow - p1.getRow());
				int distCol1 = Math.abs(distColNow - p1.getCol());
				int distRow2 = Math.abs(distRowNow - p2.getRow());
				int distCol2 = Math.abs(distColNow - p2.getCol());

				int max1 = Math.max(distRow1, distCol1);
				int max2 = Math.max(distRow2, distCol2);

				return Integer.compare(max1, max2);
			});

			for (Position p : availPos) {
				if (MovUtils.isEmpty(gameElements, p.getRow(), p.getCol())) {
					bestPos = p;
					break;
				}
			}
		}
		else {
			do {
				bestPos = MovUtils.randomPos(c.getPos());
			} while (!(MovUtils.isValid(gameElements, board, bestPos)));
		}

		// para debuggear!!
		System.out.println("Chaser en " + c.getPos() + " target " + c.getTarget().getPos());
		for (Position p : availPos) {
			System.out.println("  cand " + p + " dist=" + p.getDist());
		}
		System.out.println("Elegida: " + bestPos);
		return bestPos;	
	}
}

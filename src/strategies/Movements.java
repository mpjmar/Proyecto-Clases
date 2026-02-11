package strategies;

import java.util.ArrayList;

import board.Board;
import boardElements.*;
import utils.MovUtils;
import utils.Position;

public class Movements {

	public static void move(ArrayList<BoardElement> gameElements) {
		for (BoardElement e : gameElements) {

			if (e instanceof Role r) {
				System.out.printf("""
						Posicion actual: (%d, %d)
						Posicion siguiente: (%d, %d)
						""",
					r.getRow(), r.getCol(), r.getNextPos().getRow(), r.getNextPos().getCol());
			}

			if (e instanceof Role r && MovUtils.isEmpty(gameElements, r.getNextPos().getRow(), r.getNextPos().getCol()))
				r.setPos(r.getNextPos().getRow(), r.getNextPos().getCol());
			/* else {
				// try another pos;
			} */

		}
	}

	public static void chooseNextPos(ArrayList<BoardElement> gameElements, Board board) {
		Position bestPos = new Position();
		for (BoardElement e : gameElements) {
			if (e instanceof Runner) {
				bestPos = RunnerStrategy.calcBestPos(gameElements, board, (Runner) e);
				((Runner) e).setNextPos(bestPos.getRow(), bestPos.getCol());
			} else if (e instanceof Chaser) {
				bestPos = ChaserStrategy.calcBestPos(gameElements, board, (Chaser) e);
				((Chaser) e).setNextPos(bestPos.getRow(), bestPos.getCol());
			}
		}
	}
}

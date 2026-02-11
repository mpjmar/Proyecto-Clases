package strategies;

import java.util.ArrayList;
import board.Board;
import boardElements.*;
import utils.Position;

public class Movements {

	public static void move(ArrayList<BoardElement> gameElements, Board board) {
		for (BoardElement e : gameElements) {
			if (e instanceof Runner r )
				r.setPos(RunnerStrategy.calcBestPos(gameElements, board, r));
			else if (e instanceof Chaser c)
				c.setPos(ChaserStrategy.calcBestPos(gameElements, board, c));
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

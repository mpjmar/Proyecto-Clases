package strategies;

import java.util.ArrayList;

import board.Board;
import boardElements.*;

public class Movements {

	public static void move(ArrayList<BoardElement> gameElements, Board board) {
		for (BoardElement e : gameElements) {
			if (e instanceof Runner)
				RunnerStrategy.moveRunner(gameElements, board, (Runner) e);
			else if (e instanceof Chaser)
				ChaserStrategy.moveChaser(gameElements, board, (Chaser) e);
			if (un runner esta al lado de un chaser) {
				Fight.fight(runner, chaser);
			}
		}
		updateCharacters(gameElements);
	}

	public static void updateCharacters(ArrayList<BoardElement> gameElements) {
		gameElements.removeIf(e -> e instanceof Role && ((Role) e).getLife() == 0);
	}
}

package strategies;

import java.util.ArrayList;

import boardElements.BoardElement;
import boardElements.Chaser;
import boardElements.Runner;

public class Movements {

	public static void move(ArrayList<BoardElement> gameElements) {
		for (BoardElement e : gameElements) {
			if (e instanceof Runner)
				RunnerStrategy.moveRunner((Runner) e);
			else if (e instanceof Chaser)
				ChaserStrategy.moveChaser((Chaser) e);
		}
	}

	public static void checkSurroundings(ArrayList<BoardElement> gameElements, Character c) {
		
	}
}

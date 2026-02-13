package gameActions;

import java.util.ArrayList;

import boardElements.BoardElement;
import boardElements.Chaser;
import boardElements.Speeder;
import utils.MovUtils;

public class Speed {
	
	public static void speedChasers(ArrayList<BoardElement> elements) {
		for (BoardElement e : elements)
			if (e instanceof Speeder s && MovUtils.isNeighbour(s.getPos(), ((Chaser) e).getPos())) {
				giveSpeed(((Chaser) e));
				((Chaser) e).setSpeedTurns(5);
			}
	}
	
	private static void giveSpeed(Chaser c) {
		c.setSpeed(2);
	}
}

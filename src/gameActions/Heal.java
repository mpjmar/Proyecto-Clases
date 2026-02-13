package gameActions;

import java.util.ArrayList;

import boardElements.BoardElement;

import boardElements.Healer;
import boardElements.Runner;
import utils.MovUtils;

public class Heal {
	
	public static void healRunners(ArrayList<BoardElement> elements) {
		for (BoardElement e : elements)
			if (e instanceof Healer h && MovUtils.isNeighbour(h.getPos(), ((Runner) e).getPos()))
				heal(h, (Runner) e);
	}
	
	private static void heal(Healer h, Runner r) {
		r.setLife(r.getLife() + h.getExtraLife());
		h.setExtraLife(0);
	}
}

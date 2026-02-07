package strategies;

import boardElements.Chaser;
import boardElements.Runner;
import utils.MovUtils;

public class Fight {
	
	public static void fight(Chaser c, Runner r) {
		if (MovUtils.isNeighbour(c.getPos(), r.getPos())) {
			int cLife = c.getLife();
			int rLife = r.getLife();
			int cActualLife = c.getLife() - rLife;
			int rActualLife = r.getLife() - cLife;
			c.setLife(cActualLife > 0 ? cActualLife : 0);
			r.setLife(rActualLife > 0 ? cActualLife : 0);
		}
	}
}

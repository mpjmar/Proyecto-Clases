package strategies;

import java.util.ArrayList;
import boardElements.*;
import utils.MovUtils;

public class Movements {

	public static void move(ArrayList<BoardElement> gameElements) {
		for (BoardElement e : gameElements) {
			if (e instanceof Role r && MovUtils.isEmpty(gameElements, r.getNextPos().getRow(), r.getNextPos().getCol()))
				r.setPos(r.getNextPos().getRow(), r.getNextPos().getCol());
			else {
				// try another pos;
			}

		}
	}
}

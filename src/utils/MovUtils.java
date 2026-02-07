package utils;

import java.util.ArrayList;

import board.Board;
import boardElements.BoardElement;
import boardElements.Chaser;

public class MovUtils {

	public static boolean isEmpty(Board board, Position pos) {
		if (board.getCell(pos) == 0)
			return true;
		return false;
	}

	public static boolean isWithinLimits(Board board, Position pos) {
		if (pos.getRow() >= 0 && pos.getRow() < board.getRows() &&
			pos.getCol() >= 0 && pos.getCol() < board.getCols())
			return true;
		return false;
	}

	public static boolean isSafe(ArrayList<BoardElement> gameElements, Position pos) {
		for (BoardElement e : gameElements)
			if (e instanceof Chaser && isNeighbour(pos, e.getPos()))
				return false;
		return true;
	}

	public static boolean isNeighbour(Position p1, Position p2) {
		if ((Math.abs(p1.getRow() - p2.getRow()) + (Math.abs(p1.getCol() - p2.getCol())) == 1))
			return true;
		return false;
	}

}

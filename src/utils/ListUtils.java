package utils;

import java.util.ArrayList;
import boardElements.BoardElement;

public class ListUtils {
	
	public static boolean isEmpty(ArrayList<BoardElement> gameElements, int row, int col) {
		for (BoardElement e : gameElements) {
			if (e.getRow() == row && e.getCol() == col)
				return false;
		}	
		return true;
	}

	public static int countElements(ArrayList<BoardElement> gameElements, String character) {
		int counter = 0;
		for (BoardElement e : gameElements)
			if (e.getClass().getSimpleName().equals(character))
				counter++;
		return counter;
	}
}

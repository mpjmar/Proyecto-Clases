package utils;

import java.util.ArrayList;

import board.Board;
import boardElements.BoardElement;
import input.*;

public class Utils {
	
	public static int generateRandom(int min, int max) {
		return (int)(Math.random() * (max - min)) + min;
	}

	public static int displayMenu() {
		System.out.print("""
				
			========= MENU =========
			1. Start Game
			2. Set difficulty
			3. Game Mechanics
			4. Exit
			========================

			Select an option: """);
			
			int option = Input.readInteger(1, 4);
			return option;
	}

	public static int displaySubmenu() {
		System.out.print("""
				
			===== DIFFICULTY =====
			1. Easy
			2. Medium
			3. Hard
			======================

			Choose a level: """);

		int level = Input.readInteger(1, 3);
		return level;
	}

	public static void gameMechanics() {
		System.out.println("""
				
			========= GAME MECHANICS =========
			
				""");
	}

	public static boolean isEmpty(ArrayList<BoardElement> gameElements, int row, int col) {
		for (BoardElement e : gameElements) {
			if (e.getRow() == row && e.getCol() == col)
				return false;
		}	
		return true;
	}

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

	public static String displaySymbol(int value) {
		final String GREEN = "\033[0;32m";
		final String RED = "\033[0;31m";
		final String BLUE = "\033[0;34m";
		final String RESET = "\033[0m";

		String symbol = switch(value) {
			case 0 -> "  ";
			case 1 -> "█ ";
			case 2 -> GREEN + "● " + RESET;
			case 3 -> RED + "▲ " + RESET;
			case 4 -> BLUE + "★ " + RESET;
			default -> "";
		};
		return symbol;
	}

	public static int calcDistance(Position p1, Position p2) {
		return Math.abs(p1.getRow() - p2.getRow()) + Math.abs(p1.getCol() - p2.getCol());
	}

	public static int countElements(ArrayList<BoardElement> gameElements, String character) {
		int counter = 0;
		for (BoardElement e : gameElements)
			if (e.getClass().getSimpleName().equals(character))
				counter++;
		return counter;
	}

	public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
	}
}

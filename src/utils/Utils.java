package utils;

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

	public static boolean isEmpty(int[][] board, int row, int col) {
		return board[row][col] == 0;
	}

	public static String getSymbol(int value) {
		String symbol = switch(value) {
			case 0 -> "  ";
			case 1 -> "X ";
			case 2 -> "B ";
			case 3 -> "M ";
			case 4 -> "V ";
			default -> "";
		};
		return symbol;
	}
}

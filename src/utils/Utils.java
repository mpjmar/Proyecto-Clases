package utils;

import input.*;

public class Utils {
	
	public static int generateRandom(int min, int max) {
		return (int)(Math.random() * (max - min + 1)) + min;
	}

	public static void displayMenu() {
		System.out.println("""
				
			========= MENU =========
			1. Start Game
			2. Set difficulty
			2. View Instructions
			3. Exit
			========================

			""");
	}

	public static int displaySubmenu() {
		System.out.println("""
				
			===== DIFFICULTY =====
			1. Easy
			2. Medium
			3. Hard
			======================
			""");
		int level = Input.readInteger(1, 3);
		return level;
	}

	public static void displayInstructions() {
		System.out.println("""
				
			========= INSTRUCTIONS =========
			
				""");
	}

	public static boolean isEmpty(int[][] board, int row, int col) {
		return board[row][col] == 0;
	}


}

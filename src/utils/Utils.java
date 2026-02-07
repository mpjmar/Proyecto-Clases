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

	public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
	}
}

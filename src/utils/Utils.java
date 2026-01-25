package utils;

public class Utils {
	
	public static int generateRandom(int min, int max) {
		return (int)(Math.random() * (max - min + 1)) + min;
	}

	public static void displayMenu() {
		System.out.println("""
				
			========= MENU =========
			1. Start Game
			2. View Instructions
			3. Exit
			========================

			""");
	}

	public static void displayInstructions() {
		System.out.println("""
				
			========= INSTRUCTIONS =========
			
				""");
	}
}

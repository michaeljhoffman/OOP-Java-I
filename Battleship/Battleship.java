import java.util.Scanner;
public class Battleship {
	public static void main(String[] args) {
		System.out.println("Welcome to Battleship!");
		System.out.println("PLAYER 1, ENTER YOUR SHIPS' COORDINATES.");

		for (int i=1; i<=5; i++) {
			System.out.println("Enter ship " + i + " location:");
		}
	}

		// Use this method to print game boards to the console.
		private static void printBattleShip(char[][] player) {
			System.out.print("  ");
			for (int row = -1; row < 5; row++) {
				if (row > -1) {
					System.out.print(row + " ");
				}
				for (int column = 0; column < 5; column++) {
					if (row == -1) {
						System.out.print(column + " ");
					} else {
						System.out.print(player[row][column] + " ");
				}
				System.out.println("");
			}
		}
	}
}
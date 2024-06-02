import java.util.Scanner;
public class Battleship {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int[][] player1ships = new int[5][2];	

		System.out.println("Welcome to Battleship!");
		System.out.println();
		System.out.println("PLAYER 1, ENTER YOUR SHIPS' COORDINATES.");

		for (int i=0; i<5; i++) {
			System.out.println("Enter ship " + (i + 1) + " location:");

			for (int j=0; j<2; j++) {
				while(!in.hasNextInt()) {
					System.out.println("Invalid coordinates. Choose different coordinates.");
					in.next();
				}
					player1ships[i][j] = in.nextInt();
			}			
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
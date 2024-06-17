import java.util.Scanner;

public class Battleship {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		// initialize location boards with default character
		char[][] player1LB = {
			{ '-','-','-','-','-'},
			{ '-','-','-','-','-'},
			{ '-','-','-','-','-'},
			{ '-','-','-','-','-'},
			{ '-','-','-','-','-'}
		};
		char[][] player2LB = {
			{ '-','-','-','-','-'},
			{ '-','-','-','-','-'},
			{ '-','-','-','-','-'},
			{ '-','-','-','-','-'},
			{ '-','-','-','-','-'}
		};

		System.out.println("Welcome to Battleship!");
		System.out.println();

		// take in coordinates from players
		// enter coordinates into location boards
		for (int p=0; p<2; p++){
			System.out.println("PLAYER " + (p+1) + ", ENTER YOUR SHIPS' COORDINATES.");
				for (int i=0; i<5; i++) {
					System.out.println("Enter ship " + (i + 1) + " location:");
					int[][] tempArray = new int[1][2];

					for (int j=0; j<2; j++) {
						while(!in.hasNextInt()) {
							System.out.println("Invalid coordinates. Choose different coordinates.");
							in.next();
						}
						
						tempArray[0][j] = in.nextInt();

					}

					int r = tempArray[0][0];
					int c = tempArray[0][1];

					if (p == 0) {
						player1LB[r][c] = '@';
					} else if (p == 1) {
						player2LB[r][c] = '@';
					}
				}
			if (p == 0) {
				printBattleShip(player1LB);
			} else if (p == 1) {
				printBattleShip(player2LB);
			}
			
			for (int i=0;i<100;i++){
				System.out.println();
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
			}
			System.out.println("");
		}
	}
}
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

		char[][] player1TH = {
			{ '-','-','-','-','-'},
			{ '-','-','-','-','-'},
			{ '-','-','-','-','-'},
			{ '-','-','-','-','-'},
			{ '-','-','-','-','-'}
		};
		char[][] player2TH = {
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

		// gameplay
		Boolean winner = false;
		do {
			for(int p=1; p<=2; p++) {
				int[][] hitCoor = new int[1][2];
				System.err.println("Player " + p + ", enter hit row/column:");

				int r, c;

				hitCoor = checkInput();
				
				r = hitCoor[0][0];
				c = hitCoor[0][1];

				if (p == 1) {

					while(player1TH[r][c] != '-') {
						System.err.println("You already fired on this spot. Choose different coordinates.");
						hitCoor = checkInput();
						r = hitCoor[0][0];
						c = hitCoor[0][1];
					} 

					if (player2LB[r][c]=='@') {
						player2LB[r][c] = 'X';
						player1TH[r][c] = 'X';
						System.out.println("PLAYER 1 HIT PLAYER 2's SHIP!");
						printBattleShip(player1TH);
					} else if (player2LB[r][c]!='@') {
						player2LB[r][c] = 'O';
						player1TH[r][c] = 'O';
						System.out.println("PLAYER 1 MISSED!");
						printBattleShip(player1TH);
					}

				} else if (p == 2) {
					
					while(player2TH[r][c] != '-') {
						System.err.println("You already fired on this spot. Choose different coordinates.");
						hitCoor = checkInput();
						r = hitCoor[0][0];
						c = hitCoor[0][1];
					} 

					if (player1LB[r][c]=='@') {
						player1LB[r][c] = 'X';
						player2TH[r][c] = 'X';
						System.out.println("PLAYER 2 HIT PLAYER 1's SHIP!");
						printBattleShip(player1TH);
					} else if (player1LB[r][c]!='@') {
						player1LB[r][c] = 'O';
						player2TH[r][c] = 'O';
						System.out.println("PLAYER 2 MISSED!");
						printBattleShip(player1TH);
					}

				}

				winner = checkWinner();

				if (winner) {
					break;
				}

			}

		} while(!winner);
	}

	// checkWinner
	private static void checkWinner(char[][] player1TH, char[][] player2Th) {
		int Xcount1 = 0;
		int Xcount2 = 0;
		for (int i=0; i++; i<5){
			for (int j=0; j++; j<5){
				if (player1TH[r][c] == 'X') {
					Xcount1++;
				}
				if (player2TH[r][c] == 'X') {
					Xcount2++;
				}
			}
		}
	}

	// check input validitiy
	private static int[][] checkInput() {
		Scanner in = new Scanner(System.in);
		int[][] tempArray = new int[1][2];
		for (int j=0; j<2; j++) {
			while(!in.hasNextInt()) {
				System.out.println("Invalid coordinates. Choose different coordinates.");
				in.next();
			}
			tempArray[0][j] = in.nextInt();
		}
		
		return tempArray;
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
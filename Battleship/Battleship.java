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
					String prompt = "Enter ship " + (i + 1) + " location:";
					System.out.println(prompt);

					int[][] tempArray = new int[1][2];
												
					tempArray = checkInput(prompt);

					int r = tempArray[0][0];
					int c = tempArray[0][1];

					if (p == 0) {
						while(player1LB[r][c] != '-') {
							System.out.println("You already have a ship there. Choose different coordinates.");
							System.out.println(prompt);
							tempArray = checkInput(prompt);
							r = tempArray[0][0];
							c = tempArray[0][1];
						} 
						player1LB[r][c] = '@';
					} else if (p == 1) {
						while(player2LB[r][c] != '-') {
							System.out.println("You already have a ship there. Choose different coordinates.");
							System.out.println(prompt);
							tempArray = checkInput(prompt);
							r = tempArray[0][0];
							c = tempArray[0][1];
						} 
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
		Boolean p1win = false;
		Boolean p2win = true;

		do {
			for(int p=1; p<=2; p++) {
				int[][] hitCoor = new int[1][2];
				String prompt = "Player " + p + ", enter hit row/column:";
				System.out.println(prompt);

				int r, c;

				hitCoor = checkInput(prompt);
				
				r = hitCoor[0][0];
				c = hitCoor[0][1];

				if (p == 1) {

					while(player1TH[r][c] != '-') {
						System.out.println("You already fired on this spot. Choose different coordinates.");
						System.out.println(prompt);
						hitCoor = checkInput(prompt);
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
						System.out.println("You already fired on this spot. Choose different coordinates.");
						System.out.println(prompt);
						hitCoor = checkInput(prompt);
						r = hitCoor[0][0];
						c = hitCoor[0][1];
					} 

					if (player1LB[r][c]=='@') {
						player1LB[r][c] = 'X';
						player2TH[r][c] = 'X';
						System.out.println("PLAYER 2 HIT PLAYER 1's SHIP!");
						printBattleShip(player2TH);
					} else if (player1LB[r][c]!='@') {
						player1LB[r][c] = 'O';
						player2TH[r][c] = 'O';
						System.out.println("PLAYER 2 MISSED!");
						printBattleShip(player2TH);
						
					}

				}

				p1win = checkWinner(player1TH);
				p2win = checkWinner(player2TH);

				if (p1win || p2win) {
					break;
				}
				System.out.println("");
			}

		} while(!(p1win || p2win));

		if (p1win){
			System.out.println("PLAYER 1 WINS! YOU SUNK ALL OF YOUR OPPONENT'S SHIPS!");
			System.out.println("");
		} else if (p2win){
			System.out.println("PLAYER 2 WINS! YOU SUNK ALL OF YOUR OPPONENT'S SHIPS!");
			System.out.println("");
		}

		System.out.println("Final boards:");
		System.out.println("");
		printBattleShip(player1LB);
		System.out.println("");
		printBattleShip(player2LB);
	}

		

	// checkWinner
	private static boolean checkWinner(char[][] playerTH) {
		int Xcount = 0;

		for (int i=0; i<5; i++){
			for (int j=0; j<5; j++){
				if (playerTH[i][j] == 'X') {
					Xcount++;
				}
			}
		}

		if (Xcount == 5) {
			return true;
		} else {
			return false;
		}
	}


	public static int[][] checkInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        int[][] coordinates = new int[1][2];
        boolean validInput = false;

        while (!validInput) {

            String input = scanner.nextLine();
            String[] parts = input.split(" ");

            if (parts.length == 2) {
                try {
                    int firstInt = Integer.parseInt(parts[0]);
                    int secondInt = Integer.parseInt(parts[1]);

                    if (firstInt >= 0 && firstInt <= 4 && secondInt >= 0 && secondInt <= 4) {
                        coordinates[0][0] = firstInt;
                        coordinates[0][1] = secondInt;
                        validInput = true;
                    } else {
                        System.out.println("Invalid coordinates. Choose different coordinates.");
						System.out.println(prompt);
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid coordinates. Choose different coordinates.");
					System.out.println(prompt);
                }
            } else {
                System.out.println("Invalid coordinates. Choose different coordinates.");
				System.out.println(prompt);
            }
        }

        return coordinates;
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
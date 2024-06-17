import java.util.Scanner;

public class Battleship {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int[][] player1ships = new int[5][2];
		int[][] player2ships = new int[5][2];

		// char[][] player1locationBoard = new char[5][5];
		// char[][] player2locationBoard = new char[5][5];

		System.out.println("Welcome to Battleship!");
		System.out.println();

		// take in coordinates from players
		// for (int p=0; p<2; p++){
		// 	System.out.println("PLAYER " + (p+1) + ", ENTER YOUR SHIPS' COORDINATES.");
		// 	for (int i=0; i<5; i++) {
		// 		System.out.println("Enter ship " + (i + 1) + " location:");
		// 		int[][] tempArray = new int[1][2];

		// 		for (int j=0; j<2; j++) {
		// 			while(!in.hasNextInt()) {
		// 				System.out.println("Invalid coordinates. Choose different coordinates.");
		// 				in.next();
		// 			}
					
		// 			tempArray[0][j] = in.nextInt();

		// 		}

		// 		if (p == 0) {
		// 			player1ships[i] = tempArray[0];
		// 		} else if (p == 1) {
		// 			player2ships[i] = tempArray[0];
		// 		}
		// 	}
		// }

		// initiallize location boards with – as default character
		// for (int i = 0; i<5; i++){
		// 	for (int j = 0; i<5; i++) {
		// 		player1locationBoard[i][j] = '–';
		// 		player2locationBoard[i][j] = '–';
		// 	}
		// }



		// fill location boards with player input
		// for (int i=0; i<5; i++){
		// 	int[][] shipCoor1 = new int[1][2];
		// 	int[][] shipCoor2 = new int[1][2];

		// 	shipCoor1[0] = player1ships[i];
		// 	shipCoor2[0] = player2ships[i];

		// 	player1locationBoard[shipCoor1[0][0] - 1][shipCoor1[0][1] - 1] = '@';
		// 	player2locationBoard[shipCoor2[0][0] - 1][shipCoor2[0][1] - 1] = '@';
		// }

		char[][] player1locationBoard = {
			{ '-','-','-','-','-'},
			{ '-','-','-','-','-'},
			{ '-','-','-','-','-'},
			{ '-','-','-','-','-'},
			{ '-','-','-','-','-'}
		};
		char[][] player2locationBoard = {
			{ '-','-','-','-','-'},
			{ '-','-','-','-','-'},
			{ '-','-','-','-','-'},
			{ '-','-','-','-','-'},
			{ '-','-','-','-','-'}
		};

		printBattleShip(player1locationBoard);
		printBattleShip(player2locationBoard);
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
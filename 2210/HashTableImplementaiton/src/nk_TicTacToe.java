
/*
	 * @Author: David George 
	 * @Student ID: 251004930 
	 * @Class: CS2110
	 */

public class nk_TicTacToe {

	int board_size;
	int inline;
	int max_levels;
	char[][] gameboard;

	public nk_TicTacToe(int board_size, int inline, int max_levels) {

		/*
		 * Initialises a two dimensional array depending on the size given Intilaises
		 * the number of chars required to win, and how many configurations are checked
		 */

		this.board_size = board_size;
		this.inline = inline;
		this.max_levels = max_levels;
		gameboard = new char[board_size][board_size];

		for (int i = 0; i < board_size; i++) {

			for (int j = 0; j < board_size; j++) {

				gameboard[i][j] = ' ';
			}
		}
	}

	/*
	 * Returns an object of type Object
	 */

	public Dictionary createDictionary() {

		Dictionary table = new Dictionary(6007);

		return table;
	}

	public int repeatedConfig(Dictionary configurations) {

		if (configurations != null) {

			/*
			 * Creates the configuration string, checks if its in the hashtable, returns it
			 * if it is
			 */

			String output = "";

			for (int i = 0; i < board_size; i++) {

				for (int j = 0; j < board_size; j++) {

					output = output + gameboard[i][j];

				}
			}

			for (int i = 0; i < configurations.size; i++) {

				if (configurations.table.ChainedHashTable[i] != null) {

					if (configurations.table.ChainedHashTable[i].LinkedStackFind(output)) {

						/*
						 * Creates the configuration string, checks if its in the table returns the
						 * score integer requried
						 */

						return configurations.table.ChainedHashTable[i].LinkedStackGet(output);

					}

				}
			}
		}

		return -1;

	}

	public void insertConfig(Dictionary configurations, int score) {

		String output = "";

		for (int i = 0; i < board_size; i++) {

			for (int j = 0; j < board_size; j++) {

				output = output + gameboard[i][j];

			}
		}

		/*
		 * Creates the configuration string, adds it to the dictionary with the score
		 */

		Record willAdd = new Record(output, score);
		configurations.insert(willAdd);

	}

	public void storePlay(int row, int col, char symbol) {

		/*
		 * stores char in the correct posisiton
		 */

		gameboard[row][col] = symbol;

	}

	public boolean squareIsEmpty(int row, int col) {

		/*
		 * Checks if the gameboard at posisiton is empty
		 */

		if (gameboard[row][col] == ' ') {
			return true;
		}

		return false;
	}

	public boolean wins(char symbol) {

		for (int i = 0; i < board_size; i++) {

			for (int j = 0; j < board_size; j++) {

				/*
				 * This will iterate over each square and will check each possible way to win
				 * Down, Up, Left, Right, left diagonal, right diagonal, and checks for inline
				 * number of chars to see if someone wins Each case calls an auxillary method
				 * which iterates inline number squares to check for a win, if true, the the
				 * method will return true
				 */

				if (down(inline, i, j, symbol)) {

					return true;

				}
				if (up(inline, i, j, symbol)) {
					return true;
				}
				if (left(inline, i, j, symbol)) {
					return true;

				}

				if (right(inline, i, j, symbol)) {
					return true;

				}

				if (rd(inline, i, j, symbol)) {
					return true;

				}

				if (ld(inline, i, j, symbol)) {
					return true;

				}

			}
		}

		/*
		 * It will return false if all methods return false, which means no one wins
		 */

		return false;
	}

	private boolean down(int length, int i, int j, char symbol) {

		/*
		 * Checks the table for length number of symbols in the downward direction
		 */

		if (i + length - 1 > board_size) {
			return false;
		}

		char check = symbol;

		for (int k = 0; k < length; k++) {

			/*
			 * This makes sure nothing is out of bounds
			 */

			if (i + k >= board_size) {
				return false;
			}

			if (gameboard[i + k][j] != check) {
				return false;
			}

		}

		return true;

	}

	private boolean up(int length, int i, int j, char symbol) {

		/*
		 * Checks the table for length number of symbols in the upward direction
		 */

		/*
		 * This makes sure nothing is out of bounds
		 */
		if (i + 1 - length < 0) {
			return false;
		}

		char check = symbol;

		for (int k = 0; k < length; k++) {

			if (gameboard[i - k][j] != check) {
				return false;
			}

		}

		return true;
	}

	private boolean left(int length, int i, int j, char symbol) {

		/*
		 * Checks the table for length number of symbols in the leftward direction
		 */

		/*
		 * This makes sure nothing is out of bounds
		 */
		if (j + 1 - length < 0) {
			return false;
		}

		char check = symbol;

		for (int k = 0; k < length; k++) {

			if (gameboard[i][j - k] != check) {
				return false;
			}

		}

		return true;

	}

	private boolean right(int length, int i, int j, char symbol) {

		if (j + length > board_size) {
			return false;
		}

		char check = symbol;

		for (int k = 0; k < length; k++) {

			if (gameboard[i][j + k] != check) {
				return false;
			}

		}
		return true;
	}

	private boolean rd(int length, int i, int j, char symbol) {
		/*
		 * Checks the table for length number of symbols in right diagonal direction
		 */

		if (i + 1 - length > 0 && j + length <= board_size) {
			return false;
		}

		char check = symbol;

		for (int k = 0; k < length; k++) {

			if (i - k < 0 || j + k > board_size - 1) {
				return false;
			}

			if (gameboard[i - k][j + k] != check) {
				return false;
			}
		}

		return true;

	}

	private boolean ld(int length, int i, int j, char symbol) {

		/*
		 * Checks the table for length number of symbols in left diagonal direction
		 */

		if (i + 1 - length > 0 && j + 1 - length > 0) {
			return false;
		}

		char check = symbol;

		for (int k = 0; k < length; k++) {

			if (i - k < 0 || j - k < 0) {
				return false;
			}

			if (gameboard[i - k][j - k] != check) {
				return false;
			}
		}

		return true;
	}

	public boolean isDraw() {
		for (int i = 0; i < board_size; i++) {
			for (int j = 0; j < board_size; j++) {

				// Iterates over the entire board, if there no possible wins and no one has one
				// won returns true
				// if someone wins it will return false
				if (gameboard[i][j] == ' ' && !wins('O') && !wins('X')) {
					return false;
				}
			}
		}
		return true;
	}

	public int evalBoard() {

		// If O wins it will return 3, if x then 0, if draw then 2, otherwise just 1.
		
		if (wins('X')) {
			return 0;
		}
		
		if (wins('O')) {
			return 3;
		}
		
		if (isDraw()) {
			return 2;
		}
		return 1;

	}

}

package codingInterviewJava;

class NQueen {

	public static void main(String[] args) {
		Board board = new Board();
		solve(board, 0);
		return;
	}

	public static boolean solve(Board board, int row) {
		if (row >= board.matrix.length) {
			board.print();
			// stop recursion, found 1 solution
			return true;
		}
		// I need to place 1 queen in this row
		for (int col = 0; col < board.matrix.length; col++) {
			if (board.isPlaceSafe(row, col)) {
				// choose
				board.place(row, col);

				// explore
				if (solve(board, row + 1)) {
					return true;
				}
				// un-choose
				board.remove(row, col);
			}
		}
		return false;
	}

}

class Board {
	public int matrix[][] = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };

	public void place(int row, int col) {
		matrix[row][col] = 1;
	}

	// remove a queen
	public void remove(int row, int col) {
		matrix[row][col] = 0;
	}

	public void print() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++)
				System.out.print(" " + matrix[i][j] + " ");
			System.out.println();
		}
	}

	public boolean isPlaceSafe(int row_border, int col_border) {
		// check col
		for (int rowIndex = 0; rowIndex < row_border; rowIndex++) {
			if (matrix[rowIndex][col_border] == 1) {
				return false;
			}
		}

		// diagonal
		int col = col_border;
		for (int rowIndex = row_border - 1; rowIndex >= 0; rowIndex--) {
			col++;
			if (col >= matrix.length)
				break;
			if (matrix[rowIndex][col] == 1) {
				return false;
			}
		}

		// diagonal
		col = col_border;
		for (int rowIndex = row_border - 1; rowIndex >= 0; rowIndex--) {
			col--;
			if (col < 0)
				break;
			if (matrix[rowIndex][col] == 1) {
				return false;
			}
		}

		return true;
	}

}
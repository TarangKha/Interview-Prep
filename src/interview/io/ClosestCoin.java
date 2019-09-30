package interview.io;

public class ClosestCoin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] board = {
				{0,0,0,0,0},
				{0,0,0,0,0},
				{0,0,0,0,0},
				{0,0,0,0,0},
				{0,0,0,0,1},
		};
		int rowStart = 0;
		int colStart = 0;
		System.out.println(closestCoin(board, rowStart, colStart));
	}
	
	public static int closestCoin(int[][] board, int rowStart, int colStart) {
		int[] max = {Integer.MAX_VALUE};
		helper(board, rowStart, colStart, 0, max);
		return max[0] != Integer.MAX_VALUE ? max[0] : -1;
	}
	
	public static void helper(int[][] board, int row, int col, int distance, int[] max) {
		if(row < 0 || row >= board.length || col < 0 || col >= board[0].length) {//out of bounds
			return;
		}
		if(board[row][col] == -1) {
			board[row][col] = 0;
			return;
		}
		if(board[row][col] == 1) { //found a coin
			if(distance < max[0]) {
				max[0] = distance;
			}
			return;
		}
		if(distance != Integer.MAX_VALUE && distance > max[0]) { //already farther than another coin
			return;
		}
		board[row][col] = -1;
		helper(board, row+1, col, distance+1, max); //down
		helper(board, row, col+1, distance+1, max); //right
		helper(board, row-1, col, distance+1, max); //up
		helper(board, row, col-1, distance+1, max); //left
		return;
	}

}

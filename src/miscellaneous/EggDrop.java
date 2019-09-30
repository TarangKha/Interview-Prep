package miscellaneous;

/*
 * Problem:
 * 
 * Given N floors and K eggs, using Dynamic Programming,
 * find the least number of drops needed to determine
 * which floor the egg breaks on.

*/
public class EggDrop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(eggDrop(2, 2));

	}
	
	public static int eggDrop(int N, int K) {
		/*
		 * Step 1: Understand the Recurrance Relation aka the subproblem
		 * 	the subproblem here is that at each floor, there are 2 
		 * 	possibilities: the egg breaks and we move down. or the Egg doesn't break
		 * 	and we move up.
		 * 
		 * Step 2: Understand the base cases as layed out by the dp table.
		 * 	the left hand side of the dp table represents the number of eggs we have.
		 * 	the right hand side of the dp table represents the number of floors we have.
		 * 	
		 * 	Base cases: if we have 1 egg, then we must try dropping it on each floor. Therefore 
		 * 				we must do "totalFloors" drops.
		 * 				
		 * 				if we have 0 eggs, then we do 0 drops, because we can't do a drop.
		 * 
		 * 				if we have 1 floor, then we do 1 drop regardless of how many eggs we have.
		 * 				
		 * 				if we have 0 floors, then we do 0 drops, because there is nowhere to drop.
		 * 
		 * Step 3: outline the DP
		 * 				       number of floors
		 *			_ | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 |
		 *			0 | 0	0	0	0	0	0	0	0	0
		 *			1 | 0	1	2	3	4	5	6	7	8
		 *	Eggs	2 | 0	1	
		 *			3 | 0	1
		 * 			4 | 0	1
		 *  		5 | 0	1
		 *  
		 *  Lets write these steps in code.
		 */
		
		if(K == 1) {
			return N;
		}
		
		if(K == 0) {
			return 0;
		}
		
		if(N == 0 || N == 1) {
			return N;
		}
		
		int[][] dp = new int[K+1][N+1]; //the +1's are for the 0th col and row
		
		//since the table is initialized to all 0's (int typing), we have to populate 
		// row 1 and col 1;
		
		for(int i = 1; i <= N; i++) { //populates row 1, by iterating through columns
			dp[1][i] = i;
		}
		
		for(int i = 1; i <= K; i++) { //populates col 1 by iterating through rows
			dp[i][1] = 1;
		}
		
		for(int i = 2; i <= K; i++) {
			for(int j = 2; j <= N; j++) {
				dp[i][j] = Integer.MAX_VALUE;
			}
		}
		
		return helper(K, N, dp);
		/*
		 * Ok so back to understanding the problem:
		 * 	lets examine what each cell of the dp table actually translates into and
		 * 	how we can answer that translation with one of the already filled cells.
		 * 
		 * 	dp[2][2] is the first available free cell. it means that if you had,
		 * 	"2 floors, and 2 eggs, what's the least number of drops it would take
		 * 	to determine the the critical floor".
		 * 
		 * 	the subproblem here reduces back to the possibilities:
		 * 	you drop 1 of two eggs from floor 2 -> it breaks -> go down 1 floor, and one egg.
		 */
	}
	
	public static int helper(int eggs, int floor, int[][] dpTable) {
		if(dpTable[eggs][floor] != Integer.MAX_VALUE) {
			return dpTable[eggs][floor];
		} else {
			dpTable[eggs][floor] = 1 + Math.max(helper(eggs, dpTable[0].length-floor, dpTable), helper(eggs-1, floor-1, dpTable));
			return dpTable[eggs][floor];
		}
	}

}

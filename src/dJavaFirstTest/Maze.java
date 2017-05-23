package dJavaFirstTest;

public class Maze {

	static int MAX_ROW = 3;
	static int MAX_COL = 5;
	static int[][] MAZE_DATA = new int[MAX_ROW][MAX_COL]; // The maze
	static boolean[][] wasHere = new boolean[MAX_ROW][MAX_COL];
	static int[][] correctPath = new int[MAX_ROW][MAX_COL]; // The solution to the  maze
	static int startX = 0; // Starting X and Y values of maze
	static int startY = 0;
	static int endX = 2; 
	static int endY = 3; // Ending X and Y values of maze
	static int totalSpots = 0;

	public static void solveMaze() {
		MAZE_DATA = generateMaze(); // Create Maze (1 = path, 2 = wall)
		for (int row = 0; row < MAZE_DATA.length; row++) {
			for (int col = 0; col < MAZE_DATA[row].length; col++) {
				wasHere[row][col] = false;
				correctPath[row][col] = 0;
				if (MAZE_DATA[row][col] == 2 
						|| MAZE_DATA[row][col] == 0 
						|| MAZE_DATA[row][col] == 3) {
					totalSpots ++;
				}
			}
		}
		int start = 0;
		boolean b = recursiveSolve(startX, startY, start);
		if (b) {
			printMaze(MAZE_DATA);
			System.out.println("========");
			printMaze(correctPath);
			System.out.println("========");
			printMaze(wasHere);
		}
		// Will leave you with a boolean array (correctPath)
		// with the path indicated by true values.
		// If b is false, there is no solution to the maze
	}
	
	public static void printMaze(boolean[][] maze) {
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[i].length; j++) {
				System.out.print(maze[i][j] + " ");
			}
			System.out.println("");
		}

	}
	
	public static void printMaze(int[][] maze) {
		for (int i = 0; i < MAX_ROW; i++) {
			for (int j = 0; j < MAX_COL; j++) {
				System.out.print(maze[i][j] + " ");
			}
			System.out.println("");
		}

	}


	private static int[][] generateMaze() {
		int[][] result = {  { 2, 0, 0, 0, 0 },
							{ 0, 0, 0, 0, 0 }, 
							{ 0, 0, 0, 3, 1 } };
		return result;
	}
	private static int countSpotinMaze(int [][] maze) {
		int result = 0;
		for (int i = 0; i < MAX_ROW; i++) {
			for (int j = 0; j < MAX_COL; j++) {
				if (maze[i][j] == 2 || maze[i][j] == 0 || maze[i][j] == 3) {
					result ++;
				}
			}
		}
		return result;
	}
	private static int countWasHere(boolean[][] maze) {
		int result = 0;
		for (int i = 0; i < MAX_ROW; i++) {
			for (int j = 0; j < MAX_COL; j++) {
				if (maze[i][j]) {
					result ++;
				}
			}
		}
		return result;
	}

	public static boolean recursiveSolve(int x, int y, int point) {
		if (x == endX && y == endY ) {
			if (countWasHere(wasHere) == totalSpots) {
				return true; // If you reached the end
			} else {
				//return false; 
			}
		}
		if (MAZE_DATA[x][y] == 1 || wasHere[x][y])
			return false;
		// If you are on a wall or already were here
		wasHere[x][y] = true;
		point ++;
		if (x != 0) // Checks if not on left edge
			if (recursiveSolve(x - 1, y, point)) { // Recalls method one to the left
				correctPath[x][y] = point; // Sets that path value to true;
				return true;
			}
		if (x != MAX_ROW - 1) // Checks if not on right edge
			if (recursiveSolve(x + 1, y, point)) { // Recalls method one to the right
				correctPath[x][y] = point;
				return true;
			}
		if (y != 0) // Checks if not on top edge
			if (recursiveSolve(x, y - 1, point)) { // Recalls method one up
				correctPath[x][y] = point;
				return true;
			}
		if (y != MAX_COL - 1) // Checks if not on bottom edge
			if (recursiveSolve(x, y + 1, point)) { // Recalls method one down
				correctPath[x][y] = point;
				return true;
			}
		
		return false;
	}

	public static void main(String[] args) {
		solveMaze();
	}

}

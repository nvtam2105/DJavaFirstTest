package dJavaFirstTest;

public class DJavaFirstTest {

	static int MAX_WIDTH = 5;
	static int MAX_HEIGHT = 3;
	static int[][] maze = { { 2, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 3, 1 } };

	static int beginI = 0;
	static int beginJ = 0;
	static int totalSpots = 0;

	public static void main(String[] args) {
		// boolean test1 = firstCharIsUpperCase.firstCharIsUpperCase("ADfDsdf");
		// System.out.println(test1);
		// boolean test2 = firstCharIsUpperCase.firstCharIsUpperCase("Wdfasdf");
		// System.out.println(test2);
		// boolean test3 = firstCharIsUpperCase.firstCharIsUpperCase("^Dfasdf");
		// System.out.println(test3);
		// boolean test4 = firstCharIsUpperCase.firstCharIsUpperCase("");
		// System.out.println(test4);
		// boolean test5 = firstCharIsUpperCase.firstCharIsUpperCase(null);
		// System.out.println(test5);
		// boolean test6 = firstCharIsUpperCase.firstCharIsUpperCase(" ");
		// System.out.println(test6);
		// System.out.println(Utils.getNumberFilesOf(new
		// File("/Users/tam/Downloads")));

		/// COUNT

		printMaze(maze);
		for (int i = 0; i < MAX_HEIGHT; i++) {
			for (int j = 0; j < MAX_WIDTH; j++) {
				if (maze[i][j] == 2) { // start
					beginI = i;
					beginJ = j;
				}
				if (maze[i][j] == 0) {
					totalSpots++;
				}

			}
		}
		int start = 2;
		int[][] cloneMaze = cloneMaze(maze);
		visit(cloneMaze, beginI, beginJ, start);
		System.out.println("=============Result============");
		printMaze(cloneMaze);

	}

	public static int[][] cloneMaze(int[][] maze) {
		int[][] result = new int[MAX_HEIGHT][MAX_WIDTH];
		for (int i = 0; i < MAX_HEIGHT; i++) {
			for (int j = 0; j < MAX_WIDTH; j++) {
				result[i][j] = maze[i][j];
			}
		}
		return result;

	}

	public static void printMaze(int[][] maze) {
		for (int i = 0; i < MAX_HEIGHT; i++) {
			for (int j = 0; j < MAX_WIDTH; j++) {
				System.out.print(maze[i][j] + " ");
			}
			System.out.println("");
		}

	}

	public static void visit(int[][] maze, int i, int j, int start) {
		if (maze[i][j] == 3) {
			return;
		}
		if (maze[i][j] != 2) {
			maze[i][j] = start + 1;
		}
		
		if (i - 1 >= 0 && maze[i - 1][j] != 5 && (maze[i - 1][j] == 0 || maze[i - 1][j] == 3)) {
			visit(maze, i - 1, j, maze[i][j]);
		}
		if (i + 1 < MAX_HEIGHT && maze[i + 1][j] != 5 && (maze[i + 1][j] == 0 || maze[i + 1][j] == 3)) {
			visit(maze, i + 1, j, maze[i][j]);
		}

		if (j - 1 >= 0 && maze[i][j - 1] != 5 && (maze[i][j - 1] == 0 || maze[i][j - 1] == 3)) {
			visit(maze, i, j - 1, maze[i][j]);
		}
		if (j + 1 < MAX_WIDTH && maze[i][j + 1] != 5 && (maze[i][j + 1] == 0 || maze[i][j + 1] == 3)) {
			visit(maze, i, j + 1, maze[i][j]);
		}
		

	}

}

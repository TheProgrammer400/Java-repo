import java.util.Scanner;

public class RatMaze {

    // Print the solution matrix
    public static void printSolution(int[][] sol, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(" " + sol[i][j] + " ");
            }

            System.out.println();
        }
    }

    // Check if maze[x][y] is safe to visit
    public static boolean isSafe(int[][] maze, int x, int y, int n) {
        return (x >= 0 && x < n && y >= 0 && y < n && maze[x][y] == 1);
    }

    
    // Recursive utility function
    public static boolean solveMazeUtil(int[][] maze, int x, int y, int[][] sol, int n) {
        // If destination is reached
        if (x == n - 1 && y == n - 1 && maze[x][y] == 1) {
            sol[x][y] = 1;
            return true;
        }
        
        // Check if current cell is safe
        if (isSafe(maze, x, y, n)) {
            sol[x][y] = 1;
            
            // Move Down
            if (solveMazeUtil(maze, x + 1, y, sol, n)){
                return true;
            }
            
            // Move Right
            if (solveMazeUtil(maze, x, y + 1, sol, n)){
                return true;
            }
            
            // Move Up
            if (solveMazeUtil(maze, x - 1, y, sol, n)){
                return true;
            }
            
            // Move Left
            if (solveMazeUtil(maze, x, y - 1, sol, n)){
                return true;
            }
            
            // Backtrack
            sol[x][y] = 0;
        }
        
        return false;
    }

    // Wrapper function
    public static boolean solveMaze(int[][] maze, int n) {
        int[][] sol = new int[n][n];

        if (!solveMazeUtil(maze, 0, 0, sol, n)) {
            System.out.println("Solution doesn't exist");
            return false;
        }

        printSolution(sol, n);
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the maze (N x N): ");
        int n = sc.nextInt();

        int[][] maze = new int[n][n];
        System.out.println("Enter the maze matrix (only 0s and 1s):");

        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                maze[i][j] = sc.nextInt();
            }
        }

        solveMaze(maze, n);
        sc.close();
    }
}

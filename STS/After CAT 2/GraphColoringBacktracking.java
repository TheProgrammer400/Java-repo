public class GraphColoringBacktracking{

    final int V = 4; // Number of vertices

    // Adjacency matrix representation of the graph
    int[][] graph = {
        {0, 1, 1, 1},
        {1, 0, 1, 0},
        {1, 1, 0, 1},
        {1, 0, 1, 0}
    };

    // Print the colors assigned to all vertices
    void printSolution(int[] color){
        System.out.println("Solution Exists: Following are the assigned colors:");
        for (int i = 0; i < V; i++) {
            System.out.println("Vertex " + i + " ---> Color " + color[i]);
        }
    }

    // Check if assigning color c to vertex v is safe
    boolean isSafe(int v, int[][] graph, int[] color, int c) {
        for (int i = 0; i < V; i++) {
            if (graph[v][i] == 1 && color[i] == c) {
                return false; // Adjacent vertex has same color
            }
        }
        return true;
    }

    // Recursive utility function
    boolean graphColoringUtil(int[][] graph, int m, int[] color, int v) {

        // Base case: all vertices are assigned
        if (v == V) {
            return true;
        }

        // Try assigning each color from 1 to m
        for (int c = 1; c <= m; c++) {
            if (isSafe(v, graph, color, c)) {
                color[v] = c;

                // Recur to assign colors to next vertices
                if (graphColoringUtil(graph, m, color, v + 1)) {
                    return true;
                }

                // Backtrack
                color[v] = 0;
            }
        }

        return false; // No color can be assigned
    }

    // Main function to solve graph coloring problem
    boolean graphColoring(int m) {
        int[] color = new int[V];

        if (!graphColoringUtil(graph, m, color, 0)) {
            System.out.println("Solution does not exist for " + m + " colors");
            return false;
        }

        printSolution(color);
        return true;
    }

    public static void main(String[] args) {
        GraphColoringBacktracking gc = new GraphColoringBacktracking();

        // Try increasing number of colors until a valid solution is found
        for (int m = 1; m <= gc.V; m++) {
            System.out.println("Trying with " + m + " color(s):");
            if (gc.graphColoring(m)) {
                break;
            }
        }
    }
}

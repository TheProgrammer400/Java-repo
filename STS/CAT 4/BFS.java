import java.util.*;

class BFS{

    public static void bfs(int start, List<List<Integer>> adj, int n){

        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        visited[start] = true;

        while(!q.isEmpty()){

            int node = q.poll();
            System.out.print(node + " ");

            for(int i = 0; i < adj.get(node).size(); i++){

                int neighbor = adj.get(node).get(i);

                if(!visited[neighbor]){
                    visited[neighbor] = true;
                    q.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args){

        int n = 5;

        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(3);
        adj.get(2).add(4);

        bfs(0, adj, n);
    }
}
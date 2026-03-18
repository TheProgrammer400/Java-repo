import java.util.*;

public class DialAlgo {

    public static final int INF = Integer.MAX_VALUE;

    public static void shortestPath(int V, ArrayList<ArrayList<int[]>> adj, int src, int W){

        int[] dist = new int[V];
        Arrays.fill(dist, INF);
        dist[src] = 0;

        ArrayList<Integer> []B = new ArrayList[W * V + 1];

        for (int i = 0; i <= W * V; i++){
            B[i] = new ArrayList<>();
        }

        B[0].add(src);

        int index = 0;

        while (index <= W * V){

            if (B[index].isEmpty()){
                index++;
                continue;
            }

            int u = B[index].remove(0);

            for (int[] edge : adj.get(u)){

                int v = edge[0];
                int w = edge[1];

                if (dist[u] + w < dist[v]){

                    dist[v] = dist[u] + w;
                    B[dist[v]].add(v);
                }
            }
        }

        for (int i = 0; i < V; i++){
            if (dist[i] == INF){
                System.out.print(-1 + " ");
            } else{
                System.out.print(dist[i] + " ");
            }
        }
    }

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        int V = scan.nextInt();
        int E = scan.nextInt();

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }

        int maxW = 0;

        for (int i = 0; i < E; i++){

            int u = scan.nextInt();
            int v = scan.nextInt();
            int w = scan.nextInt();

            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w});

            maxW = Math.max(maxW, w);
        }

        shortestPath(V, adj, 0, maxW);
        scan.close();
    }
}
import java.util.*;

class Edge {
    public int src, dest, weight;

    public Edge(int s, int d, int w){
        src = s;
        dest = d;
        weight = w;
    }
}

public class BellmanFord {
    public static void bellmanFord(int V, int E, Edge[] edges, int src){

        int dist[] = new int[V];

        // Step 1: initialize
        for (int i = 0; i < V; i++){
            dist[i] = Integer.MAX_VALUE;
        }

        dist[src] = 0;

        // Step 2: relax edges V-1 times
        for (int i = 1; i < V; i++){

            for (int j = 0; j < E; j++){

                int u = edges[j].src;
                int v = edges[j].dest;
                int w = edges[j].weight;

                if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]){
                    dist[v] = dist[u] + w;
                }
            }
        }

        // Step 3: check negative cycle
        for (int j = 0; j < E; j++){

            int u = edges[j].src;
            int v = edges[j].dest;
            int w = edges[j].weight;

            if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]){
                System.out.println(-1);
                return;
            }
        }

        // Step 4: print result
        for (int i = 0; i < V; i++){

            if (dist[i] == Integer.MAX_VALUE){
                System.out.print(-1 + " ");
            }
            else{
                System.out.print(dist[i] + " ");
            }
        }
    }

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        int V = scan.nextInt();
        int E = scan.nextInt();

        Edge[] edges = new Edge[E];

        for (int i = 0; i < E; i++){

            int u = scan.nextInt();
            int v = scan.nextInt();
            int w = scan.nextInt();

            edges[i] = new Edge(u, v, w);
        }

        bellmanFord(V, E, edges, 0);
        scan.close();
    }
}
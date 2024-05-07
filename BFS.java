package ai;

import java.util.*;

public class BFS {
    static class Edge {
        int src;
        int dest;
        

        public Edge(int src, int dest ) {
            this.src = src;
            this.dest = dest;
            
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph, int numVertices, int numEdges, Scanner scanner) {
        for (int i = 0; i < numVertices; i++) {
            graph[i] = new ArrayList<>();
        }

        System.out.println("Enter edges in the format: source destination ");
        for (int i = 0; i < numEdges; i++) {
            int src = scanner.nextInt();
            int dest = scanner.nextInt();
            
            graph[src].add(new Edge(src, dest ));
        }
    }

    public static void bfs(ArrayList<Edge>[] graph, int numVertices) {
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[numVertices];
        q.add(0); // source = 0

        while (!q.isEmpty()) {
            int curr = q.remove();

            if (!vis[curr]) {
                System.out.println(curr);
                vis[curr] = true;

                for (Edge e : graph[curr]) {
                    q.add(e.dest);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int numVertices = scanner.nextInt();

        ArrayList<Edge>[] graph = new ArrayList[numVertices];

        System.out.print("Enter the number of edges: ");
        int numEdges = scanner.nextInt();

        createGraph(graph, numVertices, numEdges, scanner);

        // Perform BFS
        bfs(graph, numVertices);

        
    }
}

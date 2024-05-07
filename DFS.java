import java.util.*;

public class DFS {
    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph, Scanner scanner) {
        System.out.print("Enter the number of vertices: ");
        int V = scanner.nextInt();
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        System.out.print("Enter the number of edges: ");
        int E = scanner.nextInt();

        System.out.println("Enter edges in the format: source destination weight");
        for (int i = 0; i < E; i++) {
            int src = scanner.nextInt();
            int dest = scanner.nextInt();
            int wt = scanner.nextInt();
            graph[src].add(new Edge(src, dest, wt));
        }
    }

    public static void dfs(ArrayList<Edge>[] graph, int curr, boolean vis[]) {
        // visit
        System.out.print(curr + " ");
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                dfs(graph, e.dest, vis);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Edge>[] graph = new ArrayList[8]; // Adjust size as needed

        createGraph(graph, scanner);

        System.out.print("Starting vertex for DFS: ");
        int startVertex = scanner.nextInt();

        System.out.println("Depth First Traversal:");
        dfs(graph, startVertex, new boolean[graph.length]);

        scanner.close();
    }
}

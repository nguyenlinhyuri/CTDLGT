package Week13_MinimumSpanningTree;

import java.util.*;

class Edge {
    public int v, w;

    public Edge(int v, int w) {
        this.v = v;
        this.w = w;
    }
}

public class SpecialSubtree {
    public static int primMST(int n, List<List<Edge>> graph) {
        int minWeight = 0;
        boolean[] visited = new boolean[100005];
        int[] minEdge = new int[100005];
        Arrays.fill(minEdge, Integer.MAX_VALUE);

        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.w));
        pq.add(new Edge(1, 0));

        while (!pq.isEmpty()) {
            Edge curr = pq.poll();
            int u = curr.v;

            if (visited[u]) {
                continue;
            }

            visited[u] = true;
            minWeight += curr.w;

            for (Edge neighbor : graph.get(u)) {
                int v = neighbor.v;
                int w = neighbor.w;

                if (!visited[v] && w < minEdge[v]) {
                    minEdge[v] = w;
                    pq.add(new Edge(v, w));
                }
            }
        }

        return minWeight;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<List<Edge>> vertices = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            vertices.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            vertices.get(u).add(new Edge(v, w));
            vertices.get(v).add(new Edge(u, w));
        }

        System.out.println(primMST(n, vertices));
    }
}
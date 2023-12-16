package Week13_MinimumSpanningTree;

import java.util.*;
import java.io.*;

class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(new
                InputStreamReader(System.in));
    }

    String next() {
        if (st == null || !st.hasMoreElements()) {
            do {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } while (st == null || !st.hasMoreElements());
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}

public class ShortestReach2 {
    private static final int INF = Integer.MAX_VALUE;
    public static int n, m;
    public static List<List<Edge>> adj = new ArrayList<>();

    static class Edge {
        int weight;
        int vertex;

        public Edge(int weight, int vertex) {
            this.weight = weight;
            this.vertex = vertex;
        }
    }

    public static void dijkstra(int s) {
        int[] d = new int[n + 1];
        Arrays.fill(d, INF);
        d[s] = 0;

        PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(pair -> pair.weight));
        queue.add(new Edge(0, s));
        while (!queue.isEmpty()) {
            Edge top = queue.poll();
            int u = top.vertex;
            int kc = top.weight;

            if (kc > d[u]) continue;

            for (Edge x : adj.get(u)) {
                int v = x.vertex;
                int w = x.weight;
                if (d[v] > d[u] + w) {
                    d[v] = d[u] + w;
                    queue.add(new Edge(d[v], v));
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            if (i != s) {
                System.out.print((d[i] == INF ? -1 : d[i]) + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();

        int t = sc.nextInt();
        while (t-- > 0) {
            n = sc.nextInt();
            m = sc.nextInt();

            adj.clear();

            for (int i = 0; i <= n; i++) {
                adj.add(new ArrayList<>());
            }

            for (int i = 0; i < m; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                int w = sc.nextInt();

                adj.get(x).add(new Edge(w, y));
                adj.get(y).add(new Edge(w, x));
            }
            int s = sc.nextInt();
            dijkstra(s);
        }
    }
}
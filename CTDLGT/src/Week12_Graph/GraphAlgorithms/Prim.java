package Week12_Graph.GraphAlgorithms;

import java.util.*;

// Prim Algorithm is optimized by Priority Queue
public class Prim {
    static class Pairs {
        int w;
        int v;

        public Pairs(int w, int v) {
            this.w = w;
            this.v = v;
        }
    }

    static class Edge {
        int x, y, w;

        public Edge(int x, int y, int w) {
            this.x = x;
            this.y = y;
            this.w = w;
        }
    }

    public static final int INF = 10001;
    public static int n, m;
    public static List<List<Pairs>> adj = new ArrayList<>();
    public static boolean[] used = new boolean[INF];  // kiem tra 1 dinh thuoc mst hay chua
    public static int[] parents = new int[INF];
    public static int[] d = new int[INF];

    public static void prim(int u) {
        Queue<Pairs> q = new PriorityQueue<>(Comparator.comparingInt(p -> p.w));
        List<Edge> mst = new ArrayList<>();
        int ans = 0;
        q.add(new Pairs(0, u));
        while (!q.isEmpty()) {
            Pairs top = q.poll();
            int v = top.v;
            int w = top.w;

            if (used[v]) continue;
            ans += w;
            used[v] = true;
            if (u != v) {
                mst.add(new Edge(v, parents[v], w));
            }
            for (Pairs it : adj.get(v)) {
                int v_ = it.v;
                int w_ = it.w;
                if (!used[v_] && w_ < d[v_]) {
                    q.add(new Pairs(w_, v_));
                    d[v_] = w_;
                    parents[v_] = v;
                }
            }
        }
        System.out.println("MST: " + ans);
        for (Edge e : mst) {
            System.out.println(e.x + " " + e.y + " " + e.w);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int w = sc.nextInt();

            adj.get(x).add(new Pairs(w, y));
            adj.get(y).add(new Pairs(w, x));
        }
        Arrays.fill(used, false);
        for (int i = 1; i <= n; i++) d[i] = Integer.MAX_VALUE;
        prim(1);
    }
}

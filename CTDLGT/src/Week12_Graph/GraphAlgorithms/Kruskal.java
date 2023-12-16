package Week12_Graph.GraphAlgorithms;

import java.util.*;

// implement kruskal algorithm by union-find
public class Kruskal {
    static class Edge {
        int u, v, w;

        public Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    public static final int INF = 100001;
    public static int n, m;
    public static int[] parent = new int[INF];
    public static int[] sz = new int[INF];
    public static List<Edge> edges = new ArrayList<>();

    public static void make_set() {
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            sz[i] = 1;
        }
    }

    public static int find(int v) {
        if (v == parent[v]) return v;
        return parent[v] = find(parent[v]);
    }

    public static boolean union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return false;
        if (sz[a] < sz[b]) {
            int t = a;
            a = b;
            b = t;
        }

        parent[b] = a;
        sz[a] += sz[b];
        return true;
    }

    public static void kruskal(){
        List<Edge> mst = new ArrayList<>();
        int d = 0;

        Collections.sort(edges, Comparator.comparingInt(edge -> edge.w));

        for (int i=0; i<m; i++){
            if (mst.size() == n-1) break;
            Edge e = edges.get(i);
            if (union(e.u, e.v)){
                mst.add(e);
                d += e.w;
            }
        }

        if (mst.size() != n-1) System.out.println("Graph is not connected.");
        else System.out.println("MST: " + d);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i=0; i<m; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int w = sc.nextInt();
            edges.add(new Edge(x, y, w));
        }
        make_set();
        kruskal();
    }
}

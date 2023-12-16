package Week13_MinimumSpanningTree;

import java.util.*;

class kruskalEdge {
    public int u, v, w;

    public kruskalEdge(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
        if (u > v) {
            int t = u;
            u = v;
            v = t;
        }
    }
}

public class ReallySpecialSubtree {
    public static int[] parent = new int[10000];
    public static int[] size = new int[10000];

    public static void set() {
        for (int i = 0; i < 10000; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public static int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y) {
        int x_ = find(x);
        int y_ = find(y);

        if (x_ != y_) {
            if (size[x_] > size[y_]) {
                int temp = x_;
                x_ = y_;
                y_ = temp;
            }
            parent[y_] = x_;
            size[x_] += size[y_];
        }
    }

    public static boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }

    public static int kruskalMST(int n, List<kruskalEdge> edges) {
        int minWeight = 0;
        edges.sort(Comparator.comparingInt(edge -> edge.w));

        for (kruskalEdge edge : edges) {
            if (!isConnected(edge.u, edge.v)) {
                union(edge.u, edge.v);
                minWeight += edge.w;
            }
        }
        return minWeight;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        set();
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<kruskalEdge> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            edges.add(new kruskalEdge(u, v, w));
        }

        System.out.println(kruskalMST(n, edges));
    }
}

package Week12_Graph.GraphAlgorithms;

import java.util.*;

// input: danh sách cạnh cho đồ thị vô hướng
public class DepthFirstSearch {
    public static final int INF = 10001;
    public static int n, m;
    public static List<List<Integer>> adj = new ArrayList<>(); // lưu danh sách kề
    public static boolean[] visited = new boolean[INF];

    public static void dfs(int u){
        System.out.print(u + " ");

        visited[u] = true;
        for (int v : adj.get(u)){
            if (!visited[v]){
                dfs(v);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i=0; i<=m; i++){
            adj.add(new ArrayList<>());
        }

        // chuyen sang ds ke
        for (int i=0; i<m; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            adj.get(x).add(y);
            adj.get(y).add(x);  // đồ thị có hướng -> bỏ dòng code này
        }
        Arrays.fill(visited, false);

        dfs(1);
    }
}

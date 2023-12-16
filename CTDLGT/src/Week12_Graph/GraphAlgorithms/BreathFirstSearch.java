package Week12_Graph.GraphAlgorithms;

import java.util.*;

// input: danh sách cạnh cho đồ thị vô hướng
public class BreathFirstSearch {
    public static final int INF = 10001;
    public static int n, m;
    public static List<List<Integer>> adj = new ArrayList<>(); // lưu danh sách kề
    public static boolean[] visited = new boolean[INF];

    public static void bfs(int u){
        // init
        Queue<Integer> q = new LinkedList<>();
        q.add(u);
        visited[u] = true;

        // loop
        while (!q.isEmpty()){
            int v = q.poll();
            System.out.print(v + " ");
            for (int x : adj.get(v)){
                if (!visited[x]){
                    q.add(x);
                    visited[x] = true;
                }
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

        bfs(1);
    }
}

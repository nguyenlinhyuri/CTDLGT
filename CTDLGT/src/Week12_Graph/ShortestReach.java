package Week12_Graph;

import java.util.*;

public class ShortestReach {
    public static void bfs(List<List<Integer>> g, int[] dist, int start, int n) {
        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);

        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        dist[start] = 0;

        while (!q.isEmpty()) {
            start = q.poll();

            for (int x : g.get(start)) {
                if (!visited[x]) {
                    visited[x] = true;
                    dist[x] += dist[start] + 6;
                    q.add(x);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            List<List<Integer>> g = new ArrayList<>(n);

            for (int i = 0; i < n; i++) {
                g.add(new ArrayList<>());
            }

            for (int i = 0; i < m; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                g.get(a - 1).add(b - 1);
                g.get(b - 1).add(a - 1);
            }

            int start = sc.nextInt();

            int[] dist = new int[n];
            Arrays.fill(dist, -1);

            bfs(g, dist, start - 1, n);

            for (int i = 0; i < n; i++) {
                if (i != start - 1) {
                    if (dist[i] == -1) System.out.print("-1 ");
                    else System.out.print(dist[i] * 6 / 5 + " ");
                }
            }
            System.out.println();
        }
    }
}

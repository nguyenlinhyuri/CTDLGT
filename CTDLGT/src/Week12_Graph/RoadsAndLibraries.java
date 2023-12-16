package Week12_Graph;

import java.util.ArrayList;
import java.util.Scanner;

public class RoadsAndLibraries {
    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    static long nodes;

    static void DFS(int n) {
        nodes++;
        visited[n] = true;
        for (int i : adj[n]) {
            if (!visited[i])
                DFS(i);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            long X = sc.nextLong();
            long Y = sc.nextLong();

            adj = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) {
                adj[i] = new ArrayList<>();
            }

            for (int i = 0; i < M; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                adj[a].add(b);
                adj[b].add(a);
            }

            long cost = 0;

            visited = new boolean[N + 1];
            for (int i = 1; i <= N; i++) {
                if (!visited[i]) {
                    nodes = 0;
                    DFS(i);
                    cost += X;
                    if (X > Y) cost += Y * (nodes - 1);
                    else cost += X * (nodes - 1);
                }
            }

            System.out.println(cost);
            for (int i = 0; i <= N; i++) {
                if (adj[i] != null) {
                    adj[i].clear();
                }
                visited[i] = false;
            }
        }
    }
}
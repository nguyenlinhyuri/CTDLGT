package Week2_UnionFind;

import java.util.Scanner;

public class UFClient2 {
    public static int root[] = new int[1000];

    public static int get_root(int x) {
        if (root[x] < 0) return x;
        return root[x] = get_root(root[x]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        for (int i = 0; i < v; i++) {
            root[i] = -1;
        }

        int res = v;
        int cnt = 0;
        while (sc.hasNextInt()) {
            cnt++;
            int x = sc.nextInt();
            int y = sc.nextInt();
            x = get_root(x);
            y = get_root(y);
            if (x != y) {
                if (root[x] < root[y]) {
                    int z = x;
                    x = y;
                    y = z;
                }
                root[y] += root[x];
                root[x] = y;
                res--;
                if (res == 1) {
                    System.out.println(cnt);
                }
            }
        }

        if (res != 1) System.out.println("FAILED");
    }
}
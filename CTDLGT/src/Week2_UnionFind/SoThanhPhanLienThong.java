package Week2_UnionFind;

import java.util.Scanner;

public class SoThanhPhanLienThong {
    public static int root[]= new int[1000];
    public static int find_root(int x){
        return root[x];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // số đỉnh
        int m = sc.nextInt(); // số cạnh
        for (int i = 0; i < n; i++) {
            root[i] = i;
        }
        int count = n;
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int root_x = find_root(x);
            int root_y = find_root(y);
            if (root_x != root_y) {
                for (int j = 0; j < n; j++) {
                    if (root_y == root[j]) {
                        root[j] = root_x;
                    }
                }
                count--;
            }
        }
    }
}

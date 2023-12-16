package Week11_HashTable;

import java.util.*;

public class MissingNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] A = new int[10004];
        int[] B = new int[10004];

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            A[x]++;
        }

        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            B[x]++;
        }

        for (int i=1; i<= 10000; i++){
            if (B[i] > A[i]) System.out.print(i + " ");
        }
    }
}
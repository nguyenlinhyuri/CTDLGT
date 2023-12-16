package Week6_Sort;

import java.util.Scanner;

public class CountingSort1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];

        int max = -1;
        for (int i=0; i<n; i++){
            a[i] = sc.nextInt();
            max = Math.max(max, a[i]);
        }

        int[] ans = new int[max+1];
        for (int i=0; i<n; i++){
            ans[a[i]]++;
        }

        for (int x : ans) System.out.print(x + " ");

    }
}

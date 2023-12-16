package Week3_Algorithms;

import java.util.Scanner;

public class SherlockAndArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            int sum = 0;
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                sum += a[i];
            }
            boolean check = false;
            int tmp_sum = 0;
            if (sum == a[0]){
                System.out.println("YES");
                check = true;
            }
            for (int i = 0; i < n; i++) {
                tmp_sum += a[i];
                if ((i + 1) < n && (tmp_sum * 2 + a[i + 1]) == sum) {
                    System.out.println("YES");
                    check = true;
                    break;
                }
            }
            if (!check) System.out.println("NO");
        }
    }
}

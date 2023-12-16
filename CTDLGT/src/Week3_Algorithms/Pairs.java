package Week3_Algorithms;

import java.util.*;

public class Pairs {
    public static int binarySearch(int[] a, int x) {
        int n = a.length;
        int left = 0, right = n - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (a[mid] == x) return mid;
            else if (x <= a[mid]) right = mid - 1;
            else left = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] a = new int[n];
        for (int i=0; i<n; i++) a[i] = sc.nextInt();

        Arrays.sort(a);
        int ans = 0;
        for (int i=0; i<n; i++){
            if (binarySearch(a, a[i]+k) != -1) ans++;
        }
        System.out.println(ans);
    }
}

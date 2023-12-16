package Week3_Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// O(N^2.logN)
public class ThreeSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) a[i] = sc.nextInt();

        ArrayList<int[]> ans = new ArrayList<>();

        Arrays.sort(a);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int target = -(a[i] + a[j]);

                int left = j + 1, right = n - 1;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (a[mid] == target) {
                        ans.add(new int[]{a[i], a[j], a[mid]});
                        left++;
                        right--;
                    } else if (a[mid] < target) left = mid + 1;
                    else right = mid - 1;
                }
            }
        }
        System.out.println("The number of triplets: " + ans.size());
        for (int[] x : ans) {
            for (int y : x) System.out.print(y + " ");
            System.out.println();
        }
    }
}
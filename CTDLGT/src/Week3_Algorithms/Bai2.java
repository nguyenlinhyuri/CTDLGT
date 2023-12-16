package Week3_Algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class Bai2 {
    public static int binarySearch(int[] a, int x){
        int left = 0;
        int right = a.length - 1;
        while (left <= right){
            int mid = (left+right) / 2;

            if (a[mid] == x) return mid;
            else if (a[mid] < x) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int x = sc.nextInt();
        System.out.println(binarySearch(arr, x));
    }
}

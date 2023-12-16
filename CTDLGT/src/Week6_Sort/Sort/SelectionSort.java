package Week6_Sort.Sort;

import java.util.Scanner;

// O(n^2)
public class SelectionSort {
    public static void selection_sort(int[] arr) {
        int n = arr.length;

        // duyệt từng phần tử
        for (int i = 0; i < n - 1; i++) {

            // tìm phần tử nhỏ nhất trong mảng chưa được sắp xếp
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_idx]) min_idx = j;
            }

            // hoán đổi phần tử nhỏ nhất với phần tử đầu tiên
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

    public static void print(int[] arr) {
        for (int x : arr) System.out.print(x + " ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        selection_sort(a);
        print(a);
    }
}

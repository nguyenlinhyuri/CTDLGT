package Week6_Sort.Sort;

import java.util.Scanner;

/**
 * sắp xếp chèn (O(N^2))
 * đơn giản, hoạt động tốt với dữ liệu nhỏ
 */
public class InsertionSort {
    public static void insertion_sort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            // di chuyển các phần tử của arr[0 ... i-1], lớn hơn key
            // đến một vị trí trước vị trí hiện tại của chúng
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j -= 1;
            }
            arr[j + 1] = key;
            print(arr);
        }
    }

    public static void print(int[] arr) {
        for (int x : arr) System.out.print(x + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        insertion_sort(a);
    }
}

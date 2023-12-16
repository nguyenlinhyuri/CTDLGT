package Week6_Sort.Sort;

import java.util.Scanner;

/**
 * chia để trị
 * O(NlogN)
 */
public class MergeSort {
    public static void merge(int[] arr, int l, int m, int r) {

        // Tìm kích thước của 2 mảng con để merge
        int n1 = m - l + 1;
        int n2 = r - m;

        // Tạo mảng tạm
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy dữ liệu vào mảng tạm
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        // Merge các mảng tạm lại

        // Chỉ mục ban đầu của 2 mảng con
        int i = 0, j = 0;

        // Chỉ mục ban đầu của mảng phụ được hợp nhất
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Sao chép các phần tử còn lại của L[] nếu có
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Sao chép các phần tử còn lại của R[] nếu có
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void merge_sort(int[] arr, int l, int r) {
        if (l < r) {

            // Tìm điểm chính giữa
            int m = (l + r) / 2;

            // Hàm đệ quy tiếp tục chia đôi
            merge_sort(arr, l, m);
            merge_sort(arr, m + 1, r);

            merge(arr, l, m, r);
        }
    }

    public static void print(int[] a){
        for (int x : a) System.out.print(x + " ");
        System.out.println();
    }

    public static int[] sortArray(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i=0; i<nums.length; i++) ans[i] = nums[i];
        merge_sort(ans, 0, nums.length);
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i=0; i<n; i++) a[i] = sc.nextInt();
//        merge_sort(a, 0, n-1);
        a = sortArray(a);
        print(a);
    }
}

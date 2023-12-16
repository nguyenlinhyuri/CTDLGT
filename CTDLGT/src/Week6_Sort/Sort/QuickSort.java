package Week6_Sort.Sort;

import java.util.Scanner;

/**
 * chia để trị
 * O(NlogN)
 */
public class QuickSort {
    // phan hoach lomuto
    public static int lomuto_partition(int[] a, int l, int r){
        int pivot = a[r];
        int i = l-1;
        for (int j=l; j<r; j++){
            if (a[j] <= pivot){
                i++;
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
            }
        }

        // dua pivot ve giua
        i++;
        int tmp = a[i];
        a[i] = a[r];
        a[r] = tmp;
        print(a);

        return i;   // vi tri cua pivot
    }

    public static void quick_sort1(int[] a, int l, int r){
        if (l >= r) return;
        int p = lomuto_partition(a, l, r);
        quick_sort1(a, l, p-1);
        quick_sort1(a, p+1, r);
    }

    //----------------------------------

    // phan hoach hoare
    public static int hoare_partition(int[] a, int l, int r){
        int pivot = a[l];
        int i=l-1, j=r+1;
        while (true){
            do{
                i++;
            } while(a[i] < pivot);

            do{
                j--;
            } while (a[j] > pivot);

            if (i < j){
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
            } else return j;
        }
    }
    public static void quick_sort2(int[] a, int l, int r){
        if (l >= r) return;
        int p = hoare_partition(a, l, r);

        quick_sort2(a, l, p);
        quick_sort2(a, p+1, r);
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
        quick_sort1(a, 0, n-1);
        print(a);
    }
}

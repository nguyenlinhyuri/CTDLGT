package Week6_Sort;

import java.util.Scanner;

public class InsertionSortPart2 {
    public static void insertion_sort(int[] a){
        int n = a.length;
        for (int i=1; i<n; i++){
            int key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > key){
                a[j+1] = a[j];
                j -= 1;
            }
            a[j+1] = key;
            print(a);
        }

    }
    public static void print(int[] a){
        for (int x : a) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        insertion_sort(a);
//        print(a);
    }
}

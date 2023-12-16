package Week6_Sort;

import java.util.Scanner;

public class InsertionSortPart1 {
    public static void print(int[] a){
        for (int x : a) System.out.print(x + " ");
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        int x = a[n-1];
        for (int i=n-2; i>=-1; i--){
            if (i == -1) {
                a[0] = x;
                print(a);
                break;
            }
            if (a[i] > x) a[i+1] = a[i];
            else {
                a[i+1] = x;
                print(a);
                break;
            }
            print(a);
        }
        sc.close();
    }
}

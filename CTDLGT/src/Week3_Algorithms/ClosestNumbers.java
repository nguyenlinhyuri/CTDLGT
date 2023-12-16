package Week3_Algorithms;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

public class ClosestNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i=0; i<n; i++) a[i] = sc.nextInt();
        Arrays.sort(a);
        int min = a[1] - a[0];
        Vector <int[]> v = new Vector<>();
        for (int i=0; i<n-1; i++){
            min = Math.min(min, a[i+1] - a[i]);
        }
        for (int i=0; i<n-1; i++){
            if (a[i+1] - a[i] == min){
//                System.out.println(a[i] + " " + a[i+1]);
                v.add(new int[]{a[i], a[i+1]});
            }
        }
        for (int[] x : v){
            System.out.print(x[0] + " " + x[1] + " ");
        }
    }
}

package Week3_Algorithms;

import java.util.Arrays;
import java.util.Scanner;


// phương pháp 2 con trỏ O(N^2)
public class Bai7{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        for(int i = 0; i <= n - 3; i++){
            int j = i + 1;
            for(int k = n - 1; k >= i + 2; k--){
                while(j < k){
                    if(a[i] + a[j] + a[k] == 0) {
                        System.out.println(a[i] + " " + a[j] + " " + a[k]);
                        j++;
                    }
                    else if(a[i] + a[j] + a[k] < 0) j++;
                    else break;
                }
            }
        }
    }
}

package Week6_Sort;

import java.util.Random;
import java.util.Scanner;

public class RandomShuffle {
    public static void shuffle(int[] a){
        Random rand = new Random();

        for (int i=a.length-1; i>0; i--){
            int j = rand.nextInt(i+1);

            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i=0; i<n; i++) a[i] = sc.nextInt();
        shuffle(a);
        for (int x : a) System.out.print(x + " ");
    }
}

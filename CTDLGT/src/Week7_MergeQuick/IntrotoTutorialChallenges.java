package Week7_MergeQuick;

import java.util.ArrayList;
import java.util.Scanner;

public class IntrotoTutorialChallenges{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int n = sc.nextInt();
        ArrayList<Integer> a = new ArrayList<Integer>();
        while (n-- > 0){
            int x = sc.nextInt();
            a.add(x);
        }

        System.out.println(a.indexOf(v));
    }
}


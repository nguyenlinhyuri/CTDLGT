package Week8_PriorityQueue;

import java.io.*;
import java.util.*;

public class JavaStringReverse {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        /* Enter your code here. Print output to STDOUT. */

        String ans = new StringBuilder(A).reverse().toString();
        if (A.equals(ans)) System.out.println("Yes");
        else System.out.println("No");
    }
}

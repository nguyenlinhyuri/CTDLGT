package Week6_Sort;

import java.util.*;

public class RightMost {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];

        for (int i=0; i<n; i++) {
            a[i] = sc.nextInt();
        }

        Stack<Integer> st = new Stack<>();
        for (int i=0; i<n; i++){
            if (st.isEmpty()) st.push(i);
            else {
                while (!st.isEmpty() && a[st.peek()] < a[i]){
                    b[st.pop()] = a[i];
                }
                st.push(i);
            }
        }

        while (!st.isEmpty()){
            b[st.pop()] = -1;
        }

        for (int x : b) System.out.print(x + " ");
    }
}

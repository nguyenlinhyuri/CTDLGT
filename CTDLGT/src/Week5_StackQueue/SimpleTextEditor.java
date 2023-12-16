package Week5_StackQueue;

import java.util.Scanner;
import java.util.Stack;

public class SimpleTextEditor {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Stack<String> st = new Stack<>();
        String s = "";

        while (n-- > 0){
            String tmp = sc.nextLine();
            String[] str = tmp.split(" ");
            String type = str[0];

            if (type.equals("1")){
                s += str[1];
                st.push(s);
            } else if (type.equals("2")){
                int k = Integer.parseInt(str[1]);
                String p = st.peek();
                s = p.substring(0, p.length() - k);
                st.push(s);
            } else if (type.equals("3")){
                int k = Integer.parseInt(str[1]);
                String p = st.peek();
                System.out.println(p.charAt(k-1));
            } else {
                st.pop();
                if (st.empty()) s = "";
                else s = st.peek();
            }
        }
    }
}

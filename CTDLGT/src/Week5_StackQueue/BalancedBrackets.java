package Week5_StackQueue;

import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets{
    public static boolean check(String s){
        Stack <Character> stack = new Stack<Character>();
        for (int i=0; i<s.length(); i++){
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') stack.push(s.charAt(i));

            else if (s.charAt(i) == ')'){
                if (stack.empty() || stack.peek() != '(') return false;
                else stack.pop();
            } else if (s.charAt(i) == ']'){
                if (stack.empty() || stack.peek() != '[') return false;
                else stack.pop();
            } else if (s.charAt(i) == '}'){
                if (stack.empty() || stack.peek() != '{') return false;
                else stack.pop();
            }
        }
        return stack.size() == 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i=0; i<n; i++){
            String s = sc.next();
            System.out.println(check(s) ? "YES" : "NO");
        }
    }
}

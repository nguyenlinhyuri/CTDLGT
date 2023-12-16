package Week5_StackQueue;

import java.util.*;

public class QueueUsingTwoStacks {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> insert = new Stack<>();
        Stack<Integer> delete = new Stack<>();
        int n = sc.nextInt();
        int i = 1;
        while (i <= n) {
            int type = sc.nextInt();
            if (type == 1) {
                int x = sc.nextInt();
                insert.push(x);
            } else if (type == 2) {
                if (delete.empty()) {
                    while (!insert.empty()) {
                        delete.push(insert.pop());
                    }
                }
                delete.pop();
            } else {
                if (delete.empty()) {
                    while (!insert.empty()) {
                        delete.push(insert.pop());
                    }
                }
                System.out.println(delete.peek());
            }
            i++;
        }
    }
}


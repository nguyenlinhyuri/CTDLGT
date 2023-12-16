package Week8_PriorityQueue;

import java.util.*;

public class JesseandCookies {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            pq.add(val);
        }
        int count = 0;
        boolean ans = true;
        while (true) {
            // nếu hàng đợi rỗng
            if (pq.isEmpty()) {
                ans = false;
                break;
            }
            int a1 = pq.poll();
            // nếu phần tử ở đầu hàng đợi >= k
            if (a1 >= k) {
                break;
            }
            // nếu hàng đợi rỗng
            if (pq.isEmpty()) {
                if (a1 < k) {
                    ans = false;
                }
                break;
            }
            int a2 = pq.poll();
            int nv = a1 + 2 * a2;
            count++;
            pq.add(nv);
        }
        if (ans) System.out.println(count);
        else System.out.println("-1");
    }
}

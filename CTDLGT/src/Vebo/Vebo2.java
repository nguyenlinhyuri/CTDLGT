package Vebo;

import java.util.*;

public class Vebo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // so mon qua
        int k = sc.nextInt(); // so qua toi da co the mang theo
        long[] a = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
        Queue<Long> pq = new PriorityQueue<Long>();
        long sum = 0;
        long[] ans = new long[n + 1];
        pq.add(a[1]);
        sum += a[1];
        ans[1] = a[1];
        for (int i = 2; i <= n; i++) {
            if (pq.size() < k) {
                pq.offer(a[i]);
                sum += a[i];
                ans[i] = sum;
            } else {
                long x = pq.element(); // phan tư min
                if (x < a[i]) {
                    pq.remove();
                    pq.add(a[i]);
                    sum += a[i] - x;
                    ans[i] = sum;
                } else ans[i] = sum;
            }
        }
        for (int i = 1; i <= n; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
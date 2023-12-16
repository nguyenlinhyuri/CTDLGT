package Vebo;

import java.util.*;

public class Vebo3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        Queue<Long> minHeap = new PriorityQueue<>();
        Map<Long, Long> map = new TreeMap<>();
        Long sum = (long) 0;
        for (long i = 1; i < n; i++) { // n truy vấn
            long t = sc.nextLong();
            if (t == 1) {  // startup và thu về số tiền là u
                long u = sc.nextLong();
                minHeap.add(u);
                map.put(i, u);
            }
            if (t == 2) {
                long v = sc.nextLong();   // người thứ i đồng ý
                while (minHeap.size() >= v) {
                    for (Map.Entry entry : map.entrySet()) {
                        if (entry.getValue().equals(minHeap.peek())) {
                            map.remove(entry.getKey());
                            break;
                        }
                    }
                    minHeap.poll();
                }
            }
        }
        long t = sc.nextLong();
        long tmp = sc.nextLong();
        if (minHeap.size() < tmp) System.out.println(-1);
        else {
            while (minHeap.size() > 0) {
                sum += minHeap.poll();
            }
            System.out.println(sum);
            for (Map.Entry<Long, Long> entry : map.entrySet()) {
                System.out.print(entry.getKey() + " ");
            }

        }
    }
}
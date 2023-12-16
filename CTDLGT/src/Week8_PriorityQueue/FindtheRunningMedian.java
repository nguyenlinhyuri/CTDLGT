package Week8_PriorityQueue;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class FindtheRunningMedian {
    private static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    public static void add(int num) {
        if (maxHeap.size() > 0 && num >= maxHeap.peek()) {
            minHeap.offer(num);
        } else {
            maxHeap.offer(num);
        }

        if (Math.abs(maxHeap.size() - minHeap.size()) > 1) {
            if (maxHeap.size() > minHeap.size()) {
                int temp = maxHeap.poll();
                minHeap.offer(temp);
            } else {
                int temp = minHeap.poll();
                maxHeap.offer(temp);
            }
        }
    }

    public static double getMedian() {
        int total = minHeap.size() + maxHeap.size();
        if (total % 2 == 1) {
            return (double) (maxHeap.size() > minHeap.size() ? maxHeap.peek() : minHeap.peek());
        } else {
            double median = 0;
            if (!maxHeap.isEmpty()) {
                median += maxHeap.peek();
            }
            if (!minHeap.isEmpty()) {
                median += minHeap.peek();
            }
            return median / 2;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 1; i <= n; i++) {
            int num = scanner.nextInt();
            add(num);
            System.out.printf("%.1f\n", getMedian());
        }
        scanner.close();
    }
}

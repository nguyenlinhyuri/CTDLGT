package Vebo;

import java.util.*;

class minPQ {
    private static int MAX_SIZE = 1000000;
    private static int[] arr = new int[MAX_SIZE + 1];
    private static int size;

    public minPQ() {
        size = 0;
    }

    public static boolean isEmpty() {
        return size <= 0;
    }

    public static int peek(){
        if (isEmpty()) return -1;
        return arr[1];
    }

    public static void swap(int i, int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void add(int v){
        size++;
        arr[size] = v;
        swim(size);
    }

    public static void swim(int k){
        int parentIndex = k / 2;

        while (parentIndex != 0 && arr[parentIndex] > arr[k]) {
            swap(parentIndex, k);
            k = parentIndex;
            parentIndex = k / 2;
        }
    }

    public static int poll() {
        if (isEmpty()) {
            System.out.println("Error: Heap is empty!");
            return -1;
        }
        int minRoot = arr[1];

        arr[1] = arr[size];
        size--;

        sink(1);
        return minRoot;
    }

    public static void remove(int v) {
        int curIndex = -1;
        for (int i = 1; i <= size; i++) {
            if (arr[i] == v) {
                curIndex = i;
                break;
            }
        }
        if (curIndex == -1) {
            System.out.println("Error: Element is not exist!");
            return;
        }
        arr[curIndex] = arr[size];
        size--;
        sink(curIndex);
    }

    // heapify down
    public static void sink(int k) {
        while ((2 * k) <= size) {
            int leftChildIndex = 2 * k;
            int rightChildIndex = leftChildIndex + 1;
            int smallerChildIndex = leftChildIndex;

            if (leftChildIndex <= size && arr[rightChildIndex] < arr[leftChildIndex]) {
                smallerChildIndex = rightChildIndex;
            }

            if (arr[k] > arr[smallerChildIndex]) {
                swap(k, smallerChildIndex);
                k = smallerChildIndex;
            } else {
                break;
            }
        }
    }

}

public class Vebo6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        minPQ pq = new minPQ();
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            pq.add(val);
        }
        int count = 0;
        boolean ans = true;
        while (true) {
            if (pq.isEmpty()) {
                ans = false;
                break;
            }
            int a1 = pq.poll();
            if (a1 >= k) {
                break;
            }
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

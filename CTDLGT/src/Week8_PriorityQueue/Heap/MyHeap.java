package Week8_PriorityQueue.Heap;

import java.util.Scanner;

public class MyHeap {
    private static int MAX_SIZE = 100000;
    private static int[] arr = new int[MAX_SIZE+1];
    private static int size;

    // minheap
    public MyHeap() {
        size = 0;
    }

    public static boolean isEmpty() {
        return size <= 0;
    }

    public static int peek() {
        if (isEmpty()) {
            System.out.println("Error: Heap is empty!");
            return -1;
        }
        return arr[1];
    }

    public static void add(int v) {
        size++;
        arr[size] = v;

        //heapify up: đảm bảo heap khi add
//        int curIndex = size;
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

    public static void swap(int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }


    // lấy và xóa
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

    // heapify down: đảm bảo tính chất heap mỗi khi remove
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int q = sc.nextInt();
        while (q-- > 0){
            int t = sc.nextInt();
            if (t == 1){
                // add
                add(sc.nextInt());
            } else if (t == 2){
                // remove
                remove(sc.nextInt());
            } else {
                System.out.println(peek());
            }
        }
    }
}

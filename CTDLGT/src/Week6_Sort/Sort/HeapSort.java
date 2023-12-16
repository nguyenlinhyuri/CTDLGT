package Week6_Sort.Sort;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        int n = arr.length;

        System.out.println("Mảng trước khi sắp xếp:");
        printArray(arr);

        heapSort(arr);

        System.out.println("Mảng sau khi sắp xếp:");
        printArray(arr);
    }

    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Xây dựng Heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Trích xuất từng phần tử từ Heap
        for (int i = n - 1; i > 0; i--) {
            // Di chuyển root hiện tại đến cuối mảng
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Gọi heapify trên Heap giảm kích thước
            heapify(arr, i, 0);
        }
    }

    // Hàm thực hiện heapify các cây con có gốc tại nút i trong mảng arr với kích thước n
    public static void heapify(int[] arr, int n, int i) {
        int largest = i; // Khởi tạo largest là nút gốc
        int leftChild = 2 * i + 1; // Index của nút con trái
        int rightChild = 2 * i + 2; // Index của nút con phải

        // So sánh nút gốc với nút con trái
        if (leftChild < n && arr[leftChild] > arr[largest]) {
            largest = leftChild;
        }

        // So sánh nút gốc với nút con phải
        if (rightChild < n && arr[rightChild] > arr[largest]) {
            largest = rightChild;
        }

        // Nếu largest không phải là nút gốc, thực hiện hoán đổi và heapify lại cây con ảnh hưởng
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }

    // Hàm in mảng
    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}


package Week5_StackQueue;

public class ArrayQueue {
    int[] queue = new int[100];

    int n = 100, front = -1, rear = -1;

    public void push(int val){
        if (rear == n-1){
            System.out.println("Out of queue");
        } else {
            if (front == -1){
                front = 0;
                rear++;
                queue[rear] = val;
            }
        }
    }

    public void pop(){
        if (front == -1 || front > rear){
            System.out.println("can't delete");
        } else {
            System.out.println(queue[front]);
            front++;
        }
    }
}

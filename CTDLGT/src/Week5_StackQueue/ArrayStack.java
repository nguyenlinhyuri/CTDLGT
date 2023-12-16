package Week5_StackQueue;

public class ArrayStack {
    int current_size = -1;
    final int max_size = 100;
    int[] stack = new int[max_size];

    public boolean isEmpty() {
        return current_size == -1;
    }

    public boolean isFull() {
        return current_size == max_size;
    }

    public void push(int data){
        if (!isFull()) {
            current_size++;
            stack[current_size] = data;
        } else System.out.println("stack is full!");
    }

    public int peek(){
        if (!isEmpty()){
            int data = stack[current_size];
            return data;
        } else System.out.println("stack is empty!");
        return -1;
    }

    public int pop(){
        if (!isEmpty()){
            int data = stack[current_size];
            current_size--;
            return data;
        } else return -1;
    }

}

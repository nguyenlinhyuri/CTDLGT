package Week4_LinkedList;

import java.util.Scanner;

public class CycleLinkedList {
    public static boolean isCycle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while (slow != null && fast != null){
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) return true;
        }
        return false;
    }
    public static ListNode addNode(ListNode p, int value){
        ListNode tmp = new ListNode(value);
        p.next = tmp;
        return tmp;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        ListNode head = new ListNode(x);
        ListNode p1 = head;
        for (int j = 0; j < n - 1; j++) {
            x = sc.nextInt();
            p1 = addNode(p1, x);
        }
        System.out.println((isCycle(head))? 1 : 0);
    }
}

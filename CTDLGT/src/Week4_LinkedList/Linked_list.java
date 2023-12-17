package Week4_LinkedList;

import java.util.Scanner;

class ListNode {
    int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Linked_list {
    // print elements of a linked list----------------------------
    public static void print(ListNode head) {
        ListNode p = head;
        while (p != null) {
            System.out.println(p.data);
            p = p.next;
        }
    }

    // insert at the tail of linked list--------------------------
    public static ListNode addNode(ListNode p, int value) {
        ListNode tmp = new ListNode(value);
        p.next = tmp;
        return tmp;
    }

    // insert at the head of linked list---------------------------
    public static ListNode addHead(ListNode head, int value) {
        ListNode newNode = new ListNode(value);
        newNode.next = head;
        head = newNode;
        return newNode;
    }

    // insert a node at a specific position in a linked list--------
    public static void insert(ListNode head, int k, int value) {
        ListNode new_node = new ListNode(value);
        if (k == 0) {
            new_node.next = head;
            head = new_node;
            return;
        }

        ListNode p = head;
        for (int i = 0; i < k - 1; i++) p = p.next;
        if (p == null) return;
        new_node.next = p.next;
        p.next = new_node;
    }

    // Insert a node at position k in a linked list----------------
    public static ListNode deleteNode(ListNode head, int k) {
        if (k == 0) {
            head = head.next;
            return head;
        }
        ListNode previous = head;
        ListNode current = head;
        int cnt = 0;
        while (cnt < k) {
            previous = current;
            current = current.next;
            cnt++;
        }
        previous.next = current.next;
        return head;
    }

    // print reverse------------------------------
    public static void reverse(ListNode p) {
        if (p.next != null) reverse(p.next);
        System.out.println(p.data);
    }

    // reverse a linked list-----------------------
    public static ListNode reverseNode(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    // compare 2 linked lists-----------------------
    public static boolean compare(ListNode p1, ListNode p2) {
        while (p1 != null && p2 != null) {
            if (p1.data != p2.data) return false;
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1 == p2;
    }

    // get node value -------------------------------
    public static boolean ok;

    public static int get(ListNode llist, int position) {
        if (llist == null) return 0;
        int temp = get(llist.next, position);
        if (ok) return temp;
        if (temp == position) {
            ok = true;
            return llist.data;
        } else return temp + 1;
    }

    public static int getNode(ListNode llist, int position) {
        ok = false;
        return get(llist, position);
    }

    // merge 2 sorted linked list-----------------------
    public static ListNode mergeLists(ListNode head1, ListNode head2) {
        ListNode res;
        if (head1.data < head2.data) {
            res = new ListNode(head1.data);
            head1 = head1.next;
        } else {
            res = new ListNode(head2.data);
            head2 = head2.next;
        }
        ListNode temp = res;
        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                res.next = new ListNode(head1.data);
                head1 = head1.next;
            } else {
                res.next = new ListNode(head2.data);
                head2 = head2.next;
            }
            res = res.next;
        }
        if (head1 == null) {
            res.next = head2;
        } else {
            res.next = head1;
        }
        return temp;
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
        head = reverseNode(head);
        print(head);
    }
}
import java.util.*;

// Node of Doubly Linked List
class Node {
    int data;
    int priority;
    Node next;
    Node prev;

    public Node(int data, int priority){
        this.data = data;
        this.priority = priority;
        this.next = null;
        this.prev = null;
    }
}

class PriorityQueue {
    public static Node head = null;

    public static void push(int data, int priority){
        if(head == null){
            head = new Node(data, priority);
            return;
        }

        Node node = new Node(data, priority);
        Node temp = head;
        Node parent = null;

        while(temp != null && temp.priority >= priority){
            parent = temp;
            temp = temp.next;
        }

        if(parent == null){
            // Insert at beginning
            node.next = head;
            head.prev = node;
            head = node;
        } else if(temp == null){
            // Insert at end
            parent.next = node;
            node.prev = parent;
        } else{
            // Insert in between
            parent.next = node;
            node.prev = parent;
            node.next = temp;
            temp.prev = node;
        }
    }

    public static int peek(){
        if(head != null){
            return head.data;
        }
        return -1;
    }

    public static int pop(){
        if(head != null){
            int curr = head.data;
            head = head.next;

            if(head != null){
                head.prev = null;
            }

            return curr;
        }
        return -1;
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i = 0; i < n; i++){
            int data = sc.nextInt();
            int pri = sc.nextInt();
            push(data, pri);
        }

        System.out.println(peek());
        System.out.println(pop());
        System.out.println(pop());
        System.out.println(peek());
    }
}

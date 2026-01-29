import java.util.*;

class Node {
    int n;
    Node next;

    Node(int n){
        this.n = n;
        this.next = null;   
    }
}

class LoopDetection {

    static Node insertNode(Node head, int val){
        Node newNode = new Node(val);

        if(head == null){
            head = newNode;
            return head;
        }

        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }

        temp.next = newNode;
        return head;
    }

    static void display(Node head){
        Node temp = head;

        while(temp != null){
            System.out.print(temp.n + "->");
            temp = temp.next;
        }

        System.out.println("NULL");
    }

    // Floyd’s Cycle Detection Algorithm
    static boolean cycleDetect(Node head){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        Node head = null;

        for(int i = 0; i < n; i++){
            int m = scan.nextInt();
            head = insertNode(head, m);
        }

        display(head);

        if(cycleDetect(head)){
            System.out.println("Cycle detected");
        } else {
            System.out.println("Cycle not detected");
        }

        scan.close();
    }
}

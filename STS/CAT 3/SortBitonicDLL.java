import java.util.*;

class Node {
    int data;
    Node next;
    Node prev;
}

class SortBitonicDLL {
    public static Node sort(Node head){
        if(head == null || head.next == null){
            return head;
        }

        Node front = head;
        Node last = head;

        while(last.next != null){
            last = last.next;
        }

        Node res = new Node();
        Node resEnd = res;
        Node next;

        while (front != last){
            if (last.data <= front.data){
                resEnd.next = last;
                next = last.prev;

                last.prev.next = null;
                last.prev = resEnd;

                last = next;
                resEnd = resEnd.next;
            } else {
                resEnd.next = front;
                next = front.next;

                front.next = null;
                front.prev = resEnd;

                front = next;
                resEnd = resEnd.next;
            }
        }

        resEnd.next = front;
        front.prev = resEnd;

        return res.next;
    }

    public static Node push(Node headRef, int newData){
        Node newNode = new Node();
        newNode.data = newData;
        newNode.prev = null;
        newNode.next = headRef;

        if(headRef != null){
            headRef.prev = newNode;
        }

        headRef = newNode;
        return headRef;
    }

    public static void printlist(Node head){
        if(head == null){
            System.out.print("Doubly Linked list is empty");
            return;
        }

        while(head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        Node head = null;
        int arr[] = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = scan.nextInt();
            head = push(head, arr[i]);
        }

        head = sort(head);
        printlist(head);

        scan.close();
    }
}

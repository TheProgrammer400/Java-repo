import java.util.*;

class Node {
    int n;
    Node next;

    Node(int n) {
        this.n = n;
        this.next = null;
    }
}

class SegregateNodes {
    Node segregateEvenOdd(Node head) {
        Node evenStart = null;
        Node evenEnd = null;
        Node oddStart = null;
        Node oddEnd = null;

        Node currentNode = head;

        while(currentNode != null) {
            int element = currentNode.n;

            if(element % 2 == 0) {
                if(evenStart == null) {
                    evenStart = currentNode;
                    evenEnd = evenStart;
                } else {
                    evenEnd.next = currentNode;
                    evenEnd = evenEnd.next;
                }
            } else {
                if(oddStart == null) {
                    oddStart = currentNode;
                    oddEnd = oddStart;
                } else {
                    oddEnd.next = currentNode;
                    oddEnd = oddEnd.next;
                }
            }

            currentNode = currentNode.next;
        }

        if(evenStart == null) {
            return oddStart;
        }

        if(oddStart == null) {
            return evenStart;
        }

        evenEnd.next = oddStart;
        oddEnd.next = null;

        return evenStart;
    }

    Node push(Node head, int new_data) {
        Node new_node = new Node(new_data);
        new_node.next = head;
        return new_node;
    }

    void printList(Node head) {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.n + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

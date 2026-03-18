import java.util.*;

class Node {

    public int data;
    public Node left, right;

    public Node(int data){
        this.data = data;
        left = right = null;
    }
}

public class BoundaryTraversal {

    public static Node root;

    public static List<Integer> path1 = new ArrayList<>();
    public static List<Integer> path2 = new ArrayList<>();

    public static Node build(String s[]){

        if (s.length == 0 || s[0].equals("N")){
            return null;
        }

        Node root = new Node(Integer.parseInt(s[0]));
        Queue<Node> q = new LinkedList<>();

        q.add(root);
        int i = 1;

        while (!q.isEmpty() && i < s.length){

            Node curr = q.poll();

            String cval = s[i];

            if (!cval.equals("N")){
                int h = Integer.parseInt(cval);
                curr.left = new Node(h);
                q.add(curr.left);
            }

            i++;

            if (i >= s.length){
                break;
            }

            cval = s[i];

            if (!cval.equals("N")){
                int h = Integer.parseInt(cval);
                curr.right = new Node(h);
                q.add(curr.right);
            }

            i++;
        }

        return root;
    }

    // print leaves
    public static void printLeaves(Node node){

        if (node == null){
            return;
        }

        printLeaves(node.left);

        if (node.left == null && node.right == null){
            System.out.print(node.data + " ");
        }

        printLeaves(node.right);
    }

    // left boundary
    public static void printBoundaryLeft(Node node){
        if (node == null){
            return;
        }

        if (node.left != null){
            System.out.print(node.data + " ");
            printBoundaryLeft(node.left);
        } else if (node.right != null){
            System.out.print(node.data + " ");
            printBoundaryLeft(node.right);
        }
    }

    // right boundary
    public static void printBoundaryRight(Node node){

        if (node == null){
            return;
        }

        if (node.right != null){
            printBoundaryRight(node.right);
            System.out.print(node.data + " ");
        } else if (node.left != null){
            printBoundaryRight(node.left);
            System.out.print(node.data + " ");
        }
    }

    // full boundary traversal
    public static void printBoundary(Node node){

        if (node == null){
            return;
        }

        System.out.print(node.data + " ");

        printBoundaryLeft(node.left);

        printLeaves(node.left);
        printLeaves(node.right);

        printBoundaryRight(node.right);
    }

    // main method
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        String s[] = scan.nextLine().split(" ");

        root = build(s);

        printBoundary(root);
        scan.close();
    }
}
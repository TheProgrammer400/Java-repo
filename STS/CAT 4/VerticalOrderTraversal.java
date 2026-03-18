import java.util.*;
import java.util.Map.Entry;

class Node {
    int data;
    Node left, right;

    Node(int data){
        this.data = data;
        left = right = null;
    }
}

public class VerticalOrderTraversal {

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

    public static void preOrderTraversal(Node root, long hd, long vd, TreeMap<Long, Vector<Integer>> m){
        if (root == null){
            return;
        }

        long val = (hd << 30) | vd;

        if (m.get(val) != null){
            m.get(val).add(root.data);
        } else{
            Vector<Integer> v = new Vector<>();
            v.add(root.data);
            m.put(val, v);
        }

        preOrderTraversal(root.left, hd - 1, vd + 1, m);
        preOrderTraversal(root.right, hd + 1, vd + 1, m);
    }

    public static void verticalOrder(Node root){

        TreeMap<Long, Vector<Integer>> mp = new TreeMap<>();
    
        preOrderTraversal(root, 0, 1, mp);

        int prekey = Integer.MAX_VALUE;

        for (Entry<Long, Vector<Integer>> entry : mp.entrySet()){

            if (prekey != Integer.MAX_VALUE && (entry.getKey() >> 30) != prekey){
                System.out.println();
            }

            prekey = (int)(entry.getKey() >> 30);

            for (int x : entry.getValue()){
                System.out.print(x + " ");
            }
        }
    }

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        String s[] = scan.nextLine().split(" ");

        root = build(s);

        verticalOrder(root);
        scan.close();
    }
}
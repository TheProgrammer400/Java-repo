import java.util.*;

class Node{
    int data;
    Node left, right;

    public Node(int data){
        this.data = data;
        left = null;
        right = null;
    }
}

class Pair{
    Node node;
    int hd;

    public Pair(Node node, int hd){
        this.node = node;
        this.hd = hd;
    }
}

public class ViewsOfTree{

    public static Node build(String[] s){

        if(s.length == 0 || s[0].equals("N")){
            return null;
        }

        Node root = new Node(Integer.parseInt(s[0]));
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        int i = 1;

        while(!q.isEmpty() && i < s.length){

            Node curr = q.poll();

            if (!s[i].equals("N")){
                curr.left = new Node(Integer.parseInt(s[i]));
                q.add(curr.left);
            }

            i++;

            if (i >= s.length){
                break;
            }

            if (!s[i].equals("N")){
                curr.right = new Node(Integer.parseInt(s[i]));
                q.add(curr.right);
            }

            i++;
        }

        return root;
    }

    public static void allViews(Node root){
        if(root == null){
            return;
        }

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        Map<Integer, Integer> top = new HashMap<>();
        Map<Integer, Integer> bottom = new TreeMap<>();

        List<Integer> leftView = new ArrayList<>();
        List<Integer> rightView = new ArrayList<>();

        while(!q.isEmpty()){
A            int size = q.size();

            for(int i = 0; i < size; i++){

                Pair p = q.poll();
                Node node = p.node;
                int hd = p.hd;

                // LEFT VIEW
                if(i == 0){
                    leftView.add(node.data);
                }

                // RIGHT VIEW
                if(i == size - 1){
                    rightView.add(node.data);
                }

                // TOP VIEW
                if(!top.containsKey(hd)){
                    top.put(hd, node.data);
                }

                // BOTTOM VIEW
                bottom.put(hd, node.data);

                if(node.left != null){
                    q.add(new Pair(node.left, hd - 1));
                }

                if(node.right != null){
                    q.add(new Pair(node.right, hd + 1));
                }
            }
        }

        // 🔥 Print everything
        System.out.println("Right View: " + rightView);
        System.out.println("Left View: " + leftView);

        System.out.print("Top View: ");
        for(int i = Collections.min(top.keySet()); i <= Collections.max(top.keySet()); i++){
            System.out.print(top.get(i) + " ");
        }
        System.out.println();

        System.out.print("Bottom View: ");
        for(int val : bottom.values()){
            System.out.print(val + " ");
        }
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");

        Node root = build(s);

        allViews(root);
    }
}
import java.util.*;

class Node{
    int index;
    Node left, right;
}

class WinnerTree {

    public static Node createNode(int idx){
        Node newNode = new Node();
        newNode.left = null;
        newNode.right = null;
        newNode.index = idx;
        return newNode;
    }

    public static void traverseHeight(Node root, int[] arr, int[] res){
        if(root == null || (root.left == null && root.right == null)){
            return;
        }

        if(res[0] > arr[root.left.index] && root.left.index != root.index){
            res[0] = arr[root.left.index];
            traverseHeight(root.right, arr, res);
        } else if(res[0] > arr[root.right.index] && root.right.index != root.index){
            res[0] = arr[root.right.index];
            traverseHeight(root.left, arr, res);
        }
    }

    public static void findSecondMin(int[] arr, int n){
        List<Node> li = new LinkedList<>();
        Node root = null;

        for(int i = 0; i < n; i += 2){
            Node t1 = createNode(i);
            Node t2 = null;

            if(i + 1 < n){
                t2 = createNode(i + 1);

                if(arr[i] < arr[i + 1]){
                    root = createNode(i);
                }
                else{
                    root = createNode(i + 1);
                }

                root.left = t1;
                root.right = t2;
                li.add(root);
            }
            else{
                li.add(t1);
            }
        }

        int lsize = li.size();

        while(lsize != 1){
            int last;

            if((lsize & 1) == 1){
                last = lsize - 2;
            }
            else{
                last = lsize - 1;
            }

            for(int i = 0; i < last; i += 2){
                Node f1 = li.remove(0);
                Node f2 = li.remove(0);

                if(arr[f1.index] < arr[f2.index]){
                    root = createNode(f1.index);
                }
                else{
                    root = createNode(f2.index);
                }

                root.left = f1;
                root.right = f2;
                li.add(root);
            }

            if((lsize & 1) == 1){
                li.add(li.get(0));
                li.remove(0);
            }

            lsize = li.size();
        }

        lsize = li.size();

        while(lsize != 1){
            int last;

            if((lsize & 1) == 1){
                last = lsize - 2;
            }
            else{
                last = lsize - 1;
            }

            for(int i = 0; i < last; i += 2){
                Node f1 = li.remove(0);
                Node f2 = li.remove(0);

                if(arr[f1.index] < arr[f2.index]){
                    root = createNode(f1.index);
                }
                else{
                    root = createNode(f2.index);
                }

                root.left = f1;
                root.right = f2;
                li.add(root);
            }

            if((lsize & 1) == 1){
                li.add(li.get(0));
                li.remove(0);
            }

            lsize = li.size();
        }
    }
}
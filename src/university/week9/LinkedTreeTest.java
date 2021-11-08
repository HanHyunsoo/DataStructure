package university.week9;

class Node {
    Object data;
    Node left;
    Node right;
}


class LinkedTree {
    public Node makeBT(Node bt1, Object data, Node bt2) {
        Node root = new Node();
        root.data = data;
        root.left = bt1;
        root.right = bt2;
        return root;
    }

    public void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.data.toString());
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data.toString());
            inOrder(root.right);
        }
    }

    public void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data.toString());
        }
    }
}

public class LinkedTreeTest {
    public static void main(String[] args) {
        LinkedTree T = new LinkedTree();

        Node n7 = T.makeBT(null, "7", null);
        Node n6 = T.makeBT(null, "9", null);
        Node n5 = T.makeBT(null, "3", null);
        Node n4 = T.makeBT(null, "1", null);
        Node n3 = T.makeBT(n6, "-", n7);
        Node n2 = T.makeBT(n4, "+", n5);
        Node n1 = T.makeBT(n2, "*", n3);

//        System.out.print("전위: ");
//        T.preOrder(n1);
//        System.out.println();
//        System.out.print("중위: ");
//        T.inOrder(n1);
//        System.out.println();
//        System.out.print("후위: ");
//        T.postOrder(n1);
//        System.out.println();
        System.out.println("\t\ta");
    }
}
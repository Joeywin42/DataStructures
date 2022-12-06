package assignments;

public class Assignment3 {
    class Node{
        int data;
        Assignment3.Node left, right;

        public Node(int item) {
            data = item;
            left = null;
            right = null;
        }

        @Override
        public String toString(){
            return Integer.toString(data);
        }
    }

    Node root;
    public Assignment3(int data){root = new Node(data);}

    //add left node to point and both are chainable
    public Assignment3 addLeft(Node pointer, int value){
        pointer.left = new Node(value);
        return this;
    }


    //add right node to point
    public Assignment3 addRight(Node pointer, int value){
        pointer.right = new Node(value);
        return this;
    }

    StringBuilder traverse = new StringBuilder();
    public void inOrderTraversal(Node node){
        //Base Case
        if (node == null)
            return;
        //left side attack
        if (node.left != null)
           inOrderTraversal(node.left);
        //append the thingie
        traverse.append(node.data);
        //right side attack
        if (node.right != null)
            inOrderTraversal(node.right);
    }
    boolean bst = true;
    public boolean isBst(String traverse) {

        char[] list = traverse.toCharArray();

        //just check if its in order cause if not from this inorder traversal its not accurate
        for (int i = 0; i < list.length-1; i++){
            if (list[i] > list[i+1]){
                this.bst = false;
            }
        }
        return this.bst;
    }

    //replace root node with the right trees leftest node O(logn) time O(1) space
    public void rootSurgery(Node root){
        Node tempTraverse = root.right;
        Node temperTraverse = tempTraverse.left;
        int tempValue = tempTraverse.data;
        //go to the leftmost node of the right subtree with one variable infront of the other o(n) time
        while(temperTraverse.left != null){
            tempTraverse = tempTraverse.left;
            temperTraverse = tempTraverse.left;
            System.out.println(tempTraverse.data);
        }
        //set the one pointer before, left thingie to null. o(1) time space
        tempTraverse.left = null;
        tempValue = temperTraverse.data;
        root.data = tempValue;


    }
    //run all the methods needed for desired output
    //In total this method is 2O(n) space and time which simplifies to O(n);
    public void startBstCheck(Assignment3.Node root){
        if (root == null){
            throw new IllegalArgumentException("The list empty not a BST");
        }

        //inorder is O(n) time and space
        inOrderTraversal(root);
        System.out.println(traverse);

        //isBst is O(n) space and time
        //ternary for the method return
        System.out.println("This tree is " + (isBst(traverse.toString()) ?
                "a Binary Search Tree" : "not a Binary Search Tree"));

    }

    public static void main(String[] args) {
        Assignment3 test = new Assignment3(4);

        test.addLeft(test.root, 2)
                .addRight(test.root, 6)
                .addLeft(test.root.left, 1)
                .addRight(test.root.left, 3)
                .addLeft(test.root.right, 5)
                .addRight(test.root.right,7);

        //o(logn) time o(1) space
        test.rootSurgery(test.root);


        //o(n) time and space
        test.startBstCheck(test.root);

        //In total O(n) space and time
        //           4
        //        /     \
        //       2       6
        //      / \     / \
        //     1   3   5   7

        //already checks if null and type safety is there.


    }




}

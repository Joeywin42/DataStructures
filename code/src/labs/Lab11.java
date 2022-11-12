package labs;

public class Lab11 {
    class Node{
        int data;
        Node left, right;

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

    //add left node to point and both are chainable
    public Lab11 addLeft(Lab11.Node pointer, int value){
        pointer.left = new Lab11.Node(value);
        return this;
    }

    //add right node to point
    public Lab11 addRight(Lab11.Node pointer, int value){
        pointer.right = new Lab11.Node(value);
        return this;
    }

    //constructer stuff and root
    Node root;
    boolean bst = true;
    public Lab11(int data){root = new Lab11.Node(data);}
    //return the global variable that checks if the tree is bst.
    //O(n) space and time
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
    StringBuilder traverse = new StringBuilder();
    public void inOrderTraversal(Node node){
        //Base Case
        if (node == null)
            return;
        //left side attack
        inOrderTraversal(node.left);
        //append the thingie
        traverse.append(node.data);
        //right side attack
        inOrderTraversal(node.right);
    }
    //run all the methods needed for desired output
    //In total this method is 2O(n) space and time which simplifies to O(n);
    public void startBstCheck(Node root){
        if (root == null){
            throw new IllegalArgumentException("The list empty not a BST");
        }


        //inorder is O(n) time and space
        inOrderTraversal(root);
        System.out.println(traverse);

        //isBst is O(n) space and time
        //ternary for the method return
        System.out.println("This tree is a " + (isBst(traverse.toString()) ?
                "Binary Search Tree" : "not a Binary Search Tree"));

    }



    public static void main(String[] args) {
        Lab11 test = new Lab11(4);
        test.addLeft(test.root, 2)
                .addRight(test.root, 6)
                .addLeft(test.root.left, 1)
                .addRight(test.root.left, 3)
                .addLeft(test.root.right, 5)
                .addRight(test.root.right,7);

        //run everything
        test.startBstCheck(test.root);

        //already type secure thanks to java and if the binary tree is null it will check for that else if its just one
        //root it is already a BST by defualt
    }


}

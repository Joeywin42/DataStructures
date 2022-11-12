package labs;

import java.util.ArrayDeque;

public class Lab10 {
    //Node creation
        private class Node{
            int data;
            Node left, right;

             Node(int value){
                data = value;
                left = null;
                right = null;
            }

            @Override
            public String toString(){
                return Integer.toString(data);
            }
        }

        //add left node to point and both are chainable
        public Lab10 addLeft(Node pointer, int value){
            pointer.left = new Node(value);
            return this;
        }

        //add right node to point
        public Lab10 addRight(Node pointer, int value){
            pointer.right = new Node(value);
            return this;
        }
    //Binary Tree, The name of the class would normally be binaryTree but that makes organization difficult.
    //create root pointer and instantiates it to null;, or the value
        Node root;
        public Lab10(){root = null;}
        public Lab10(int data){root = new Node(data);}

        public void editRoot(int data){
            root = new Node(data);
        }
    //Traverse List by Order Level in O(n) Space (queue) and Time O(n) (One iteration)
        public void levelOrderTraversal(Node rootPointer) {
            //create deque to store calls
            var tree = new ArrayDeque<Node>();
            tree.push(rootPointer);

            //iterates until queue is empty Checks left node than right node adding to queue each step.
            //Then pops into the next left and right.
            while (!tree.isEmpty()) {
                //pointer for less writing.
                var tempN = tree.pop();
                if (tempN.left != null) {
                    tree.add(tempN.left);
                }
                if (tempN.right != null) {
                    tree.add(tempN.right);
                }
                System.out.print(tempN + " ");
            }
        }
    public static void main(String[] args) {


        //4 2 6 1 3 5 7 making the tree
        Lab10 test = new Lab10(4);
        test.addLeft(test.root, 2)
                .addRight(test.root, 6)
                .addLeft(test.root.left, 1)
                .addRight(test.root.left, 3)
                .addLeft(test.root.right, 5)
                .addRight(test.root.right, 7);

        //Test Case for only head and empty
        if (test.root == null){
            System.out.println("Empty Tree");
        } else if (test.root.left == null && test.root.right == null){
            System.out.println(test.root);
        } else {
            test.levelOrderTraversal(test.root);
        }
    }


}

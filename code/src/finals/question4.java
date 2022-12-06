package finals;

import labs.Lab10;

public class question4 {
    static class Node{
        int data;
        Node left, right;

        public Node(int item){
            data = item;
            left = null;
            right = null;
        }
    }
    //add left node to point and both are chainable
    public question4 addLeft(question4.Node pointer, int value){
        pointer.left = new question4.Node(value);
        return this;
    }

    //add right node to point
    public question4 addRight(question4.Node pointer, int value){
        pointer.right = new question4.Node(value);
        return this;
    }
    Node root;
    public question4(){root = null;}
    public question4(int data){root = new question4.Node(data);}

    public int getThirdLowest(Node root){
        Node traversal = root;
        while(traversal.left.left != null){
            traversal = traversal.left;
        }
        return traversal.right.data;

    }


    public static void main(String[] args) {

        question4 test = new question4(4);
        test.addLeft(test.root, 2).addRight(test.root, 6)
                .addLeft(test.root.left, 1).addRight(test.root.left, 3)
                .addLeft(test.root.right, 5).addRight(test.root.right, 7);

        System.out.println(test.getThirdLowest(test.root));

        //       4
        //     /   \
        //    2     6
        //   / \   / \
        //  1   3  5  7
        //the third lowest will always be the leftmost leaf's subtree's right leaf

    }
}


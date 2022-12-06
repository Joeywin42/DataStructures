package finals;


import labs.Lab7;

public class question3 {
    private class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }

    }

    public Node head = null;
    public Node tail = null;

    //adding a node
    public void addNode(int data){
        //creating Node
        Node newNode = new Node(data);

        //Check head if null
        if (head == null){
            //both head and tail will point to new node
            head = newNode;
            tail = newNode;
        } else {
            //newNode will be added with the tail pointing to the newNode.
            tail.next = newNode;
            //newNode will become the tail of the list
            tail = newNode;
        }
    }

    public void deleteThirdLast(){
        System.out.println("running deleteThirdLast");
        Node tempNode = head;
        //pointer behind the tempNode
        Node current = null;

        //look for last 3
        while(tempNode.next.next.next !=null){
            current = tempNode;
            tempNode = tempNode.next;
        }

        current.next = tempNode.next;
        tempNode = null;

    }
    //give the Object a to String
    @Override
    public String toString() {
        StringBuilder returner = new StringBuilder();
        Node tempNode = head;
        //check if list is real
        if (head == null){
            return "Empty List";
        }

        //iterate over the list
        while (tempNode != null){
            returner.append(tempNode.data + ">");
            tempNode = tempNode.next;
        }

        returner.append(" NULL");
        return returner.toString();
    }

    public static void main(String[] args) {
        question3 test = new question3();

        test.addNode(2);
        test.addNode(3);
        test.addNode(1);
        test.addNode(7);
        test.addNode(5);
        test.addNode(18);
        //2, 3, 1, 7, 5, 18

        System.out.println(test);

        test.deleteThirdLast();
        System.out.println(test);

    }

}

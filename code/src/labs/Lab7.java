package labs;

public class Lab7 {

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

    //O(N deletion)
    public void deleteNode(int index){
        System.out.println("Running delete Node");
        //pointer that traverses list
        Node tempNode = head;
        //pointer that is behind the tempNode;
        Node current = null;

        for (int i = 0; i < index; i++) {
            current = tempNode;
            tempNode = tempNode.next;
        }
        //iterate to specified index^^
        if (current != null){
            //current node now goes to nextTemp so its now two ahead. and deleting whats normally ahead will work since
            //the pointer now points to whats double ahead.
            current.next = tempNode.next;

            //delete
            tempNode = null;
        } else {
            head = tail = tempNode.next;

            //delete node
            tempNode = null;
        }

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
            returner.append(tempNode.data + ", ");
            tempNode = tempNode.next;
        }

        //remove the last comma
        returner.delete(returner.length()-2, returner.length());
        return returner.toString();
    }

    public static void main(String[] args) {
        //TestCases would be mostly checking if its null, and we can reduce the code require by making that method.
        //and sticking it everywhere
        //50,11,33,21,40,71
        Lab7 test = new Lab7();
        //Test is the linked list

        test.addNode(50);
        test.addNode(11);
        test.addNode(33);
        test.addNode(21);
        test.addNode(40);
        test.addNode(71);

        //use the to String
        System.out.println(test);

        test.deleteNode(2);
        System.out.println(test);

    }


}

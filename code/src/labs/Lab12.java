package labs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;

public class Lab12 {
    //Graph Class Lab12 for convention with files
    //linked list

    int vertex; //Number of Vertices

    LinkedList<Integer>[] adj; // adjancy lists
    //constructer
    Lab12(int vertex){
        this.vertex = vertex;
        adj = new LinkedList[vertex];

        for (int i = 0; i < adj.length; i++){
            adj[i] = new LinkedList<Integer>();
        }
    }
    void addEdge(int v, int w){
        adj[v].add(w); // add w to the list of v
    }

    //Stack is O(n) space the linked list inside it is actually just a node that points to the rest of the stuff.
    //The program iterates over everything once but its double listed so its O(Vertex + Edges) more vs but Vertex is
    //more so Vertex it is O(v).
    public void depthTraversal(int root){
        System.out.println("Read left to Right \n ---> ---> --->");
        Stack<LinkedList<Integer>> tra = new Stack<>();     //stack for traversal
        HashSet<Integer> specialBois = new HashSet<>();     //unique values

        tra.add(adj[root]);     //start with designated root
        specialBois.add(root);  //fill unique list with designated root

        //goes into stack until it stops having new edges
        while(!tra.isEmpty()){
            //iterate over popped linked list or node
            tra.pop().forEach(edge -> {
                //check if edge is unique and then add to stack if it is
                if(!specialBois.contains(edge)){
                    tra.push(adj[edge]);
                    specialBois.add(edge);
                }
            });
        }
        //print out unique values
        System.out.println(specialBois);

        //0 -> 1, 2;
        //2 -> 3, 4;
        //4 -> 5;
        //1 -> 3;
        //3 -> 5;
        //0 > 1 > 3 > 5
        //0 > 2 > 3 > 5
        //0 > 2 > 4 > 5
    }

    public static void main(String[] args) {
        Lab12 test = new Lab12(7);

        //          point, where it points
        test.addEdge(0, 1);
        test.addEdge(0, 2);
        test.addEdge(2, 3);
        test.addEdge(2, 4);
        test.addEdge(4, 5);
        test.addEdge(1, 3);
        test.addEdge(3, 5);

        test.depthTraversal(0);
        //0 -> 1, 2;
        //2 -> 3, 4;
        //4 -> 5;
        //1 -> 3;
        //3 -> 5;
        //0 > 1 > 3 > 5
        //0 > 2 > 3 > 5
        //0 > 2 > 4 > 5
        //0, 1, 2, 3, 4, 5

        /*
            the test cases were for a graph with a cycle. This is resolved from using a hashset that doesn't allow
            duplicates.
         */

    }
}
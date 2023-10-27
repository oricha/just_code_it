package algoexpert.Graphs;

//        You're given a Node class that has a name and an array of optionat chi1dren nod together, nodes form an acyclie
//        tree-lilke structure, Implement the depthFirstSearch method en the Node class, which takes in an em
//        traverses the tree using the Depth-first Search approach (specifically navigating the tree right),
//        stores all of the nodes' names in the input array, and returns it. Wyou're unfamiliar with Depth-first
//        Search, we recommend watching the Conceptual Ove section of this question's videe explanation before
//        starting code.

import java.util.*;

class Program {
    // Do not edit the class below except
    // for the depthFirstSearch method.
    // Feel free to add new properties
    // and methods to the class.
    static class Node {
        String name;
        List<Node> children = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }

        public List<String> depthFirstSearch(List<String> array) {
            array.add(this.name);
            for( int i=0; i < children.size(); i++){
                children.get(i).depthFirstSearch(array);
            }
            return array;
        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }
}
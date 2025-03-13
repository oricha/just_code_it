import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Clone Graph
 * Given a node in a connected undirected graph, return a deep copy of the graph.
 * Each node in the graph contains an integer value and a list of its neighbors.
 * class Node {
 * public int val;
 * public List<Node> neighbors;
 * }
 * The graph is shown in the test cases as an adjacency list. An adjacency list is a mapping of nodes to lists, used to represent a finite graph. Each list describes the set of neighbors of a node in the graph.
 * For simplicity, nodes values are numbered from 1 to n, where n is the total number of nodes in the graph. The index of each node within the adjacency list is the same as the node's value (1-indexed).
 * The input node will always be the first node in the graph and have 1 as the value.
 *
 * Example 1:
 * Input: adjList = [[2],[1,3],[2]]
 *
 * Output: [[2],[1,3],[2]]
 * Explanation: There are 3 nodes in the graph.
 * Node 1: val = 1 and neighbors = [2].
 * Node 2: val = 2 and neighbors = [1, 3].
 * Node 3: val = 3 and neighbors = [2].
 *
 * Example 2:
 * Input: adjList = [[]]
 *
 * Output: [[]]
 * Explanation: The graph has one node with no neighbors.
 *
 * Example 3:
 *
 * Input: adjList = []
 *
 * Output: []
 * Explanation: The graph is empty.
 *
 * Constraints:
 *
 * 0 <= The number of nodes in the graph <= 100.
 * 1 <= Node.val <= 100
 * There are no duplicate edges and no self-loops in the graph.
 */

/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class CloneGraph {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null; // Handle empty graph case
        }

        Map<Node, Node> visited = new HashMap<>(); // Store original node to cloned node mapping
        return cloneNode(node, visited); // Start cloning from the given node
    }

    private Node cloneNode(Node node, Map<Node, Node> visited) {
        if (visited.containsKey(node)) {
            return visited.get(node); // If already cloned, return the cloned node
        }

        Node clonedNode = new Node(node.val); // Create a new node with the same value
        visited.put(node, clonedNode); // Store the mapping

        for (Node neighbor : node.neighbors) {
            // Recursively clone neighbors and add to the cloned node's neighbors
            clonedNode.neighbors.add(cloneNode(neighbor, visited));
        }

        return clonedNode; // Return the cloned node
    }

    public Nonde cloneGraph2(Node node) {

        if (node == null) {
            return null;
        }
        Map<Node, Node> visited = new HashMap<>();
        return cloneNode(node, visited);
    }

    private cloneNode2(Node node, Map<Node, Node> visited) {
        Node clonedNode = new Node(node.val);
        visite.put(node, clonedNode);

        for( Node neirghbor : node.neighbors) {
            clonedNode.neighbors.add(cloneNode(neirghbor, visited));
        }

        return clonedNode;

    }




    public static void main(String[] args) {
        CloneGraph cg = new CloneGraph();
        Node node = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node.neighbors.add(node2);
        node2.neighbors.add(node3);
        node3.neighbors.add(node);
        Node clonedNode = cg.cloneGraph(node);
        System.out.println(clonedNode.val);
    }


}
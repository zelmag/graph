/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/

//Depth First Search Traversal using the stack that comes with recursion
class Solution {
    HashMap<Node,Node> map = new HashMap<>(); //store all nodes that have been visited
    public Node cloneGraph(Node node) {
        if(node == null){
            return node;
        }
        if(map.containsKey(node)){
            return map.get(node);
        }
        //create a clone
        Node clone = new Node(node.val, new LinkedList<>());
        map.put(node,clone);
        for(Node n : node.neighbors){
            clone.neighbors.add(cloneGraph(n));
        }
        return clone;
    }
}

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

//Breadth First Search Traversal using a queue
class Solution {
    public Node cloneGraph(Node node) {
        if(node==null){
            return node;
        }
         HashMap<Node,Node> map = new HashMap<>(); //store all nodes that have been visited
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(node);
        map.put(node, new Node(node.val,new ArrayList()));
        while(!queue.isEmpty()){
            //make a clone and mark it as visited
            Node og = queue.poll();
            Node clone = map.get(og); //if here, clone is ALWAYS in the map
            //loop through the originals neighbors
            for(Node neighbor : og.neighbors){
                if(!map.containsKey(neighbor)){
                    map.put(neighbor,new Node(neighbor.val, new ArrayList()));
                    queue.add(neighbor); //if wasnt visited, put it on the map
                }
                clone.neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }
}

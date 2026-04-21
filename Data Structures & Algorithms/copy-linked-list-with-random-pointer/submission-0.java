/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return head;
        // 1. Create a copy of every node (just values), and store the mapping: original_node → copied_node
        // 2. Use this map to connect next and random pointers for each copied node.

        // 1
        Map<Node, Node> oc = new HashMap<>(); // oldCopy
        oc.put(null, null);

        Node start = head;
        while(start != null){
            Node copy = new Node(start.val);
            oc.put(start, copy);
            start = start.next;
        }

        // 2
        start = head;
        while(start != null){
            Node temp = oc.get(start);
            temp.next = oc.get(start.next);
            temp.random = oc.get(start.random);
            start = start.next;
        }
        return oc.get(head);
    }
}

//sc and tc: o(n)
class Solution {
    HashMap<Node, Node> map; 
    public Node copyRandomList(Node head) {
        if(head == null) return null; //we're returning null not head cuz deep copy has to be different
        
        map = new HashMap<>();
        Node copyHead = clone(head);
        Node cur = head;
        Node copyCur = copyHead;
        
        while(cur != null) {
            copyCur.next = clone(cur.next);
            copyCur.random = clone(cur.random);
            cur = cur.next;
            copyCur = copyCur.next;
        }    
        return copyHead;    
    }
    private Node clone(Node node) {
        if(node == null) return null;
        if(map.containsKey(node)) return map.get(node);
        Node copyNode = new Node(node.val);
        map.put(node, copyNode);
        return copyNode;
    }
}
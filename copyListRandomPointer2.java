//more efficient Solution: tc is still o(n) but sc is o(1) we aren't using hashmap in this case
class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        
        Node cur = head;
        //Step 1 : Create a deep copy
        while(cur != null) {
            Node copyCur = new Node(cur.val);
            copyCur.next = cur.next;
            cur.next = copyCur;
            cur = cur.next.next;
        }
        //Step 2 : Random pointer
        cur = head;
        while(cur != null) {
            if(cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        //Step 3 : Split into two 
        cur = head;
        Node copyHead = head.next;
        Node copyCur = cur.next;
        
        while(cur != null) {
            cur.next = cur.next.next;
            if(copyCur.next == null) break;
            copyCur.next = copyCur.next.next;
            cur = cur.next;
            copyCur = copyCur.next;
        }
        return copyHead;
    }
}
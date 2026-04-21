/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // we will move forward pointer n step ahead
        // Then normalPtr and forwardPtr will move till forward.next != null
        // Using this normalPtr will point to the element which is going to be removed.
        ListNode fwdPtr = head, prev = null;
        ListNode nrmlPtr = head;


        // 1. Moving ForwardPtr n steps ahead
        for(int i=0; i<n; i++){
            fwdPtr = fwdPtr.next;
        }

        // 2. Finding the element to be removed
        while(fwdPtr != null){
            prev = nrmlPtr;
            fwdPtr = fwdPtr.next;
            nrmlPtr = nrmlPtr.next;
        }

        // 3. Merge Logic of Nodes
        // if starting of list to be removed
        if(prev == null){
            head = nrmlPtr.next;
            return head;
        }else if(nrmlPtr.next == null){ // if ending of list to removed
            prev.next = null;
        }
        prev.next = nrmlPtr.next;
        return head;
    }
}

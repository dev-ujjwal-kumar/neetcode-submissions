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
    private ListNode getKth(ListNode curr, int k){
        while(curr != null && k > 0){
            curr = curr.next;
            k--;
        }
        return curr;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode groupPrev = dummy;

        while(true){
            //getting the kth Node
            ListNode kth = getKth(groupPrev, k);
            if(kth == null){
                break;
            }

            // preserving the head of upcomming group before breaking the link
            ListNode groupNext = kth.next;

            //Reversing the List
            ListNode prev = kth.next;
            ListNode curr = groupPrev.next;
            while(curr != groupNext){
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
             //Fixing the connections
            ListNode temp = groupPrev.next; // new group prev
            groupPrev.next = kth;
            groupPrev = temp;
        }

        return dummy.next;
    }
}

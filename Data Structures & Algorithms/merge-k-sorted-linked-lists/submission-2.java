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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b) -> a.val - b.val);

        //inserting 1st element of each list
        for(ListNode list : lists){
            if(list != null){
                minHeap.offer(list);
            }
        }

        ListNode res = new ListNode(0);
        ListNode curr = res;
        while(!minHeap.isEmpty()){
            ListNode head = minHeap.poll();
            curr.next = head;
            if(head.next != null){
                minHeap.offer(head.next);
            }            
            curr = curr.next;
        }

        return res.next;

    }
}

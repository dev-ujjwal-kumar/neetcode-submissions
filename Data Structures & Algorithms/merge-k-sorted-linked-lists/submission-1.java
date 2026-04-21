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

        //inserting data into heap
        for(ListNode list : lists){
            while(list != null){
                minHeap.offer(list);
                list = list.next;
            }
        }

        ListNode res = new ListNode(0);
        ListNode curr = res;
        while(!minHeap.isEmpty()){
            curr.next = minHeap.poll();            
            curr = curr.next;
        }

        return res.next;

    }
}

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
        List<Integer> nodeList = new ArrayList<>();
        ListNode newList = new ListNode(0);
        ListNode temp = newList;

        // Creating a list of all nodes present
        for(ListNode list : lists){
            while(list != null){
                nodeList.add(list.val);
                list = list.next;
            }
        }

        // Sorting all the values
        Collections.sort(nodeList);

        // Creating a new LL from the sortedList
        for(Integer value : nodeList){
            ListNode newNode = new ListNode(value);
            newList.next = newNode;
            newList = newList.next;
        }

        return temp.next;
    }
}

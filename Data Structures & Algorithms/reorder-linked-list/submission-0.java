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
    private ListNode reverseList(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        ListNode nxt;

        while(curr != null){
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }

        return prev;
    }

    private ListNode findMidNode(ListNode head){
        ListNode slowPtr = head;
        ListNode fastPtr = head;

        while(fastPtr != null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next;
            if(fastPtr == null){
                break;
            }
            fastPtr = fastPtr.next;
        }
        return slowPtr;
    }

    public void reorderList(ListNode head) {
        // 1. Find middleof list
        ListNode slowPtr = head;
        ListNode fastPtr = head.next;

        while(fastPtr != null && fastPtr.next != null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }

        // 2. Reversing Node From middle
        ListNode second = slowPtr.next;
        ListNode prev = slowPtr.next = null;
        while(second != null){
            ListNode nxt = second.next;
            second.next = prev;
            prev = second;
            second = nxt;
        }

        // 3. Merge Logic
        ListNode first = head;
        second = prev;
        while(second != null){
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;
            first.next = second;
            second.next = temp1;
            first = temp1;
            second = temp2;
        }
        
    }
}

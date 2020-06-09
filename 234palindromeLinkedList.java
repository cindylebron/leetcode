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
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        int half = len/2;
        ListNode left = head;
        ListNode prev = null;
        ListNode next = null;
        //reverse first half
        while (--half > 0) {
            next = left.next;
            left.next = next.next;
            next.next = head;
            head = next;
        }
        //left.next is linked to the first node of the second half, point the right pointer to it, if it's the middle node, ignore it
        ListNode right = left.next;
        if (len%2 == 1){
            right = right.next;
        }
        //compare the reversed list with the second half. note that the head is now the new head 
        while (right!=null) {
            if (right.val != head.val)
                return false;
            right = right.next;
            head = head.next;
        }
        return true;
        
    }
}
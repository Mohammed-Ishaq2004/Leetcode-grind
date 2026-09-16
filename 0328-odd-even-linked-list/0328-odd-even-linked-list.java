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
    public ListNode oddEvenList(ListNode head) {
        if(head == null){return null;}
        ListNode odd= head;
        ListNode even = head.next;
        ListNode evenHead = even;
        //We check even because even is always ahead of odd in each iteration, so checking even != null && even.next != null implicitly guarantees that odd and odd.next are valid as well.
        while(even !=null && even.next!=null){
            odd.next=even.next;
            odd=odd.next;
            even.next=odd.next;
            even=even.next;
        }
        odd.next=evenHead;
        return head;
    }
}
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
        if (head == null || head.next == null) return true;
        ListNode slow=head;
        ListNode fast=head;

//Deciding first vs. second half:

// 'slow' ends at the middle (or first middle for even lengths), making 'slow.next' the starting head of the second half.

//Handling even vs. odd lengths:

// Fast/slow pointers automatically leave 'slow.next' as the start of the second half, leaving odd middle nodes safely ignored in the longer first half.
        while(fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode secondHalfHead = reverse(slow.next);
        boolean isPalin = compare(head,secondHalfHead);
        slow.next=reverse(secondHalfHead);
        return isPalin;
    }
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr=head;
        while(curr!=null){
            ListNode next = curr.next;
            curr.next=prev;

            prev=curr;
            curr=next;
        }
        return prev;
    }
    public boolean compare(ListNode p1,ListNode p2){
        //p1 is the longer first half, while p2 is the reversed second half (which is shorter or equal in length), so p2 will always reach null first.
        while(p2!=null){
            if(p1.val!=p2.val){return false;}
            p1=p1.next;
            p2=p2.next;
            }
            return true;
        }
    }
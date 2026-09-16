/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 //we have to chech first whether a cycle exists when we know it exists we reset slow to head then we r at a point where slow and fast are equally diustant from the strat of the cycle then if they move equal steps they both eventually reach the start of the cycle then we exit
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        //traverse while both fast and fast.next is not null
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                slow=head;
                while(slow!=fast){
                slow=slow.next;
                fast=fast.next;
                }
            return slow;
            }
        }
        return null;
    }
}
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
    // Helper function to find the mid-node using Fast & Slow Pointer 

    public static ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next; // fast starts at head.next to get left-mid in even cases

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Helper function to merge two sorted linked lists 
    private static ListNode merge(ListNode left, ListNode right) {
        if (left == null) return right;
        if (right == null) return left;

        // Create a dummy node to simplify list assembly
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while (left != null && right != null) {
            if (left.val <= right.val) {
                temp.next = left;
                temp = left;
                left = left.next;
            } else {
                temp.next = right;
                temp = right;
                right = right.next;
            }
        }

        // Attach remaining elements if any 
        while (left != null) {
            temp.next = left;
            temp = left;
            left = left.next;
        }

        while (right != null) {
            temp.next = right;
            temp = right;
            right = right.next;
        }

        return dummy.next; // Skip dummy head 
    }

    // Main Merge Sort function
    public ListNode sortList(ListNode head)  {

        // Base case: If list is empty or contains a single node 

        if (head == null || head.next == null) {
            return head;
        }

        // 1. Find mid and split the list into two halves 
        ListNode mid = getMid(head);

        ListNode left = head;
        ListNode right = mid.next;
        mid.next = null; // Break the link to separate into two sublists 

        // 2. Recursively sort left and right halves 
        left = sortList(left);
        right = sortList(right);

        // 3. Merge the sorted halves 
        ListNode result = merge(left, right);

        return result;
    }
}
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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

      //  0. We still need the length to handle cases where k >= length
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        k = k % length;
        if (k == 0) return head;

        // STEP 1: Reverse the entire original list
        ListNode reversedHead = reverse(head);

        // STEP 2: Find the Kth node (Till_K) in this newly reversed list
        ListNode tillK = reversedHead;
        for (int i = 1; i < k; i++) {
            tillK = tillK.next;
        }

        // This is the reference variable you were looking for! 
        // It captures the start of the second half before we cut the link.
        ListNode afterK=null;
        if(tillK.next!=null){
             afterK=tillK.next;
        } 
        
        // Break the bond to create two independent lists
        tillK.next = null;

        // STEP 3: Reverse both halves independently
        ListNode firstPartHead = reverse(reversedHead); // Reverses the first k elements
        ListNode secondPartHead = reverse(afterK);      // Reverses the remaining elements

        // STEP 4: Stitch them together
        // The tail of the first part used to be its head (reversedHead)
        reversedHead.next = secondPartHead;

        return firstPartHead;
    }

    // Our standard reliable helper function to reverse a list
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}
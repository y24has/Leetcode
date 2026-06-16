// /**
//  * Definition for singly-linked list.
//  * public class ListNode {
//  *     int val;
//  *     ListNode next;
//  *     ListNode() {}
//  *     ListNode(int val) { this.val = val; }
//  *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//  * }
//  */
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
              // STEP 1: Find the k-th node from the beginning
        ListNode curr = head;
        // Walk forward k - 1 times to stand on the k-th node
        for (int i = 1; i < k; i++) {
            curr = curr.next;
        }
        
        // Save this node! We need to swap its value later.
        ListNode firstK = curr;
        
        // STEP 2: Setup the Ruler
        // secondK starts at the beginning. curr is still at the k-th node.
        ListNode secondK = head;
        
        // STEP 3: Slide the Ruler to the end
        // Move both at the same speed until curr hits the very last node
        while (curr.next != null) {
            curr = curr.next;
            secondK = secondK.next;
        }
        // When the loop ends, secondK is exactly k steps from the end!
        
        // STEP 4: Swap the VALUES (Not the physical pointers!)
        int temp = firstK.val;
        firstK.val = secondK.val;
        secondK.val = temp;
        
        return head;
    }
}


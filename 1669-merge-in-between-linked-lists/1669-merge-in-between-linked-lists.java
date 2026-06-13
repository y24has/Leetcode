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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode prevA = list1;
        // We start at index 0 and move forward (a - 1) times
        for (int i = 1; i < a; i++) {
            prevA = prevA.next;
        }
        
        // ------------------------------------------
        // STEP 2: Find the exact node 'b'
        // ------------------------------------------
        // We can just start walking from where prevA left off!
        ListNode nodeB = prevA;
        // Move forward from (a - 1) up to b
        for (int i = a - 1; i < b; i++) {
            nodeB = nodeB.next;
        }
        
        // ------------------------------------------
        // STEP 3: Find the tail of list2
        // ------------------------------------------
        ListNode tail2 = list2;
        while (tail2.next != null) {
            tail2 = tail2.next;
        }
        
        // ------------------------------------------
        // STEP 4: The Safe Stitching
        // ------------------------------------------
        // Connect the start of the gap to the head of list2
        prevA.next = list2;
        
        // Connect the tail of list2 to the node AFTER the gap
        tail2.next = nodeB.next;
        
        // Since 'a' is guaranteed to be >= 1 by the problem constraints,
        // the original head of list1 never changes. We can just return it safely.
        return list1;
    }
}
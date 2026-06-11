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
    public void reorderList(ListNode head) {
        ListNode slow=head;
        ListNode fast=head.next;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        ListNode curr=slow.next;
        slow.next=null;
        ListNode prev=null;
        while(curr!=null){
            ListNode nextTemp = curr.next;
            curr.next=prev;
            prev=curr;         
            curr=nextTemp;;
          
        }
        
        ListNode second=prev;
        ListNode first=head;
        
        while(second!=null){
             ListNode temp1=first.next;
             ListNode temp2=second.next;
             first.next=second;
             second.next=temp1;
             first=temp1;
             second=temp2;         
        }


    }
}
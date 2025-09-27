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
        ListNode slow=head;
        ListNode fast=head;
        ListNode temp=head;
        ListNode previous=null;
       while(fast!=null && fast.next!=null){
        previous=slow;
        slow=slow.next;
        fast=fast.next.next;
       }
       if(previous!=null ){
       previous.next=null;
       }
       ListNode right=reverse(slow);
       while( temp!=null && right!=null){
        if(temp.val!=right.val) return false;
        temp=temp.next;
        right=right.next;
       }
       return true;
    }
    private static ListNode reverse(ListNode slow){
       ListNode prev=null;
       ListNode forw=null;
       ListNode curr=slow;

       while(curr!=null){
        forw=curr.next;
        curr.next=prev;
        prev=curr;
        curr=forw;
       }
       return prev;
    }
}
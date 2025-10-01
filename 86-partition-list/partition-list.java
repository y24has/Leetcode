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
    public ListNode partition(ListNode head, int x) {
        ListNode lower=new ListNode(0);
        ListNode temp=lower;
        ListNode greater=new ListNode(0);
        ListNode great=greater;
        while(head!=null){
            if(head.val<x){
                temp.next=head;
                temp=temp.next;
            }
            else{
                great.next=head;
                great=great.next;
            }
            head=head.next;
        }
        great.next=null;
        temp.next=greater.next;
        return lower.next;
    }
}
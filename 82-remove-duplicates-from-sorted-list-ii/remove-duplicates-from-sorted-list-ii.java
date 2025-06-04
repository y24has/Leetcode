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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode temp=head;
        ListNode prev=dummy;
        int num=-2;
        while(temp!=null ){
            if(temp.next !=null && temp.val==temp.next.val){
                num=temp.val;
                while(temp!=null && temp.val==num){
                    temp=temp.next;
                }
                prev.next=temp;
            }
            else{
                prev=temp;
                temp=temp.next;
            }
        }
        return dummy.next;
    }
}
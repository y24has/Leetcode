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
    public ListNode mergeNodes(ListNode head) {
        ListNode first=head;
        ListNode curr=head;
        ListNode ans=new ListNode(0);
        ListNode temp=ans;
        while(curr!=null){
            if(curr.val==0){
                int sum=0;
                first=first.next;
                while(first!=null && first.val!=0){
                  sum+=first.val;
                  first=first.next;
                }
                if(sum>0){
                ans.next=new ListNode(sum);
                ans=ans.next;
                first=curr;
                }
            }
            curr=curr.next;
        }
        return temp.next.next;
    }
}
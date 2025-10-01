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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode bfr_left=null;
        ListNode aftr_right=null;
        ListNode lft=null;
        ListNode rght=null;
        ListNode curr=head;
        int count=1;
        ListNode prev=null;
        while(curr!=null){
            
            if(count==left){
              bfr_left=prev;
              lft=curr;
            }
            if(count==right){
              rght=curr;
              aftr_right=rght.next;
              break;
            }
            count++;
            prev=curr;
            curr=curr.next;
        }
        rght.next=null;
        if(bfr_left!=null)
       { 
        bfr_left.next=reverse(lft);
       }else{
        head=reverse(lft);
       }
       lft.next=aftr_right;
        
        return head;
    }
    private static ListNode reverse(ListNode lft){
        ListNode prev=null;
        ListNode forw=null;
        ListNode curr=lft;
                   
        while(curr!=null){
            forw=curr.next;
            curr.next=prev;
            prev=curr;
            curr=forw;
        }
        return prev;
    }
}
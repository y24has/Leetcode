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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode f=list1;
        ListNode s=list2;
        ListNode ans=new ListNode();
        ListNode cur=ans;
        
        while(f!=null && s!=null){
           if(f.val<=s.val){
              cur.next=f;
              f=f.next;
              cur=cur.next;
           }
           else{
             cur.next=s;
              s=s.next;
              cur=cur.next;
           }
        }
           while(f!=null){
            cur.next=f;
            f=f.next;
            cur=cur.next;
           }
            
            while(s !=null){
            cur.next=s;
            s=s.next;
            cur=cur.next;
           }

        
        return ans.next;
    }
}
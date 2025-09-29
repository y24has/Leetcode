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
    public ListNode modifiedList(int[] nums, ListNode head){
        ListNode ans=new ListNode(0);
        ListNode temp=ans;
        ListNode curr=head;
        Set<Integer> set=new HashSet<>();
        for(int num:nums){
             set.add(num);
        }
        while(curr!=null){
            if(!set.contains(curr.val)){
                ans.next=new ListNode(curr.val);
                ans=ans.next;
            }
            curr=curr.next;
        }
        return temp.next;
    }
}
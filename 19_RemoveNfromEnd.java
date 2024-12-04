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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode currNode=head;
        ListNode currNode2=head;
        int count=0;
        if(head==null) return null;
        // if(head.next==null) return null;
        while(currNode!=null){
            count++;
            currNode=currNode.next;
        }
        if(count==n) return head.next;
        if(count<n) return null;

        for(int i=1;i<count-n;i++){
            currNode2=currNode2.next;
        }
        currNode2.next=currNode2.next.next;
       return head;
    }
}
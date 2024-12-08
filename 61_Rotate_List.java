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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null || k==0){
            return head;
        }
        int count=1;
        ListNode curr=head;
        
        while(curr.next!=null){
            curr=curr.next;
            count++;
        }
        curr.next=head;
        ListNode circularcurr=head;
        k=k%count;
int stepsToNewTail = count - k; 
while (stepsToNewTail > 1) {    
    circularcurr = circularcurr.next;
    stepsToNewTail--;
}
head = circularcurr.next;      
circularcurr.next = null;   
return head;
    }
    }

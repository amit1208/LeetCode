class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        Stack<ListNode> stack = new Stack<>();
        ListNode curr = head;
        int length = 0;

        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
            length++;
        }

        curr = head;
        for (int i = 0; i < length / 2; i++) {
            ListNode tail = stack.pop();
            tail.next = curr.next;
            curr.next = tail;
            curr = tail.next;
        }

        curr.next = null;
    }
}

// class Solution {
//     public void reorderList(ListNode head) {
//         if (head == null || head.next == null) return;

//         // Step 1: Find the middle of the list
//         ListNode slow = head, fast = head;
//         while (fast != null && fast.next != null && fast.next.next != null) {
//             slow = slow.next;
//             fast = fast.next.next;
//         }

//         // Step 2: Reverse second half
//         ListNode secondHalf = reverseList(slow.next);
//         slow.next = null; // Cut the list

//         // Step 3: Merge two halves
//         ListNode firstHalf = head;
//         while (secondHalf != null) {
//             ListNode temp1 = firstHalf.next;
//             ListNode temp2 = secondHalf.next;

//             firstHalf.next = secondHalf;
//             secondHalf.next = temp1;

//             firstHalf = temp1;
//             secondHalf = temp2;
//         }
//     }

//     private ListNode reverseList(ListNode head) {
//         ListNode prev = null, curr = head;

//         while (curr != null) {
//             ListNode nextTemp = curr.next;
//             curr.next = prev;
//             prev = curr;
//             curr = nextTemp;
//         }

//         return prev;
//     }
// }

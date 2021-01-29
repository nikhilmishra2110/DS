package LinkedList;
class ListNode {
     int val;
     ListNode next;
     ListNode(int val) { this.val = val; }
 }

public class Solution {
    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;

        ListNode p = l1;
        ListNode q = l2;

        int carry = 0;


        while(p != null || q != null) {
            int x = (p!=null) ? p.val:0;
            int y = (q!=null) ? q.val : 0;

            int sum = x + y + carry;

            carry = sum / 10;
            int lastdigit = sum%10;

            curr.next = new ListNode(lastdigit);


            curr = curr.next;

            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;


    }
}


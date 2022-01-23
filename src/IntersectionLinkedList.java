/**
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 * Daily Coding problem #517
 */
public class IntersectionLinkedList {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len1 = findLength(headA);
        int len2 = findLength(headB);

        if (len1 >= len2) {
            return intersection(headA, headB, len1 - len2);
        } else {
            return intersection(headB, headA, len2 - len1);
        }
    }

    public ListNode intersection(ListNode headA, ListNode headB, int len) {
        ListNode curr1 = headA;
        ListNode curr2 = headB;

        while (len > 0) {
            curr1 = curr1.next;
            len--;
        }

        while (curr1 != null && curr2 != null) {
            if (curr1 == curr2) {
                return curr1;
            } else {
                curr1 = curr1.next;
                curr2 = curr2.next;
            }
        }
        return null;
    }

    public int findLength(ListNode head) {
        ListNode curr = head;
        int len = 0;
        while (curr != null) {
            len++;
            curr = curr.next;
        }
        return len;
    }
}

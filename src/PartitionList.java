/**
 * https://leetcode.com/problems/partition-list/
 * Daily Coding Problem #515
 */
public class PartitionList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode partition(ListNode head, int x) {
        ListNode lesserHead = null;
        ListNode greaterHead = null;

        ListNode lesserTail = null;
        ListNode greaterTail = null;

        ListNode curr = head;
        while (curr != null) {
            if (curr.val < x) {
                if (lesserHead == null) {
                    lesserHead = curr;
                    lesserTail = curr;
                } else {
                    lesserTail.next = curr;
                    lesserTail = lesserTail.next;
                }
            } else {
                if (greaterHead == null) {
                    greaterHead = curr;
                    greaterTail = curr;
                } else {
                    greaterTail.next = curr;
                    greaterTail = greaterTail.next;
                }
            }
            curr = curr.next;
        }

        if (lesserTail != null)
            lesserTail.next = null;

        if (greaterTail != null)
            greaterTail.next = null;

        if (lesserHead == null) {
            return greaterHead;
        }

        lesserTail.next = greaterHead;
        return lesserHead;
    }

}

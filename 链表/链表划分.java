// 给定一个单链表和数值x，划分链表使得所有小于x的节点排在大于等于x的节点之前。
// 你应该保留两部分内链表节点原有的相对顺序。

// 给定链表 1->4->3->2->5->2->null，并且 x=3
// 返回 1->2->2->4->3->5->null

/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
	public ListNode partition(ListNode head, int x) {
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode pre = dummy;
		ListNode cur = head;

		while (pre.next != null && pre.next.val < x)
			pre = pre.next;
		cur = pre;
		while (cur.next != null) {
			if (cur.next.val < x) {
				ListNode temp = cur.next;
				cur.next = temp.next;
				temp.next = pre.next;
				pre.next = temp;
				pre = pre.next;
			} else {
				cur = cur.next;
			}
		}

		return dummy.next;
	}
}



// 在 O(n log n) 时间复杂度和常数级的空间复杂度下给链表排序。

//给出 1->3->2->null，给它排序变成 1->2->3->null.


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
	/**
     * @param head: The head of linked list.
     * @return: You should return the head of the sorted linked list, 
     *	        using constant space complexity.
     */
	// 归并算法
	public ListNode sortList(ListNode head) {

		if (head == null || head.next == null) return head;

		ListNode mid = findMid(head);
		ListNode temp = mid.next;
		mid.next = null;
		ListNode headLeft = sortList(head);
		ListNode headRight = sortList(temp);

		return merge(headLeft, headRight);
	}

	public ListNode findMid(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		return slow;
	}

	public ListNode merge(ListNode left, ListNode right) {
		if (left == null && right == null) return null;
		ListNode node = new ListNode(-1);
		ListNode dummy = node;
		while (left != null && right != null) {
			if (left.val < right.val) {
				dummy.next = left;
				left = left.next;
				dummy = dummy.next;
			} else {
				dummy.next = right;
				right = right.next;
				dummy = dummy.next;
			}
		}
		if (left != null) dummy.next = left;
		else dummy.next = right;

		return node.next;
	}
}










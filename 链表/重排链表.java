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
 *
 *
 * 算法很原始，先找到链表的中间节点，
 * 然后将后半部分提出来，把后半部分反转，
 * 然后将前半部分与反转了的后半部分合并起来，
 * 合并的时候注意交叉合并就可以了
 *
 *
 */

public class Solution {

	public void reorderList(ListNode head) {

		if (head == null || head.next == null) return;

		ListNode mid = findMid(head);
		ListNode tail = reverse(mid.next);
		mid.next = null;
		merge(head, tail);

	}

	private ListNode findMid(ListNode head) {

		ListNode fast = head;
		ListNode slow = head;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		return slow;
	}

	private ListNode reverse(ListNode head) {

		if (head == null || head.next == null) return head;

		ListNode newHead = null;
		while (head != null) {
			ListNode temp = head.next;
			head.next = newHead;
			newHead = head;
			head = temp;			
		}

		return newHead;

	}

	private void merge(ListNode head1, ListNode head2) {
		int index = 0;
		ListNode dummy = new ListNode(0);
		while (head1 != null && head2 != null) {
			if (index % 2 == 0) {
				dummy.next = head1;
				head1 = head1.next;
			} else {
				dummy.next = head2;
				head2 = head2.next;
			}
			dummy = dummy.next;
			index++;
		}

		if (head1 != null) 
			dummy.next = head1;
		else
			dummy.next = head2;
	}
}






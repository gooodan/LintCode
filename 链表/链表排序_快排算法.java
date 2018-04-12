/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 

public class Solution {
	/**
     * @param head: The head of linked list.
     * @return: You should return the head of the sorted linked list,
     *              using constant space complexity.
     */
    public ListNode sortList(ListNode head) {
    	if (head == null || head.next == null) return head;
    	ListNode pivot = head;
    	ListNode p = pivot;
    	head = head.next;
    	pivot.next = null;

    	ListNode small = new ListNode(0);
    	ListNode large = new ListNode(0);
    	ListNode s = small;
    	ListNode l = large;
    	while (head != null) {
    		if (head.val < pivot.val) {
    			s.next = head;
    			s = s.next;
    		} else if (head.val == pivot.val) {
    			p.next = head;
    			p = p.next;
    		} else {
    			l.next = head;
    			l = l.next;
    		}
    		head = head.next;
    	}
    	s.next = null;
    	l.next = null;

    	ListNode ss = sortList(small.next);
    	if (ss == null) {
    		ss = pivot;
    	} else {
    		ListNode temp = ss;
    		while (temp.next != null) {
    			temp = temp.next;
    		}
    		temp.next = pivot;
    	}

    	ListNode ll = sortList(large.next);
    	p.next = ll;

    	return ss;
    }
}




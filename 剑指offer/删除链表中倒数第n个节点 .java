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
     * @param head: The first node of linked list.
     * @param n: An integer
     * @return: The head of linked list.
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // write your code here
        
        // 算法思想：
        // 在head节点前接入一个dummy节点,设置一个preDelete = dummy
        // 先让head走n个节点，然后head和preDelete节点以相同步伐
        // 一直跳转到head == null, 这样preDelete下一个结点就是要删除的节点
        
        if (n <= 0) return null;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode preDelete = dummy;
        
        for (int i = 0; i < n; i++) {
            if (head == null) return null; // 链表节点数大于n，这个判断条件可以不要
            head = head.next;
        }
        
        while (head != null) {
            head = head.next;
            preDelete = preDelete.next;
        }
        
        preDelete.next = preDelete.next.next;
        
        return dummy.next;
        
    }
}
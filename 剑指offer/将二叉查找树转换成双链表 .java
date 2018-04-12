/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 * Definition for Doubly-ListNode.
 * public class DoublyListNode {
 *     int val;
 *     DoublyListNode next, prev;
 *     DoublyListNode(int val) {
 *         this.val = val;
 *         this.next = this.prev = null;
 *     }
 * }
 */

public class Solution {
    /*
     * @param root: The root of tree
     * @return: the head of doubly list node
     */
    public DoublyListNode bstToDoublyList(TreeNode root) {

    	if (root == null) return null;

    	DoublyListNode Root = new DoublyListNode(root.val);

    	if (root.left == null && root.right == null) {
    		return Root;
    	}

    	DoublyListNode left = bstToDoublyList(root.left);
    	DoublyListNode tempLeft = left;
    	while (tempLeft != null && tempLeft.next != null) {
    		tempLeft = tempLeft.next;
    	}
    	if (left != null) {
    		tempLeft.next = Root;
    		Root.prev = tempLeft;
    	}

    	DoublyListNode right = bstToDoublyList(root.right);
    	if (right != null) {
    		right.prev = Root;
    		Root.next = right;
    	}

    	return left != null ? left : Root;

    }

}




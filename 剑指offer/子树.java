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
 */

public class Solution {
    /**
     * @param T1: The roots of binary tree T1.
     * @param T2: The roots of binary tree T2.
     * @return: True if T2 is a subtree of T1, or false.
     */
    public boolean isSubtree(TreeNode T1, TreeNode T2) {
        // write your code here
        
        // T2为null，则一定是T1上的子树
        if (T2 == null) return true;
        
        // T2不为null，T1为null,则一定不是
        if (T1 == null) return false;
        
        // T1和T2都不为null，如果T1和T2相等，则返回true
        if (isEqual(T1, T2)) return true;
        
        // 如果T1和T2不相等也都不为null，则将T1的左右子树和T2比较
        if (isSubtree(T1.left, T2) || isSubtree(T1.right, T2)) return true;
        
        return false;
        
    }
    
    public boolean isEqual(TreeNode T1, TreeNode T2) {
        if (T1 == null || T2 == null) return T1 == T2;
        
        if (T1.val != T2.val) return false;
        
        // 在T1和T2值相等的情况下，比较两个节点对应的左右子节点
        return isEqual(T1.left, T2.left) && isEqual(T1.right, T2.right);
    }
}
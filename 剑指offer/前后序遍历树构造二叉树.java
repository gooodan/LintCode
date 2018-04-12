/*
	算法思路：先利用先序找到根节点，然后匹配根节点在中序中的位置
			从而可以得到左右子树个数，获得其在先序和中序中的位置指针
			递归构建左右子树，将其接入根节点。
*/

public class Solution {

	public TreeNode buildTree(int[] preorder, int[] inorder) {

		if (preorder.length != inorder.length) return null;

		return myBuildTree(preorder, 0, preorder.length - 1 ,
							inorder, 0, inorder.length - 1);
	}

	private int findPosition(int[] arr, int start, int end, int key) {
		int i;
		for (i = start; i <= end; i++) {
			if (arr[i] == key) return i;
		}

		return -1;
	}

	private TreeNode myBuildTree(int[] preorder, int prestart, int preend,
									int[] inorder, int instart, int inend) {
		if (prestart > preend) return null;

		TreeNode root = new TreeNode(preorder[prestart]);

		int position = findPosition(inorder, 0, inorder.length - 1, preorder[prestart]);

		root.left = myBuildTree(preorder, prestart + 1, prestart + position - instart, 
									inorder, instart, position - 1);

		// position - inend + preend + 1 算先序数列中右子树的起始角标
        //                                  是从先序数列的最后往前数        
		root.right = myBuildTree(preorder, position - inend + preend + 1, preend, 
									inorder, position + 1, inend);

		return root;
	}
}





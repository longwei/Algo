package ch4;

import CtCILibrary.*;
/*
 * height is less than one
 * 4.1 check whether a tree is balanced
 * if we sticked with the definition
 * IsHeightBalanced(tree)
    return (tree is empty) or
           (IsHeightBalanced(tree.left) and
            IsHeightBalanced(tree.right) and
            abs(Height(tree.left) - Height(tree.right)) <= 1)
 however this approach, each node will recurse through the whole sub tree. which make it O(n^2).

 * what if the left has millions of node and left has only three node
 */
public class IsTreeBalanced {

	/**
	 * @param args
	 */
    public static void main(String[] args) {
        // Create balanced tree
        int[] array = {0, 1, 2, 3, 5, 6, 7, 8, 9, 10};
        TreeNode root = TreeNode.createMinimalBST(array);
        System.out.println("Is balanced? " + isBalanced(root));
        root.print();
        root.insertInOrder(-1); // Add 4 to make it unbalanced
        root.insertInOrder(-2);
        root.print();
        System.out.println("Is balanced? " + isBalanced(root));
    }

    public static boolean isBalanced(TreeNode root){
        return !(checkHeight(root) == -1);
    }

    public static int checkHeight(TreeNode root){
        if(root == null) {
            return 0;
        }
        int leftH = checkHeight(root.left);
        if(leftH == -1) {
            return -1;
        }
        int rightH = checkHeight(root.right);
        if(rightH == -1){
            return -1;
        }
        int heightDiff = Math.abs(leftH - rightH);
        if (heightDiff > 1 ) {
            return -1;
        } else {
            return Math.max(leftH, rightH) +1;
        }
    }
}

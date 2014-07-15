package ch4;

import CtCILibrary.*;
/*
 * height is less than one
 */
public class IsTreeBalanced {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		TreeNode root = TreeNode.createMinimalBST(array);
		System.out.println("Root? " + root.data);
		System.out.println("Is balanced? " + isBalanced(root));
		
		// Could be balanced, actually, but it's very unlikely...
//		TreeNode unbalanced = new TreeNode(10);
//		for (int i = 0; i < 10; i++) {
//			unbalanced.insertInOrder(AssortedMethods.randomIntInRange(0, 100));
//		}
//		System.out.println("Root? " + unbalanced.data);
//		System.out.println("Is balanced? " + isBalanced(unbalanced));
		
	}
	
	public static int getHeight(TreeNode root){
		if(root == null) return 0;
		return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
	}
	public static boolean isBalanced(TreeNode root){
		if(root == null) return true;
		int heightDiff = getHeight(root.left) - getHeight(root.right);
		if(Math.abs(heightDiff) > 1) {
			return false;
		} else {
			return isBalanced(root.left) && isBalanced(root.right);
		}
	}
	//sol2:
	//short-circuit, early termination
	public static int checkHeight(TreeNode root){
		if(root == null) return 0;
		int leftH = checkHeight(root.left);
		if(leftH == -1){
			return -1;
		}
		int rightH = checkHeight(root.right);
		if(rightH == -1){
			return -1;
		}
		if(Math.abs(leftH - rightH) > 1 ){
			return -1;
		} else {
			return Math.max(leftH, rightH) + 1;
		}
	}
	

}

package com.holen.symmetry_tree;

import com.holen.TreeNode;

public class Solution {
	public boolean isSymmetric(TreeNode root){
		if(root == null){
			return true;
		}
		return check(root.left, root.right);
	}
	
	public boolean check(TreeNode left , TreeNode right){
		if(left==null && right==null){
			return true;
		}
		if(left==null || right==null){
			return false;
		}
		return left.val==right.val && check(left.left, right.right) && check(left.right, right.left);
	}
	
}

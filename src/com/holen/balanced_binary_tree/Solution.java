package com.holen.balanced_binary_tree;

import com.holen.TreeNode;

public class Solution {
	public boolean isBalanced(TreeNode root){
		if(root == null){
			return true;
		}
		
		return Math.abs(depth(root.left)-depth(root.right))<=1 && isBalanced(root.left)&&isBalanced(root.right);
	}
	
	public int depth(TreeNode root){
		if(root == null){
			return 0;
		}
		int max = Math.max(depth(root.left), depth(root.right));
		return max+1;
	}

}

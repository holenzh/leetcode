package com.holen.path_sum;

import com.holen.TreeNode;

public class Solution {
	public boolean hasPathSum(TreeNode root , int sum){
		if(root == null){
			return false;
		}
		
		if(root.left==null && root.right==null){
			return sum==root.val;
		}
		
		return (root.left!=null&&hasPathSum(root.left, sum-root.val))||(root.right!=null&&hasPathSum(root.right, sum-root.val));
	}
}

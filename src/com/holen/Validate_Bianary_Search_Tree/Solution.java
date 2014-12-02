package com.holen.Validate_Bianary_Search_Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.holen.TreeNode;

public class Solution {
	public boolean isValidBST(TreeNode root) {
		List<Integer> list = new ArrayList<>();
	       Stack<TreeNode> stack = new Stack<>();
	       TreeNode node = root;
	       while(node!=null || !stack.isEmpty()){
	           while(node != null){
	               stack.push(node);
	               node = node.left;
	           }
	           if(!stack.isEmpty()){
	               node = stack.pop();
	               list.add(node.val);
	               node = node.right;
	           }
	       }
	       if(list.size() > 0){
	    	   int min = list.get(0);
		       for(int i=1 ; i<list.size() ; i++){
		           if(min >= list.get(i)){
		               return false;
		           }
		           min = list.get(i);
		       }
	       }
	       return true;
	}
}

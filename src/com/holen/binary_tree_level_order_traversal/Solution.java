package com.holen.binary_tree_level_order_traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.holen.TreeNode;

public class Solution {
	public static List<List<Integer>> levelOrder(TreeNode root){
		List<List<Integer>> list = new ArrayList<>();
		if(root == null){
			return list;
		}
		List<Integer> level = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		final TreeNode END = new TreeNode(0);
		queue.offer(root);
		queue.offer(END);
		while(!queue.isEmpty()){
			TreeNode node = queue.poll();
			if(node == END){
				list.add(new ArrayList<Integer>(level));
				level.clear();
				if(!queue.isEmpty()){
					queue.offer(END);
				}
			}else{
				level.add(node.val);
				if(node.left != null){
					queue.offer(node.left);
				}
				if(node.right != null){
					queue.offer(node.right);
				}
			}
		}
		return list;
	}
}

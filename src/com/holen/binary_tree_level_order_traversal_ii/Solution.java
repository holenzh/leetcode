package com.holen.binary_tree_level_order_traversal_ii;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.holen.TreeNode;

public class Solution {
	public List<List<Integer>> levelOrderBottom(TreeNode root){
		LinkedList<List<Integer>> list = new LinkedList<>();
		if(root == null){
			return list;
		}
		List<Integer> level = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		
		final TreeNode end = new TreeNode(0);
		queue.offer(root);
		queue.offer(end);
		
		while(!queue.isEmpty()){
			TreeNode node = queue.poll();
			if(node == end){
				list.push(new ArrayList<>(level));
				level.clear();
				if(!queue.isEmpty()){
					queue.offer(end);
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

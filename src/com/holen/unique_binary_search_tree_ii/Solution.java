package com.holen.unique_binary_search_tree_ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.holen.TreeNode;

public class Solution {
	
	public List<TreeNode> generateTrees(int n){
		int[] array = new int[n];
		for(int i=0 ; i<n ; i++){
			array[i] = i+1;
		}
		return generateTree(array);
	}
	
	public List<TreeNode> generateTree(int[] array){
		List<TreeNode> list = new ArrayList<>();
		if(array.length == 0){
			return new ArrayList<TreeNode>(Collections.<TreeNode>singletonList(null));
		}
		for(int i=0 ; i<array.length ; i++){
			List<TreeNode> left = generateTree(Arrays.copyOfRange(array, 0, i));
			List<TreeNode> right = generateTree(Arrays.copyOfRange(array, i+1, array.length));
			for(TreeNode leftChild : left){
				for(TreeNode rightChild : right){
					TreeNode root = new TreeNode(array[i]);
					root.left = leftChild;
					root.right = rightChild;
					list.add(root);
				}
			}
		}
		return list;
	}

}

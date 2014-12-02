package com.holen.unique_binary_search_tree_i;

public class Solution {
	
	public int numTrees(int n){
		if(n == 0) return 1;
		int num = 0;
		for(int i=0 ; i<n ; i++){
			num += numTrees(i)*numTrees(n-i-1);
		}
		return num;
	}

}

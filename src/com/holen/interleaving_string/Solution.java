package com.holen.interleaving_string;

public class Solution {
	public static boolean isInterleaving(String s1 , String s2 , String s3){
		if(s1.length()+s2.length() != s3.length()){
			return  false;
		}
		
		boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
		dp[0][0] = true;
		for(int i=1 ; i<=s1.length() ; i++){
			if(s1.charAt(i-1) == s3.charAt(i-1)){
				dp[i][0] = dp[i-1][0];
			}
		}
		
		for(int i=1 ; i<=s2.length() ; i++){
			if(s2.charAt(i-1) == s3.charAt(i-1)){
				dp[0][i] = dp[0][i-1];
			}
		}
		
		for(int i=1 ; i<=s1.length() ; i++){
			for(int j=1 ; j<=s2.length() ; j++){
				if(dp[i-1][j]){
					dp[i][j] = (s1.charAt(i-1) == s3.charAt(i+j-1));
					continue;
				}
				
				if(dp[i][j-1]){
					dp[i][j] = (s2.charAt(j-1) == s3.charAt(i+j-1));
					continue;
				}
			}
		}
		
		for(int i=0 ; i<=s1.length() ; i++){
			for(int j=0 ; j<=s2.length() ; j++){
				System.out.print(dp[i][j] + "  ");
			}
			System.out.println("");
		}
		
		return dp[s1.length()][s2.length()];
	}
}

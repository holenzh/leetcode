package com.holen.distinct_subsquences;
/**
 * Given a string S and a string T, count the number of distinct subsequences of T in S.
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 * Here is an example:
 * S = "rabbbit", T = "rabbit"
 * Return 3.
 * @author Holen
 * Date: 2014-11-10
 */
public class Solution {
	/**
	 * 这也是一道典型的dp问题，可以通过填矩阵解决该问题。
	 * S[i]=T[j]  dp[i][j] = dp[i-1][j-1]+dp[i-1][j];
	 * S[i]!=T[j] dp[i][j] = dp[i-1][j].
	 * @param S
	 * @param T
	 * @return
	 */
	public static int numDistinct(String S , String T){
		if(S.length() < T.length()){
			return 0;
		}
		/*
		 * +---+---+---+---+---+---+---+---+
		 * |   | r | a | b | b | b | i | t |
		 * +---+---+---+---+---+---+---+---+
		 * | r | 1 | 1 | 1 | 1 | 1 | 1 | 1 |
		 * +---+---+---+---+---+---+---+---+
		 * | a | 0 | 1 | 1 | 1 | 1 | 1 | 1 |
		 * +---+---+---+---+---+---+---+---+
		 * | b | 0 | 0 | 1 | 2 | 3 | 3 | 3 |
		 * +---+---+---+---+---+---+---+---+
		 * | b | 0 | 0 | 0 | 1 | 3 | 3 | 3 |
		 * +---+---+---+---+---+---+---+---+
		 * | i | 0 | 0 | 0 | 0 | 0 | 3 | 3 |
		 * +---+---+---+---+---+---+---+---+
		 * | t | 0 | 0 | 0 | 0 | 0 | 0 | 3 |
		 * +---+---+---+---+---+---+---+---+
		 */
		int dp[][] = new int[S.length()+1][T.length()+1];
		for(int i=0 ; i<=S.length() ; i++){
			dp[i][0] = 1;
		}
		for(int i=1 ; i<=S.length() ; i++){
			for(int j=1 ; j<=T.length() ; j++){
				if(S.charAt(i-1) == T.charAt(j-1)){
					dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
				}else{
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		return dp[S.length()][T.length()];
	}
}

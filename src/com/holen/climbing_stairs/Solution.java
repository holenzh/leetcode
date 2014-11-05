package com.holen.climbing_stairs;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * @author Holen
 * date:2014-11-05
 */
public class Solution {
	/**
	 * 要知道有多少种方法到顶不是很容易，我们逆着想，要想登顶，那么最后一次爬楼梯要么在n-2的地方上了两个，要么在n-1
	 * 的地方上了一个台阶，我不需要关心n-2和n-1是怎么上来，我只知道我是通过这个方法上来的，有f[n] = f[n-1]+f[n-2]。
	 * 而到n-1的台阶的方法也有两种，一种是通过n-2上一个，或者n-3上两个，所以最后实际上就是斐波那契数列。
	 * 非递归方法
	 * @param n
	 * @return 
	 */
	public int climbStairs(int n) {
		int sum1 = 1;
		int sum2 = 2;
		if(n == 0){
		return 0;	
		}else if(n == 1){
			return sum1;
		}else if(n == 2){
			return sum2;
		}
		for(int i=2 ; i<n ; i++){
			int temp = sum2;
			sum2 = sum1 + sum2;
			sum1 = temp;
		}
		
		return sum2;
    }
	/**
	 * 递归方式实现，时间复杂度高，time-limit-exceed
	 * @param n
	 * @return
	 */
	public int climbStairs2(int n){
		if(n == 0){
			return 0;
		}else if(n == 1){
			return 1;
		}else if(n == 2){
			return 2;
		}
		
		return climbStairs2(n-1) + climbStairs2(n-2);
	}

}

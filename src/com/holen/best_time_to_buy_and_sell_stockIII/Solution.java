package com.holen.best_time_to_buy_and_sell_stockIII;

import java.util.Arrays;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * You may not engage in multiple transactions at the same time.
 * (ie, you must sell the stock before you buy again).
 * @author Holen
 * date: 2014-11-05
 */
public class Solution {
	/**
	 * Dynamic Programming
	 * f[n] = max(f[1...i] + f[i...n]) ,i from 1 to n
	 * The first loop is to calculate the max profit of f[1..i] every i, and keep the answer in the profits[].
	 * The second loop is to calculate the max profit of f[i...n] and it is no need to keep answer in an array
	 * because we can get the maxProfit by compare f[1...i]+f[i...n].
	 * @param prices
	 * @return maxProfit
	 */
	public int maxProfit(int[] prices){
		//when the array length smaller than 1 , return
		if(prices.length < 1){
			return 0;
		}
		
		int[] profits = new int[prices.length];
		int minPrices = prices[0];
		int maxprofits = 0;
		/*
		 * 第一次遍历数组，对于不同的i值，我们得到最大的利润，保存在数组maxProfits[]中，下标对应着数组元素的值。
		 * 最大利润的求法是每次循环保存最小的数，然后用当天的数减去最小的数，得到的利润和之前的最大利润作比较
		 * 实际上这一步就是用来计算f[1...i].
		 */
		for(int i=1 ; i<prices.length ; i++){
			int profit = prices[i] - minPrices;
			//当天的利润和以前的天利润作比较，保存较大的数
			profits[i] = (profits[i-1]>profit?profits[i-1]:profit);
			//更新到i天的最低的价格
			minPrices = (minPrices<prices[i]?minPrices:prices[i]);
		}
		
		int maxPrices = prices[prices.length-1];
		
		/*
		 *这一次逆序遍历数组是为了求出f[i...n]的值，因为i的值不定，所有从后往前遍历。
		 *从后往前遍历的时候难以找到最小的值，所以我们使用最大的值减去当天的值，每次保存最大的值。
		 *然后用最大的值加上上一个循环对应的i天的最大利润，然后求出其中最大的返回
		 */
		for(int i=prices.length-2 ; i>=0 ; i--){
			int profit = maxPrices - prices[i];
			maxprofits = (profits[i] + profit)>maxprofits?profits[i] + profit:maxprofits;
			maxPrices = (maxPrices>prices[i]?maxPrices:prices[i]);
		}
		
		return maxprofits;
	}

}

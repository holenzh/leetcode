package com.holen.best_time_to_buy_and_sell_stock;

/**
 * Say you have an array for which the ith element in the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction .
 * ie. buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * @author Holen
 * Date:2014-11-04
 */
public class Solution {
	
	/**
	 * find the lowest point in the prices;
	 * find the highest point in the prices;
	 * most important: the lowest point must not behind the highest point.
	 * @param prices: stock price everyday
	 * @return the max profit
	 */
	public int maxProfit(int[] prices){
		/**
		 * there is no number in array , return 
		 */
		if(prices.length == 0){
			return 0;
		}
		
		int minPrice = prices[0]; //saving the min price before the day
		int maxProfit = 0; //saving the max profit
		
		/**
		 * through the array to find the min price before the day ,
		 * calculating the profit and maxProfit keep the max one 
		 */
		for(int i=0 ; i<prices.length ; i++){
			int profit = prices[i] - minPrice;
			maxProfit = (maxProfit>profit?maxProfit:profit);
			minPrice = (minPrice<prices[i] ? minPrice:prices[i]);
		}
		
		return maxProfit;
	}

}

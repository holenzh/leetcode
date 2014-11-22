package com.holen.merge_k_sorted_list;

import java.util.List;

import com.holen.ListNode;

public class Solution {
	
	public static ListNode mergeKLists(List<ListNode> lists){
		int size = lists.size();
		if(size == 0){
			return null;
		}
		
		if(size == 1){
			return lists.get(0);
		}
		
		if(size == 2){
			return mergeList(lists.get(0), lists.get(1));
		}
		
		return mergeList(mergeKLists(lists.subList(0, size/2)) , mergeKLists(lists.subList(size/2, size)));
	}

	public static ListNode mergeList(ListNode l1 , ListNode l2){
		ListNode node = new ListNode(0);
		ListNode head = node;
		
		while(l1!=null && l2!=null){
			if(l1.val < l2.val){
				node.next = l1;
				l1 = l1.next;
			}else{
				node.next = l2;
				l2 = l2.next;
			}
			node = node.next;
		}
		
		if(l1==null){
			node.next = l2;
		}else{
			node.next = l1;
		}
		
		return head.next;
	}

}

package com.holen.partition_list;

import com.holen.ListNode;

public class Solution {
	
	public static ListNode partition(ListNode head , int x){
		if(head==null || head.next==null){
			return head;
		}
		ListNode lastNode = null;
		ListNode currentNode = head;
		if(head.val < x){
			lastNode = head;
		}
		while(currentNode.next != null){
			if(currentNode.next.val < x){
				ListNode node = currentNode.next;
				if(lastNode == null){
					currentNode.next = currentNode.next.next;
					node.next = head;
					head = node;
				}else{
					if(lastNode.next == node){
						currentNode = currentNode.next;
					}else{
						currentNode.next = currentNode.next.next;
						node.next = lastNode.next;
						lastNode.next = node;
					}
				}
				lastNode = node;
			}else{
				currentNode = currentNode.next;
			}
		}
		return head;
	}

}

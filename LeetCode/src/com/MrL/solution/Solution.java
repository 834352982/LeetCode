package com.MrL.solution;

import com.MrL.util.ListNode;

import java.util.*;

public class Solution {
	/*
	 * 1.给定一个数target，求数组中两个数相加为target的下标
	 */
	public int[] twoSum(int[] nums, int target) {
		int[] num = new int[2];
		HashMap hashMap = new HashMap();
		for (int i = 0; i < nums.length; i++) {
			//先查后放（重复数，比如[3, 3]）
			if (hashMap.containsKey(target - nums[i])) {
				num[0] = (int) hashMap.get(target - nums[i]);
				num[1] = i;
			}
			hashMap.put(nums[i], i);

//			hashMap.put(nums[i], i);
//			if (hashMap.containsKey(target - nums[i])) {
//				num[1] = i;
//				num[0] = (int) hashMap.get(target - nums[i]);
//			}
		}
		return num;
	}
	/*
	 * 3.最长无重复子串
	 */
	public int lengthOfLongestSubstring(String s) {
//		List<Character> list = new ArrayList<>();
// //		int i = 0, j = 0, maxSubLen = 0;
// //		while(i < s.length()){
// //			if(!list.contains(s.charAt(i))){
// //				list.add(s.charAt(i ++));
// //				maxSubLen = Math.max(maxSubLen, list.size());
// //			}
// //			else{
// //				list.remove((Object)s.charAt(j ++));
// //			}
// //		}
 		Set<Character> set = new HashSet<>();
 		int i = 0, j = 0, maxSubLen = 0;
 		while (i < s.length()) {
 			if (!set.contains(s.charAt(i))) {
 				set.add(s.charAt(i++));
 				maxSubLen = Math.max(maxSubLen, set.size());
 			} else {
 				set.remove(s.charAt(j++));
 			}
 		}
 		return maxSubLen;
 	}
	/*
	 * 4.取两个有序列表的中间值
	 */

	/*
	 * 链表
	 */
	/*
	 * 1.Palindrome Linked List
	 * 判断链表是否回文 时间复杂度O(n)，空间复杂度O(1)
	 */
	public boolean isPalindrome(ListNode head) {
//		if(head == null || head.next == null) return true;
//		if(head.next.next == null && head.val == head.next.val) return true;
//		else if(head.next.next == null && head.val != head.next.val) return false;
//		ListNode pre = head, p = head, rear = head;;
//		while(p != null && p.next != null){
//			pre = pre.next;
//			p = p.next.next;
//		}
//		p = pre.next;
//		rear = p.next;
//		pre.next = null;
//		while(p != null){
//			p.next = pre;
//			pre = p;
//			p = rear;
//			if(rear != null) rear = rear.next != null ? rear.next : null;
//		}
//		p = head;
//		while(p != null && pre != null){
//			if(p.val != pre.val) return false;
//			p = p.next;
//			pre = pre.next;
//		}
//		return true;
		if(head == null ) return true;
		ListNode pre = null, slow = head, quick = head, rear = head.next;
		while(quick.next != null && quick.next.next != null){
			quick = quick.next.next;
			pre = slow;
			slow = rear;
			rear = rear.next;
			slow.next = pre;
		}
		if(quick.next == null) slow = slow.next;
		while(rear != null){
			if(rear.val != slow.val) return false;
			rear = rear.next;
			slow = slow.next;
		}
		return true;
	}
	/*
	 * 2.链表数字相加
	 * 2->4->3 + 5->6->4 = 7->0->8
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2){
		ListNode head = new ListNode(0);
		head.next = null;
		ListNode p = head, ln1 = l1, ln2 = l2;
		int sum = 0, carry = 0;
		while(ln1 != null || ln2 != null || carry != 0){
			sum = (ln1 != null ? ln1.val : 0) + (ln2 != null ? ln2.val : 0) + carry;
			carry = sum / 10;
			p.next = new ListNode(sum % 10);
			p = p.next;
			ln1 = (ln1 != null ? ln1.next : null);//ln1 = ln1.next报错
			ln2 = (ln2 != null ? ln2.next : null);
		}
		return head.next;
	}
	/*
	 * 3.Reverse Linked List
	 * 链表反转
	 */
	public ListNode reverseList(ListNode head) {
		if(head == null || head.next == null) return head;
		ListNode pre = null, cur = head, rear = head.next;
		while(rear != null){
			pre = cur;
			cur = rear;
			rear = rear.next;
			cur.next = pre;
		}
		head.next = null;
		return cur;
	}
	/*
	 * 4.Remove Linked List Elements
	 * 删除等于val的所有元素
	 */
	public ListNode removeElements(ListNode head, int val) {
		if(head == null) return head;
		ListNode pHead = new ListNode(0);
		pHead.next = head;
		ListNode pre = pHead, p = head;
		while(p != null){
			if(p.val == val){
				pre.next = p.next;
				p = pre.next;
			}else{
				pre = pre.next;
				p = p.next;
			}
		}
		return pHead.next;
	}
	/*
	 * 5.Intersection of Two Linked Lists
	 * 两个链表交点
	 */
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA == null || headB == null) return null;
		ListNode nodeA = headA, nodeB = headB;
		int countA = 0, countB = 0, num = 0;
		while(nodeA != null){
			countA ++;
			nodeA = nodeA.next;
		}
		while(nodeB != null){
			countB ++;
			nodeB = nodeB.next;
		}
		nodeA = headA;
		nodeB = headB;
		if(countA > countB){
			num = countA - countB;
			while(num > 0){
				nodeA = nodeA.next;
				num --;
			}
		}else if(countA < countB){
			num = countB - countA;
			while(num > 0){
				nodeB = nodeB.next;
				num --;
			}
		}
		while(nodeA != null && nodeB != null){
			if(nodeA == nodeB) return nodeA;
			nodeA = nodeA.next;
			nodeB = nodeB.next;
		}
		return null;
	}
	/*
	 * 6.Linked List Cycle
	 * 链表有没有环
	 */
	public boolean hasCycle(ListNode head) {
		if(head == null) return false;
		if(head.next == null) return false;
		ListNode slow = head, quick = head;
		while(quick != null && quick.next != null){
			slow = slow.next;
			quick = quick.next.next;
			if(slow == quick) return true;
		}
		return false;
	}
	/*
	 * 7.Merge Two Sorted Lists
	 * 合并两个有序列表
	 */
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		ListNode head = new ListNode(0);
		ListNode ln1 = l1, ln2 = l2, cur = head, pNew = null;
		while(ln1 != null && ln2 != null){
			if(ln1.val <= ln2.val){
				pNew = new ListNode(ln1.val);
				cur.next = pNew;
				cur = cur.next;
				ln1 = ln1.next;
			}else{
				pNew = new ListNode(ln2.val);
				cur.next = pNew;
				cur = cur.next;
				ln2 = ln2.next;
			}
		}
		while(ln1 != null){
			pNew = new ListNode(ln1.val);
			cur.next = pNew;
			cur = cur.next;
			ln1 = ln1.next;
		}
		while(ln2 != null){
			pNew = new ListNode(ln2.val);
			cur.next = pNew;
			cur = cur.next;
			ln2 = ln2.next;
		}
		return head.next;
	}
 }
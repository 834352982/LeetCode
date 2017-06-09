package com.MrL.solution;

import com.MrL.util.Interval;
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
	 * 2.链表数字相加
	 * 2->4->3 + 5->6->4 = 7->0->8
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2){
		ListNode ans = new ListNode(0);
		ans.next = null;
		ListNode ln1 = l1, ln2 = l2, p = ans;
		int sum = 0, carry = 0;
		while(ln1 != null || ln2 != null || carry != 0){
			sum = (ln1 != null ? ln1.val : 0) + (ln2 != null ? ln2.val : 0) + (carry != 0 ? carry : 0);
			carry = sum / 10;
			p.next = new ListNode(sum % 10);
			p = p.next;
			ln1 = ln1.next != null ? ln1.next : null;
			ln2 = ln2.next != null ? ln2.next : null;
		}
		return ans.next;
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
	 * 4.取两个有序列表的中间值 O(m + n)
	 * 有待改进，最优解O(log(m + n))
	 */
	public double findMedianSortedArrays(int[] nums1, int[] nums2){
		int len1 = nums1.length, len2 = nums2.length;
		int len = len1 + len2;
		int[] nums = new int[len];
		int i = 0, j = 0, k = 0;
		while(i < len1 && j < len2){
			if(nums1[i] <= nums2[j]) {
				nums[k ++] = nums1[i ++];
			}else{
				nums[k ++] = nums2[j ++];
			}
		}
		while(i < len1){
			nums[k ++] = nums1[i ++];
		}
		while(j < len2){
			nums[k ++] = nums2[j ++];
		}
		if(len % 2 == 0){
			return (nums[len / 2 - 1] + nums[len / 2]) / 2.0;
		}else {
			return nums[len / 2];
		}
	}

	/*
	 * Sort
	 */

	/*
	 * 1.重复区间合并
	 */
	public  List<Interval> merge(List<Interval> intervals){
		List<Interval> interval = new ArrayList<Interval>();
		return interval;
	}
 }
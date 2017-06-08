package com.MrL.main;

import com.MrL.solution.Solution;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int nums[] = {3, 3};
		int num[] = solution.twoSum(nums, 6);
		System.out.println(num[0]);
		System.out.println(num[1]);
		//System.out.println(solution.lengthOfLongestSubstring("abcabcc"));
	}
}

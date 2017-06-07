package com.MrL.solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
	/*
	 * 最长无重复子串
	 */
	public int lengthOfLongestSubstring(String s) {
//		List<Character> list = new ArrayList<>();
//		int i = 0, j = 0, maxSubLen = 0;
//		while(i < s.length()){
//			if(!list.contains(s.charAt(i))){
//				list.add(s.charAt(i ++));
//				maxSubLen = Math.max(maxSubLen, list.size());
//			}
//			else{
//				list.remove((Object)s.charAt(j ++));
//			}
//		}
		Set<Character> set = new HashSet<>();
		int i = 0, j = 0, maxSubLen = 0;
		while(i < s.length()){
			if(!set.contains(s.charAt(i))){
				set.add(s.charAt(i ++));
				maxSubLen = Math.max(maxSubLen, set.size());
			}
			else{
				set.remove(s.charAt(j ++));
			}
		}
		return maxSubLen;
	}
}

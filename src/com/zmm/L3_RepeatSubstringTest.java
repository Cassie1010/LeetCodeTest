package com.zmm;

import java.util.HashSet;
import java.util.Set;

public class L3_RepeatSubstringTest {
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcabcbb"));
	}
	public static int lengthOfLongestSubstring(String s) {
		int maxL = 0;
		if(s == null) {
			return maxL;
		}
		int length = s.length();
		for(int i = 0; i < length; i++) {
			for(int j = i + 1; j <= length; j++) {
				maxL = lengthOfLongestSubstring(s, i, j, maxL);
			}
		}
        return maxL;
    }
	
	public static int lengthOfLongestSubstring(String s, int start, int end, int maxL) {
		if(s == null || (end - start) < maxL) {
			return maxL;
		}
		Set<Character> set = new HashSet<>();
		Character c = null;
		for(int i = start; i < end; i++) {
			c = s.charAt(i);
			if(set.contains(c)) {
				return maxL;
			}else {
				set.add(c);
			}
		}
		return Math.max(maxL, end - start);
	}
	
}

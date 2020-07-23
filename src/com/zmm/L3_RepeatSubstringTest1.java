package com.zmm;

import java.util.HashSet;
import java.util.Set;

public class L3_RepeatSubstringTest1 {
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcabcbb"));
	}

    public static int lengthOfLongestSubstring(String s) {
		int maxL = 0;
		if(s == null) {
			return maxL;
		}
		int length = s.length();
		Set<Character> set = new HashSet<>();
		Character c = null;
		int result = 0;
		for(int i = 0; i < length; i++) {
			set.clear();
			result = 0;
			for(int j = i; j < length; j++) {
				c = s.charAt(j);
				if(set.contains(c)) {
					break;
				}else {
					set.add(c);
                    maxL = Math.max(maxL, j - i);
				}
			}
		}
        return maxL;
    }
	
}

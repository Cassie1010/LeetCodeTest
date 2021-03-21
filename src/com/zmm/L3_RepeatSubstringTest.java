package com.zmm;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 示例 4:
 *
 * 输入: s = ""
 * 输出: 0
 *  
 *
 * 提示：
 *
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3_RepeatSubstringTest {
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("bbtablud"));
	}
	//滑动窗口
	public static int lengthOfLongestSubstring(String s) {
		int length = s.length();
		if(length == 0 ){
			return 0;
		}
		int maxL = 1;
		for(int i = 0,j = 1; j < length; ) {
			String temp = s.substring(i, j);
			int t = temp.lastIndexOf(s.substring(j, ++j));
			if(t >= 0){
				i = i + t + 1;
			} else {
				maxL = Math.max(maxL, j - i);
			}
		}
        return maxL;
    }

	public static int lengthOfLongestSubstring1(String s) {
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

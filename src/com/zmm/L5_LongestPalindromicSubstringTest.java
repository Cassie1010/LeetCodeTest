package com.zmm;

/**
 * 5. 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 * @author zmm
 * @time 2020/9/16 17:42
 */
public class L5_LongestPalindromicSubstringTest {
	public static void main(String[] args) {
		System.out.println(new L5_LongestPalindromicSubstringTest().longestPalindrome("cbbd"));
	}
	
    public String longestPalindrome(String s) {
    	if(s == null || "".equals(s)) {
    		return "";
    	}
    	Character c = s.charAt(0);
		String result = c.toString();
		String sTemp = null;
		int length = s.length();
		String temp = null;
		int lastIndex = 0;
		boolean b = false;
		for(int i = 0; i < length - 1; i++) {
			for(int m = length; m > i ; m--) {
				sTemp = s.substring(i, m);
				temp = "";
				b = false;
				c = sTemp.charAt(0);
				lastIndex = sTemp.lastIndexOf(c.toString());
				if(0 == lastIndex || lastIndex < result.length()) {
					break;
				}
				temp = sTemp.substring(0, lastIndex + 1);
				for(int j = 0, tLength = temp.length(); j < tLength/2; j++) {
					c = temp.charAt(j);
					if(!c.equals(temp.charAt(tLength - j - 1))) {
						temp = "";
						b = true;
						break;
					}
				}
				result = result.length() > temp.length() ? result : temp;
				if(!b) break;
			}
		}
        return result;
    }

}

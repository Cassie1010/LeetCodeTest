package com.zmm;

import java.util.ArrayList;
import java.util.List;

/**
 * 131. 分割回文串
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *
 * 返回 s 所有可能的分割方案。
 *
 * 示例:
 *
 * 输入: "aab"
 * 输出:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 * @author: zmm
 * @time: 2020/9/16 17:34
 */
public class L131_PalindromePartitioning {
    public static void main(String[] args) {

    }

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if(s == null)
            return result;
        for(int i = 0; i < s.length(); i++){

        }
        return result;
    }
}

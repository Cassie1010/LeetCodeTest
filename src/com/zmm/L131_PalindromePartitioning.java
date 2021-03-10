package com.zmm;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
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
        String s = "abccba";
        List<List<String>> result = new L131_PalindromePartitioning().partition(s);
        System.out.println(JSON.toJSONString(result));
    }

    //方法一
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if(s == null) {
            return result;
        }
        int n = s.length();
        boolean[][] f = new boolean[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(f[i], true);
        }
        for(int i = n-1; i >=0 ; --i){
            for(int j = i+1; j < n; ++j){
                f[i][j] = (s.charAt(i) == s.charAt(j)) && f[i+1][j-1];
            }
        }
        List<String> ans = new ArrayList<>();
        dfs(s, 0, f, result, ans);
        return result;
    }

    public void dfs(String s, int i, boolean[][] f, List<List<String>> result, List<String> ans){
        int n = s.length();
        if(i == n){
            result.add(new ArrayList<>(ans));
        }
        for(int j = i; j < n ; j++){
            if(f[i][j]){
                ans.add(s.substring(i, j + 1));
                dfs(s, j+1, f, result, ans);
                ans.remove(ans.size() - 1);
            }
        }
    }
}

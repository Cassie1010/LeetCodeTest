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
    int n;
    boolean[][] f;
    int[][] f1;
    List<List<String>> ret = new ArrayList<>();
    List<String> ans = new ArrayList<>();
    public static void main(String[] args) {
        String s = "abccba";
        List<List<String>> result = new L131_PalindromePartitioning().partition(s);
        System.out.println(JSON.toJSONString(result));
    }

    //方法一 回溯+动态规划
    public List<List<String>> partition(String s) {
        if(s == null) {
            return ret;
        }
        n = s.length();
        f = new boolean[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(f[i], true);
        }
        for(int i = n-1; i >=0 ; --i){
            for(int j = i+1; j < n; ++j){
                f[i][j] = (s.charAt(i) == s.charAt(j)) && f[i+1][j-1];
            }
        }
        dfs(s, 0);
        return ret;
    }

    public void dfs(String s, int i){
        int n = s.length();
        if(i == n){
            ret.add(new ArrayList<>(ans));
        }
        for(int j = i; j < n ; j++){
            if(f[i][j]){
                ans.add(s.substring(i, j + 1));
                dfs(s, j+1);
                ans.remove(ans.size() - 1);
            }
        }
    }

    //方法二 动态规划
    public List<List<String>> partition1(String s) {
        n = s.length();
        f1 = new int[n][n];

        dfs1(s, 0);
        return ret;
    }

    public void dfs1(String s, int i) {
        if (i == n) {
            ret.add(new ArrayList<String>(ans));
            return;
        }
        for (int j = i; j < n; ++j) {
            if (isPalindrome(s, i, j) == 1) {
                ans.add(s.substring(i, j + 1));
                dfs1(s, j + 1);
                ans.remove(ans.size() - 1);
            }
        }
    }

    // 记忆化搜索中，f[i][j] = 0 表示未搜索，1 表示是回文串，-1 表示不是回文串
    public int isPalindrome(String s, int i, int j) {
        if (f1[i][j] != 0) {
            return f1[i][j];
        }
        if (i >= j) {
            f1[i][j] = 1;//？
        } else if (s.charAt(i) == s.charAt(j)) {
            f1[i][j] = isPalindrome(s, i + 1, j - 1);
        } else {
            f1[i][j] = -1;
        }
        return f1[i][j];
    }

}

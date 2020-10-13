package com.zmm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * 60. 第k个排列
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 *
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 *
 * 说明：
 *
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * 示例 1:
 *
 * 输入: n = 3, k = 3
 * 输出: "213"
 * 示例 2:
 *
 * 输入: n = 4, k = 9
 * 输出: "2314"
 */
public class L60_PermutationSequence {
    public static void main(String[] args) {
        String result = new L60_PermutationSequence().sort(4, 9);
        System.out.println(result);
    }
    private String sort(int n, int k){
        Map<Integer, Integer> map = new HashMap<>();
        Integer temp = 1;
        int[] result = new int[n];
        for(int i = 1; i <= n; i++){
            result[i-1] = i;
            temp *= i;
            map.put(i, temp);
        }
        int divisible = 0;//整除
        int remainder = k - 1;//取余
        int tempValue = 0;
        for(int i = 0; i < n; i++){
            temp = map.get(n - i - 1);
            if(temp == null) break;
            divisible = remainder / temp;
            remainder = remainder % temp;
            if(divisible > 0){
                tempValue = result[i + divisible];
                System.arraycopy(result, i, result, i + 1, divisible);
                result[i] = tempValue;
            }
            if(remainder == 0){
                break;
            }
        }
        StringBuffer sb = new StringBuffer();
        Arrays.stream(result).forEach(i ->{
            sb.append(i);
        });
        return sb.toString();
    }
}

package com.zmm;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed,
 * the only constraint stopping you from robbing each of them
 * is that adjacent houses have security system connected and
 * it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given a list of non-negative integers representing the amount of money of each house,
 * determine the maximum amount of money you can rob tonight without alerting the police.
 */
public class L198_HouseRobber {
    public static void main(String[] args) {
        System.out.println(new L198_HouseRobber().rob(new int[]{3,2,3,11,8}));
    }
    public int rob(int[] nums) {
        int sum = 0;
        int presum = 0;
        int temp = 0;
        for(int x : nums){
            temp = sum;
            sum = Math.max(x + presum, sum);
            presum = temp;
        }
        return sum;
    }
    public int rob2(int[] nums) {
        int jsum = 0;
        int osum = 0;
        int preJsum = 0;
        int preOsum = 0;
        for(int i = 1; i <= nums.length; i ++){
            if(i%2 == 0){
                preOsum = osum;
                osum = nums[i-1] + (preJsum > preOsum ? preJsum : preOsum);
            }else{
                preJsum = jsum;
                jsum = nums[i-1] + (preJsum > preOsum ? preJsum : preOsum);
            }
        }
        return jsum > osum ? jsum : osum;
    }
    public int rob1(int[] nums) {
        int jiSum = 0;
        int oSum = 0;
        //Arrays.asList(nums).stream().filter(i -> i%2==0).forEach();
        Map<Boolean, List<Integer>> collect = IntStream.rangeClosed(1, nums.length).boxed()
                .map(i -> new AbstractMap.SimpleEntry<Integer, Integer>(i, nums[i - 1]))
                .collect(Collectors.partitioningBy(simpleEntry -> Integer.parseInt(simpleEntry.getKey().toString()) % 2 == 0,
                        Collectors.mapping(Map.Entry::getValue, Collectors.toList())));
        List<Integer> jList = collect.get(false);
        List<Integer> oList = collect.get(true);

        return 0;
    }
}

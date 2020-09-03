package com.zmm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 84. 柱状图中最大的矩形
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 *
 *
 *
 *
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 *
 *
 *
 *
 *
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
 *
 *
 *
 * 示例:
 *
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 * @author: zmm
 * @time: 2020/8/14 15:35
 */
public class L84_LargestRectangleInHistogram {
    public static void main(String[] args) {
        System.out.println(new L84_LargestRectangleInHistogram().largestRectangleArea(new int[]{2, 2, 2, 2, 2}));
    }

    //单调栈+常数优化
    public int largestRectangleArea(int[] heights) {
        int largestRectangle = 0;
        if(heights != null) {
            //左侧最近猪蹄高度<当前柱体高度
            int[] leftInstance = new int[heights.length];
            //右侧最近柱体高度<当前柱体高度
            int[] rightInstance = new int[heights.length];
            Arrays.fill(rightInstance, heights.length);
            Stack<Integer> stack = new Stack<>();
            for(int i = 0; i < heights.length ; i++){
                int temp = heights[i];
                int index = -1;
                while (!stack.isEmpty()){
                    if(heights[stack.peek()] < temp){
                        index = stack.peek();
                        break;
                    }else{
                        rightInstance[stack.peek()] = i;
                        stack.pop();
                    }
                }
                stack.push(i);
                leftInstance[i] = index;
            }
            for(int i = 0; i < heights.length ; i++){
                int leftIndex = leftInstance[i];
                int rightIndex = rightInstance[i];
                largestRectangle = Math.max(largestRectangle, heights[i] * (rightIndex - leftIndex - 1));
            }
        }
        return largestRectangle;
    }

    //单调栈
    public int largestRectangleArea2(int[] heights) {
        int largestRectangle = 0;
        if(heights != null) {
            //左侧最近猪蹄高度<当前柱体高度
            int[] leftInstance = new int[heights.length];
            //右侧最近柱体高度<当前柱体高度
            int[] rightInstance = new int[heights.length];
            Stack<Integer> stack = new Stack<>();
            for(int i = 0; i < heights.length ; i++){
                int temp = heights[i];
                int index = -1;
                while (!stack.isEmpty()){
                    if(heights[stack.peek()] < temp){
                        index = stack.peek();
                        break;
                    }else{
                        stack.pop();
                    }
                }
                stack.push(i);
                leftInstance[i] = index;
            }
            stack.clear();
            for(int i = heights.length - 1; i >= 0; i--){
                int temp = heights[i];
                int index = heights.length;
                while (!stack.isEmpty()){
                    if(heights[stack.peek()] < temp){
                        index = stack.peek();
                        break;
                    }else{
                        stack.pop();
                    }
                }
                stack.push(i);
                rightInstance[i] = index;
            }
            for(int i = 0; i < heights.length ; i++){
                int leftIndex = leftInstance[i];
                int rightIndex = rightInstance[i];
                largestRectangle = Math.max(largestRectangle, heights[i] * (rightIndex - leftIndex - 1));
            }
        }
        return largestRectangle;
    }

    //暴力
    public int largestRectangleArea1(int[] heights) {
        List<int[]> list = new ArrayList<>();
        int largestRectangle = 0;
        if(heights != null) {
            for(int i = 0; i < heights.length; i ++){
                int currheights = heights[i];
                if(currheights > 0){
                    int width = 1;
                    for(int m = i - 1; m >= 0; m--){
                        int temp = heights[m];
                        if(temp >= currheights){
                            width ++;
                        }else{
                            break;
                        }
                    }
                    for(int m = i + 1; m < heights.length; m++){
                        int temp = heights[m];
                        if(temp >= currheights){
                            width ++;
                        }else{
                            break;
                        }
                    }
                    largestRectangle = Math.max(largestRectangle, currheights * width);
                }
            }
        }
        return largestRectangle;
    }
}

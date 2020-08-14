package com.zmm;

import java.util.Stack;

/**
 * 42. 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 *
 *
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 *
 * 示例:
 *
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 * @author: zmm
 * @time: 2020/8/6 17:04
 */
public class L42_TrappingRainWater {
    public static void main(String[] args) {
        System.out.println(new L42_TrappingRainWater().trap(new int[]{2,1,0,2,1,0,1,3,2,1,2,1}));
    }
    //可使用双指针
    //栈 可优化
    public int trap(int[] height) {
        if(height == null || height.length == 0){
            return 0;
        }
        int trap = 0;
        int startHeight = height[0];
        int index = 0;
        while (index < height.length - 1){
            int currHeight = height[++ index];
            if(startHeight == 0){
                startHeight = currHeight;
            }else if(currHeight >= startHeight){
                startHeight = currHeight;
            }else{//currHeight < startHeight
                int[] maxHeight = new int[]{currHeight, index};
                Stack<int[]> stack = new Stack();//int[][] 0:height 1:index
                stack.push(maxHeight);
                int maxh = 0;
                for(int i = index + 1; i < height.length; i++){
                    int temp = height[i];
                    stack.push(new int[]{temp, i});
                    if(temp >= startHeight){
                        maxHeight = new int[]{temp, i};
                        break;
                    }else {
                        if(temp >= maxHeight[0]){
                            maxHeight = new int[]{temp, i};
                        }
                    }
                }
                maxh = Math.min(startHeight, maxHeight[0]);
                while(!stack.isEmpty()){
                    int[] curr = stack.pop();
                    if(curr[1] < maxHeight[1]){
                        trap += maxh - curr[0];
                    }else if(curr[1] == maxHeight[1]){
                        index = curr[1];
                        startHeight = curr[0];
                    }
                }
            }
        }
        return trap;
    }
}

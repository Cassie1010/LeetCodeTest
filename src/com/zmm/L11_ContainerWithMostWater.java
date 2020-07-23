package com.zmm;

public class L11_ContainerWithMostWater {
    public static void main(String[] args) {
        System.out.println(new L11_ContainerWithMostWater().maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
    //可优化，嵌套for有重复区间
    public int maxArea(int[] height) {
        int result = 0;
        if(height == null || height.length < 2){
            return result;
        }
        int temp = 0;
        for(int i = 0; i < height.length - 1; i++){
            for(int j = i + 1; j< height.length; j++){
                temp = (j-i)*(height[i] > height[j] ? height[j] : height[i]);
                result = result > temp ? result : temp;
            }
        }
        return result;
    }
}

package com.zmm;

import java.util.Arrays;
import java.util.Stack;

/**
 * 85. 最大矩形
 * 给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 *
 * 示例:
 *
 * 输入:
 * [
 *   ["1","0","1","0","0"],
 *   ["1","0","1","1","1"],
 *   ["1","1","1","1","1"],
 *   ["1","0","0","1","0"]
 * ]
 * 输出: 6
 * @author: zmm
 * @time: 2020/8/27 14:57
 */
public class L85_MaximalRectangle {
    public static void main(String[] args) {
        System.out.println(new L85_MaximalRectangle().maximalRectangle(new char[][]{
//                {'1','1'},
//                {'1','1'}
//                {'1','1'}
//                {'1','0','1','0','0'},
//                {'1','0','1','1','1'},
//                {'1','1','1','1','1'},
//                {'1','0','0','1','0'}
//                {'1','0','1','1','1'},
//                {'0','1','0','1','0'},
//                {'1','1','0','1','1'},
//                {'1','1','0','1','1'},
//                {'0','1','1','1','1'}
                {'0','1','1','0','0','1','0','1','0','1'},
                {'0','0','1','0','1','0','1','0','1','0'},
                {'1','0','0','0','0','1','0','1','1','0'},
                {'0','1','1','1','1','1','1','0','1','0'},
                {'0','0','1','1','1','1','1','1','1','0'},
                {'1','1','0','1','0','1','1','1','1','0'},
                {'0','0','0','1','1','0','0','0','1','0'},
                {'1','1','0','1','1','0','0','1','1','1'},
                {'0','1','0','1','1','0','1','0','1','1'}
        }));
    }

    public int maximalRectangle(char[][] matrix) {
        int largestRectangle = 0;
        if(matrix == null || matrix.length > 0)
            return largestRectangle;
        //
        return largestRectangle;
    }
    public int maximalRectangle1(char[][] matrix) {
        int largestRectangle = 0;
        if(matrix != null && matrix.length > 0){
            //计算当前点的宽度
            int height = matrix.length;
            int width = matrix[0].length;
            int[] columns = new int[width];
            for(int i = 0; i < height; i++) {
                int defaultLeftIndex = 0;
                int defaultRightIndex = width;
                for (int j = 0; j < width; j++) {
                    char temp = matrix[i][j];
                    if(temp == '1'){
                        columns[j]++;
                    }else{
                        columns[j] = 0;
                    }
                    if(j == width - 1 || columns[j] == 0){
                        defaultRightIndex = j;
                        if(defaultRightIndex == defaultLeftIndex){
                            largestRectangle = Math.max(largestRectangle, columns[defaultLeftIndex]);
                        }else{
                            if(j == width - 1 && columns[j] != 0)
                                defaultRightIndex ++;
                            Stack<Integer> stack = new Stack<>();
                            int[] leftIndex = new int[defaultRightIndex - defaultLeftIndex];
                            int[] rightIndex = new int[defaultRightIndex - defaultLeftIndex];
                            Arrays.fill(rightIndex, defaultRightIndex);
                            for(int m = defaultLeftIndex; m < defaultRightIndex; m++){
                                int index = defaultLeftIndex - 1;
                                while (!stack.isEmpty()){
                                    if(columns[m] > columns[stack.peek()]){
                                        index = stack.peek();
                                        break;
                                    }else{
                                        rightIndex[stack.peek() - defaultLeftIndex] = m;
                                        stack.pop();
                                    }
                                }
                                stack.push(m);
                                leftIndex[m - defaultLeftIndex] = index;
                            }
                            //计算面积
                            for(int m = defaultLeftIndex; m < defaultRightIndex; m++){
                                largestRectangle = Math.max(largestRectangle,
                                        columns[m]*(rightIndex[m - defaultLeftIndex] - leftIndex[m - defaultLeftIndex] - 1));
                            }
                        }
                        defaultLeftIndex = j + 1;
                    }
                }
            }
        }
        return largestRectangle;
    }

}

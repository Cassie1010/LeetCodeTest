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
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
//                {'1','0','1','1','1'},
//                {'0','1','0','1','0'},
//                {'1','1','0','1','1'},
//                {'1','1','0','1','1'},
//                {'0','1','1','1','1'}
//                {'0','1','1','0','0','1','0','1','0','1'},
//                {'0','0','1','0','1','0','1','0','1','0'},
//                {'1','0','0','0','0','1','0','1','1','0'},
//                {'0','1','1','1','1','1','1','0','1','0'},
//                {'0','0','1','1','1','1','1','1','1','0'},
//                {'1','1','0','1','0','1','1','1','1','0'},
//                {'0','0','0','1','1','0','0','0','1','0'},
//                {'1','1','0','1','1','0','0','1','1','1'},
//                {'0','1','0','1','1','0','1','0','1','1'}
        }));
    }

    //动态规划-每个点的最大高度
    public int maximalRectangle(char[][] matrix) {
        int largestRectangle = 0;
        if(matrix == null || matrix.length == 0)
            return largestRectangle;
        int height = matrix.length;
        int width = matrix[0].length;
        //高度
        int[] heights = new int[width];
        //左边0最近下标
        int[] leftIndex = new int[width];
        //右边0最近下标
        int[] rightIndex = new int[width];
        Arrays.fill(rightIndex, width);
        for(int m = 0; m < height; m ++){
            //高度
            for(int n = 0; n < width; n ++){
                if('1' == matrix[m][n])
                    heights[n]++;
                else
                    heights[n] = 0;
            }
            //左边0最近下标
            int curr_left = 0;
            for(int n = 0; n < width; n ++){
                if('1' == matrix[m][n])
                    leftIndex[n] = Math.max(leftIndex[n], curr_left);
                else{
                    leftIndex[n] = 0;
                    curr_left = n + 1;
                }
            }
            //右边最近下标
            int curr_right = width;
            for(int n = width - 1; n >= 0; n --){
                if('1' == matrix[m][n])
                    rightIndex[n] = Math.min(rightIndex[n], curr_right);
                else{
                    rightIndex[n] = width;
                    curr_right = n;
                }
            }
            for(int n = 0; n < width; n ++){
                largestRectangle = Math.max(largestRectangle, (rightIndex[n] - leftIndex[n]) * heights[n]);
            }
        }
        return largestRectangle;
    }

    //动态规划-柱状图
    public int maximalRectangle2(char[][] matrix) {
        int largestRectangle = 0;
        if(matrix == null || matrix.length == 0)
            return largestRectangle;
        int height = matrix.length;
        int width = matrix[0].length;
        //每行的宽度
        int[][] rowWidth = new int[height][width];
        //每行的高度
        int[] rowHeight = new int[width];
        for(int h = 0; h < height; h++){
            int wTemp = 0;
            for(int w = 0; w < width; w++){
                if('1' == matrix[h][w]){
                    wTemp++;
                    rowWidth[h][w]=wTemp;//当前宽度加一
                    rowHeight[w]++;//当前高度加一
                    //计算当前点最大矩形
                    if(wTemp == 1){
                        largestRectangle = Math.max(largestRectangle, rowHeight[w]);
                    }else{
                        int minWidth = rowWidth[h][w];
                        for(int i = 0; i < rowHeight[w]; i++){
                            minWidth = Math.min(minWidth, rowWidth[h - i][w]);
                            largestRectangle = Math.max(largestRectangle, (i + 1) * minWidth);
                        }
                    }
                }else{
                    //宽高置为0
                    wTemp = 0;
                    rowHeight[w] = 0;
                }
            }
        }
        return largestRectangle;
    }

    //单调栈+常数优化（柱状图）
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

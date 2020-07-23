package com.zmm;

/**
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 *
 * 示例:
 *
 * 输入:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * 输出: 4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximal-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: zmm
 * @time: 2020/7/16 13:37
 */
public class L221_MaximalSquare {
    public static void main(String[] args) {
        System.out.println(new L221_MaximalSquare().maximalSquare(new char[][]
                {{'1' , '0' , '1' , '1' , '1' }
                , {'1' , '0' , '1' , '1' , '1' }
                , {'1' , '1' , '1' , '1' , '1' }
                , {'1' , '0' , '0' , '1' , '0' }}));
    }
    public int maximalSquare(char[][] matrix) {
        int maximalSquare = 0;
        if(matrix != null && matrix.length > 0){
            int[] side = new int[matrix[0].length];
            int[][] square = new int[2][matrix[0].length];
            for (int x = 0; x < matrix.length; x++){
                int sidetemp = 0;
                for(int y = 0; y < matrix[0].length; y++){
                    int temp = matrix[x][y] == '1' ? 1 : 0;
                    side[y] = temp == 1 ? 1 + side[y] : 0;
                    sidetemp = temp == 0 ? 0 : sidetemp + 1;
                    int tt;
                    int squareTemp;
                    if(y > 0){
                        tt = sidetemp > side[y] ? side[y] : sidetemp;
                        tt = square[0][y - 1] == 0 ? temp : square[0][y - 1] + 1 < tt ? square[0][y - 1] + 1 : tt;
                        square[0][y - 1] = square[1][y - 1];
                    }else{
                        tt = temp;
                    }
                    squareTemp = tt * tt;
                    square[1][y] = tt;
                    maximalSquare = maximalSquare > squareTemp ? maximalSquare : squareTemp;
                }
            }
        }
        return maximalSquare;
    }
}

package com.zmm;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 *
 *
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 *
 * 说明：m 和 n 的值均不超过 100。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * 输出: 2
 * 解释:
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-paths-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zmm
 * @time: 2020/7/7 9:24
 */
public class L63_UniquePathsII {
    public static void main(String[] args) {
        System.out.println(new L63_UniquePathsII().uniquePathsWithObstacles(new int[][]{
                {0,0,0},
                {0,0,0},
                {0,0,0}
        }));
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[] f = new int[m];

        f[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (obstacleGrid[i][j] == 1) {
                    f[j] = 0;
                    continue;
                }
                if (j - 1 >= 0 && obstacleGrid[i][j - 1] == 0) {
                    f[j] += f[j - 1];
                }
            }
        }
        return f[m - 1];
    }
    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        int paths = 0;
        if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0){
            return paths;
        }
        int xlength = obstacleGrid.length;
        int ylength = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1 || obstacleGrid[xlength - 1][ylength - 1] == 1){
            return paths;
        }
        paths = 1;
        if(xlength == 1 || ylength == 1){
            return paths;
        }
        paths = 2;
        boolean xpathpass = true;
        boolean ypathpass = true;
        for(int x=0; x < xlength; x++){
            for(int y=0; y < ylength; y++){
                int temp = obstacleGrid[x][y];
                if(temp == 1){
                    if(x == 0 || y == ylength - 1)
                        ypathpass = false;
                    if(y == 0 || x == xlength - 1)
                        xpathpass = false;
                }else if(x != 0 && y != 0){
                    //计算到达路线的次数
                    //当前对象是否可达
                    if(x > 0){
                        if(0 == obstacleGrid[x - 1][y])
                            if(x != -1 || (x == 1 && xpathpass))
                                paths ++;
                    }
                    if(y > 0){
                        if(0 == obstacleGrid[x][y - 1])
                            if(y != -1 || (y == 1 && ypathpass))
                                paths ++;
                    }
                }
            }
        }
        paths -= xpathpass ? 0: 1;
        paths -= ypathpass ? 0: 1;
        return paths;
    }
}

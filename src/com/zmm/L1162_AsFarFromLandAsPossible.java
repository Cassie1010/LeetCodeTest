package com.zmm;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 你现在手里有一份大小为 N x N 的「地图」（网格） grid，上面的每个「区域」（单元格）都用 0 和 1 标记好了。其中 0 代表海洋，1 代表陆地，
 * 请你找出一个海洋区域，这个海洋区域到离它最近的陆地区域的距离是最大的。
 *
 * 我们这里说的距离是「曼哈顿距离」（ Manhattan Distance）：(x0, y0) 和 (x1, y1) 这两个区域之间的距离是 |x0 - x1| + |y0 - y1| 。
 *
 * 如果我们的地图上只有陆地或者海洋，请返回 -1。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：[[1,0,1],[0,0,0],[1,0,1]]
 * 输出：2
 * 解释：
 * 海洋区域 (1, 1) 和所有陆地区域之间的距离都达到最大，最大距离为 2。
 * 示例 2：
 *
 *
 *
 * 输入：[[1,0,0],[0,0,0],[0,0,0]]
 * 输出：4
 * 解释：
 * 海洋区域 (2, 2) 和所有陆地区域之间的距离都达到最大，最大距离为 4。
 *  
 *
 * 提示：
 *
 * 1 <= grid.length == grid[0].length <= 100
 * grid[i][j] 不是 0 就是 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/as-far-from-land-as-possible
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: zmm
 * @time: 2020/7/17 14:37
 */
public class L1162_AsFarFromLandAsPossible {
    public static void main(String[] args) {
        System.out.println(new L1162_AsFarFromLandAsPossible().maxDistance(new int[][]{{1, 0, 0}, {0, 0, 0}, {0, 0, 0}}));
    }
    //官方 BFS
    public int maxDistance(int[][] grid) {
        Queue<int[]> lands = new ArrayDeque();
        int xlength = grid.length;
        int ylength = grid[0].length;
        for(int x = 0; x < xlength; x++){
            for(int y = 0; y < ylength; y ++){
                if(grid[x][y] == 1){
                    lands.offer(new int[]{x, y});//标记所有陆地
                }
            }
        }
        int[] point = null;
        boolean hasOcean = false;
        int[][] dxy = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};//周围的坐标
        while (!lands.isEmpty()){
            point = lands.poll();
            for(int i = 0; i < 4; i++){
                int newx = point[0] + dxy[i][0];
                int newy = point[1] + dxy[i][1];
                if(newx < 0 || newx >= xlength || newy < 0 || newy >= ylength || grid[newx][newy] != 0) {
                    continue;
                }
                hasOcean = true;
                //为海洋的时候计数，并加入队列
                //增加步数，因为要取海洋到达的最近的陆地，则最先入队列表示为最近，更改值不为0即标记为已处理
                grid[newx][newy] = grid[point[0]][point[1]] + 1;
                lands.offer(new int[]{newx, newy});
            }
        }
        if(point == null || !hasOcean){
            return -1;
        }
        return grid[point[0]][point[1]] - 1;
    }

    public int maxDistance1(int[][] grid) {
        int maxInstance = -1;
        List<int[]> lands = new ArrayList<>();
        int xlength = grid.length;
        int ylength = grid[0].length;
        for(int x = 0; x < xlength; x++){
            for(int y = 0; y < ylength; y ++){
                if(grid[x][y] == 1){
                    lands.add(new int[]{x, y});
                }
            }
        }
        if (lands.size() != 0 && lands.size() != xlength*ylength){
            for(int x = 0; x < xlength; x++){
                for(int y = 0; y < ylength; y ++){
                    if(grid[x][y] == 0){
                        int minInstance = xlength*ylength;
                        for (int l = 0; l < lands.size(); l ++){
                            int[] temp = lands.get(l);
                            minInstance = Math.min(minInstance, Math.abs(temp[0] - x) + Math.abs(temp[1] - y));
                        }
                        maxInstance = Math.max(minInstance, maxInstance);
                    }
                }
            }
        }
        return maxInstance;
    }
}

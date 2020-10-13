package com.zmm.interview;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @表示小昆虫初始位置
 * .表示空地
 * *可破坏的障碍物
 * #表示不可破坏障碍物
 * 问：最少经过多少次*才可以逃出迷宫
 * @author: zmm
 * @time: 2020/9/21 9:57
 */
public class InsectsEscapeMaze {

    public static void main(String[] args) {
        System.out.println(new InsectsEscapeMaze().minCountUseStar(new String[][]{
//                {"。", "*", "#"},
//                {"。", "@", "#"},
//                {"。", ".", "*"},
//                {"#", "#", "#"},
//                {"#", "@", "#"},
//                {"#", "*", "#"},
//                {"#", "#", "#"},
//                {"#", "@", "*"},
//                {"#", ".", "#"},
                {".", "#", "#", "."},
                {"#", "@", ".", "#"},
                {"#", "*", ".", "*"},
                {".", "#", ".", "#"},
        }));
    }

    private int minCountUseStar(String[][] maze){
        int minCount = -1;
        int xl = maze.length;
        int yl = maze[0].length;
        //队列
        Queue<int[]> queue = new ArrayDeque();
        //算出初始起点
        label:
        for(int i = 0; i<xl; i++){
            for(int j = 0; j < yl; j++){
                if("@".equals(maze[i][j])){
                    queue.offer(new int[]{i, j, 0});
                    break label;
                }
            }
        }
        int[][][] count = new int[xl][yl][2];//0 当前*次数 1 是否已被经过
        while (!queue.isEmpty()){
            int[] curr = queue.poll();//当前下标
            int x = curr[0];
            int y = curr[1];
            int lastCount = curr[2];
            String currValue = maze[x][y];
            int currCount = count[x][y][0];//当前*次数
            boolean ispass = count[x][y][1] == 0 ? false : true;
            if("#".equals(currValue)){
                continue;
            }else if("*".equals(currValue)){
                lastCount ++;
            }
            if(ispass && lastCount >= currCount){
                continue;
            }
            count[x][y][0] = lastCount;
            count[x][y][1] = 1;
            if(x == 0 || x == xl - 1 || y == 0 || y == yl - 1){
                if(minCount == -1)
                    minCount = lastCount;
                else
                    minCount = Math.min(minCount, lastCount);
            }else{//若已到达墙壁则表示已经是最短了
                queue.offer(new int[]{x - 1, y, lastCount});
                queue.offer(new int[]{x + 1, y, lastCount});
                queue.offer(new int[]{x, y - 1, lastCount});
                queue.offer(new int[]{x, y + 1, lastCount});
            }
        }
        return minCount;
    }

    private int minCountUseStar1(String[][] maze){
        int minCount = -1;
        int xl = maze.length;
        int yl = maze[0].length;
        //队列
        Queue<int[]> queue = new ArrayDeque();
        //算出初始起点
        label:
        for(int i = 0; i<xl; i++){
            for(int j = 0; j < yl; j++){
                if("@".equals(maze[i][j])){
                    queue.offer(new int[]{i, j, 0});
                    break label;
                }
            }
        }
        int[][][] count = new int[xl][yl][2];//0 当前*次数 1 是否已被经过
        while (!queue.isEmpty()){
            int[] curr = queue.poll();//当前下标
            int x = curr[0];
            int y = curr[1];
            int lastCount = curr[2];
            String currValue = maze[x][y];
            int currCount = count[x][y][0];//当前*次数
            boolean ispass = count[x][y][1] == 0 ? false : true;
            if("#".equals(currValue)){
                continue;
            }else if("*".equals(currValue)){
                lastCount ++;
            }
            if(ispass && lastCount >= currCount){
                continue;
            }
            count[x][y][0] = lastCount;
            count[x][y][1] = 1;
            if(x == 0 || x == xl - 1 || y == 0 || y == yl - 1){
                if(minCount == -1)
                    minCount = lastCount;
                else
                    minCount = Math.min(minCount, lastCount);
            }
            if(x != 0)
                queue.offer(new int[]{x - 1, y, lastCount});
            if(x != xl - 1)
                queue.offer(new int[]{x + 1, y, lastCount});
            if(y != 0)
                queue.offer(new int[]{x, y - 1, lastCount});
            if(y != yl - 1)
                queue.offer(new int[]{x, y + 1, lastCount});
        }
        return minCount;
    }
}

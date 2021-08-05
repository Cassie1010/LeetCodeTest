package com.zmm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 218. 天际线问题
 * 城市的天际线是从远处观看该城市中所有建筑物形成的轮廓的外部轮廓。
 * 现在，假设您获得了城市风光照片（图A）上显示的所有建筑物的位置和高度，请编写一个程序以输出由这些建筑物形成的天际线（图B）。
 *
 * Buildings Skyline Contour
 *
 * 每个建筑物的几何信息用三元组 [Li，Ri，Hi] 表示，其中 Li 和 Ri 分别是第 i 座建筑物左右边缘的 x 坐标，Hi 是其高度。
 * 可以保证 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX 和 Ri - Li > 0。您可以假设所有建筑物都是在绝对平坦且高度为 0 的表面上的完美矩形。
 *
 * 例如，图A中所有建筑物的尺寸记录为：[ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] 。
 *
 * 输出是以 [ [x1,y1], [x2, y2], [x3, y3], ... ] 格式的“关键点”（图B中的红点）的列表，它们唯一地定义了天际线。关键点是水平线段的左端点。
 * 请注意，最右侧建筑物的最后一个关键点仅用于标记天际线的终点，并始终为零高度。此外，任何两个相邻建筑物之间的地面都应被视为天际线轮廓的一部分。
 *
 * 例如，图B中的天际线应该表示为：[ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ]。
 *
 * 说明:
 *
 * 任何输入列表中的建筑物数量保证在 [0, 10000] 范围内。
 * 输入列表已经按左 x 坐标 Li  进行升序排列。
 * 输出列表必须按 x 位排序。
 * 输出天际线中不得有连续的相同高度的水平线。例如 [...[2 3], [4 5], [7 5], [11 5], [12 7]...] 是不正确的答案；三条高度为 5 的线应该在最终输出中合并为一个：[...[2 3], [4 5], [12 7], ...]
 * @author: zmm
 * @time: 2020/10/13 10:55
 */
public class L218_theSkylineProblem {
    public static void main(String[] args) {
        new L218_theSkylineProblem().getSkyline1(new int[][]{
                {1,2,3,4,5,6},
                {3,4,5,6,7,8}
        });
    }

    public List<List<Integer>> getSkyline(int[][] buildings) {
        //转换成点排序
        List<List<Integer>> result = new LinkedList<>();
        if (buildings == null || buildings.length == 0)
            return result;
//        Queue<Integer[]> queue = new LinkedBlockingQueue<Integer[]>();
        //0 x坐标 1 高度，放后节点
        PriorityQueue<Integer[]> queue = new PriorityQueue<Integer[]>(new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] ints, Integer[] t1) {
                return ints[0] - t1[0];
            }
        });
        List<Integer> last = null;
        for(int i = 0; i < buildings.length; i++){
            int[] curr = buildings[i];
            if(queue.isEmpty()){
                last = new ArrayList<>();
                result.add(last);
                last.add(curr[0]);
                last.add(curr[1]);
                queue.offer(new Integer[]{curr[2], curr[1]});
            }else{
                Integer[] currR = queue.peek();
                if(curr[0] == last.get(0)){
                    if(curr[1] > last.get(1)){
                        last.add(1,curr[1]);
                    }
                }else {
                    //curr[0]>last.get(0),不存在<的情况
                    if(curr[0] > currR[0]){
//                        queue.
                    }
                    while (!queue.isEmpty() && curr[0] > currR[0]){
                        currR = queue.poll();
                    }
                    if (curr[1] > last.get(1)) {

                    }
                }
            }
        }
        return result;
    }

    public List<List<Integer>> getSkyline1(int[][] buildings) {
        //转换成点排序
        List<List<Integer>> result = new LinkedList<>();
        if(buildings == null || buildings.length == 0)
            return result;
        //0 x坐标 1 y坐标
        PriorityQueue<Integer[]> queue = new PriorityQueue<Integer[]>(new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] ints, Integer[] t1) {
                return ints[0] - t1[0];
            }
        });
        for(int i = 0; i < buildings.length; i++){
            int[] temp = buildings[i];
            queue.offer(new Integer[]{temp[0], temp[1]});
            queue.offer(new Integer[]{temp[2], temp[1]});
        }
//        Integer[][] elements = new Integer[queue.size()][2];
//        queue.toArray(elements);
        Integer[][] elements = queue.toArray(new Integer[0][0]);

        List<Integer> last = Arrays.asList(elements[0]);
        result.add(last);
        for(int i = 0; i < queue.size();){
            List<Integer> next = new ArrayList<>();
            for(int j = i; j < queue.size(); j++){
                Integer[] curr = elements[j];
                /*if(next.isEmpty()){
                    next.add(curr[0]);
                    next.add(curr[1]);
                }else if(last.get(0) > nextnext.get(0) <){}*/
            }
            i = next.get(0);
        }
        return result;
    }
}

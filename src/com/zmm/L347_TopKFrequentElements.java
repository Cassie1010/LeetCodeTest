package com.zmm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 347. 前 K 个高频元素
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 *
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *
 *
 * 提示：
 *
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
 * 你可以按任意顺序返回答案。
 * @author: zmm
 * @time: 2020/9/7 11:03
 */
public class L347_TopKFrequentElements {
    public static void main(String[] args) {
        System.out.println(new L347_TopKFrequentElements().topKFrequent(new int[]{1,1,2,2,2,3,1}, 2));
    }

    //使用快速排序
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> occurrences = new HashMap<Integer, Integer>();
        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }

        List<int[]> values = new ArrayList<int[]>();
        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            values.add(new int[]{num, count});
        }
        int[] ret = new int[k];
        qsort(values, 0, values.size() - 1, ret, 0, k);
        return ret;
    }

    //快速排序
    public void qsort(List<int[]> values, int start, int end, int[] ret, int retIndex, int k) {
        //Math.random() 0-1之间的小数 * 长度 + 开始下标
        int picked = (int) (Math.random() * (end - start + 1)) + start;
        //values.set(picked, values.set(start, values.get(picked))) values.set return OldValue
        Collections.swap(values, picked, start);

        int pivot = values.get(start)[1];//count
        int index = start;
        for (int i = start + 1; i <= end; i++) {
            if (values.get(i)[1] >= pivot) {
                Collections.swap(values, index + 1, i);
                index++;
            }
        }
        Collections.swap(values, start, index);

        if (k <= index - start) {
            qsort(values, start, index - 1, ret, retIndex, k);
        } else {
            for (int i = start; i <= index; i++) {
                ret[retIndex++] = values.get(i)[0];
            }
            if (k > index - start + 1) {
                qsort(values, index + 1, end, ret, retIndex, k - (index - start + 1));
            }
        }
    }

    //使用队列(堆)
    public int[] topKFrequent2(int[] nums, int k) {
        int[] kArrays = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i ++){
            int temp = nums[i];
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }
        //队列 int[2] 0:表示值 1:表示次数
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                return t1[1] - ints[1];
            }
        });
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            int key = entry.getKey(), count = entry.getValue();
            if(queue.size() == k){
                if(queue.peek()[1]<count){
                    queue.poll();
                    queue.offer(new int[]{key, count});
                }
            }else{
                queue.offer(new int[]{key, count});
            }
        }
        for(int i = k - 1; i >= 0; i--){
            kArrays[i] = queue.poll()[0];
        }
        return kArrays;
    }

    public int[] topKFrequent1(int[] nums, int k) {
        int[] kArrays = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i ++){
            int temp = nums[i];
            if(map.containsKey(temp)){
                map.put(temp, map.get(temp)+1);
            }else{
                map.put(temp, 1);
            }
        }
        for(int i = 0; i < kArrays.length; i++){
            Set<Integer> keys = map.keySet();
            int MaxReKey = 0;
            int MaxReValue = 0;
            Iterator<Integer> ite = keys.iterator();
            while (ite.hasNext()){
                int temp = ite.next();
                if(map.get(temp) > MaxReValue){
                    MaxReKey = temp;
                    MaxReValue = map.get(temp);
                }
            }
            kArrays[i] = MaxReKey;
            map.remove(MaxReKey);
        }
        return kArrays;
    }
}

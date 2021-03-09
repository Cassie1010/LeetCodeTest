package com.zmm.interview;


import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author: zmm
 * @time: 2020/10/29 18:50
 */
public class zhongxin_004_快速排序第n趟结果 {
    public static void main(String[] args) {
        new zhongxin_004_快速排序第n趟结果().test();
    }
    public void test(){
//        int[] array = {42,35,63,96,56,11,17,42,88};
//        int[] res = nthResultOfQuickSort(array, 3);
        int[] arra = quickSort(new int[]{3,8,5,7,6}, 0, 4);

        System.out.println(Arrays.toString(arra));
    }

    public int[] nthResultOfQuickSort (int[] array, int n) {
        // write code here
        //存放下标，0开始 1结束
        LinkedList<int[]> list = new LinkedList();
        list.add(new int[]{0, array.length - 1});
        list.add(new int[0]);
        while (!list.isEmpty() && n > 0){
            int[] index = list.pollFirst();
            if(index.length == 0){
                n--;
                System.out.println("n="+n+ "----"+Arrays.toString(array));
                continue;
            }
            int i = index[0], j = index[1];
            int x = array[i];
            while (i < j){
                while(j > i && array[j] >= x)
                    j--;
                if(j > i){
                    array[i] = array[j];
                    i++;
                }
                while (i < j && array[i] <= x)
                    i++;
                if(i < j){
                    array[j] = array[i];
                    j++;
                }
            }
            array[i] = x;
            if(i-1 > index[0])
                list.add(new int[]{index[0], i-1});
            if(i+1 < index[1])
                list.add(new int[]{i+1, index[1]});
            list.add(new int[0]);
        }
        //快速排序+递归
//        nthResultOfQuickSort(0, array.length - 1, array, n);
        return array;
    }

    //快速排序+递归
    public int nthResultOfQuickSort(int start, int end, int[] array, int n){
        if(n <= 0)
            return n;
        int i = start, j = end;
        int x = array[i];
        while (i < j){
            while (i < j && x <= array[j])
                j--;
            if(i < j){
                array[i] = array[j];
                i ++;
            }
            while (i < j && array[i] <= x)
                i ++;
            if(i < j){
                array[j] = array[i];
                j--;
            }
        }
        array[i] = x;
        System.out.println(Arrays.toString(array));
        if(i-1 > start)
            n = nthResultOfQuickSort(start, i - 1, array, -- n);
        if(end > i+1)
            n = nthResultOfQuickSort(i + 1, end, array, -- n);
        return n;
    }

    public int[] quickSort(int[] nums, int l, int r) {
        int mid = r;
        for (int i = r; i >= l; i--) {
            if (nums[i] > nums[l]) {
                nums[i] = swap(nums[mid], nums[mid] = nums[i]);	//交换i和mid
                mid--;
            }
        }
        nums[l] = swap(nums[mid], nums[mid] = nums[l]);	//交换mid和标兵
        //递归左右
        if (mid > l + 1) quickSort(nums, l, mid - 1);
        if (mid < r - 1) quickSort(nums, mid + 1, r);
        return nums;
    }

    public static int swap(int a, int b){
        return a;
    }

}

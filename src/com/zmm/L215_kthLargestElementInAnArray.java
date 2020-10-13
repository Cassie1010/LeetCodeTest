package com.zmm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

/**
 * 215. 数组中的第K个最大元素
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 *
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 * @author: zmm
 * @time: 2020/10/10 17:31
 */
public class L215_kthLargestElementInAnArray {
    public static void main(String[] args) {
        System.out.println(new L215_kthLargestElementInAnArray().findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println(new L215_kthLargestElementInAnArray().findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
        System.out.println(new L215_kthLargestElementInAnArray().findKthLargest(new int[]{1}, 1));
        System.out.println(new L215_kthLargestElementInAnArray().findKthLargest(new int[]{3,2}, 2));
    }

    //基于堆排序的选择方法（堆是一颗完全二叉树）
    /**
     * 思路和算法
     *
     * 我们也可以使用堆排序来解决这个问题——建立一个大根堆，做 k−1 次删除操作后堆顶元素就是我们要找的答案。
     * 在很多语言中，都有优先队列或者堆的的容器可以直接使用，但是在面试中，面试官更倾向于让更面试者自己实现一个堆。
     * 所以建议读者掌握这里大根堆的实现方法，在这道题中尤其要搞懂「建堆」、「调整」和「删除」的过程。
     */
    public int findKthLargest(int[] nums, int k) {
        int heapSize = nums.length;//堆 size
        buildMaxHeap(nums, heapSize);//建堆
        for (int i = nums.length - 1; i >= nums.length - k + 1; --i) {
            swap(nums, 0, i);
            --heapSize;
            maxHeapify(nums, 0, heapSize);
        }
        return nums[0];
    }
    /** 建堆 */
    public void buildMaxHeap(int[] a, int heapSize) {
        for (int i = heapSize / 2; i >= 0; --i) {
            maxHeapify(a, i, heapSize);
        }
    }
    /** 调整 */
    public void maxHeapify(int[] a, int i, int heapSize) {
        int l = i * 2 + 1, r = i * 2 + 2, largest = i;
        if (l < heapSize && a[l] > a[largest]) {
            largest = l;
        }
        if (r < heapSize && a[r] > a[largest]) {
            largest = r;
        }
        if (largest != i) {
            swap(a, i, largest);
            maxHeapify(a, largest, heapSize);
        }
    }

    public int findKthLargest2(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }


    //快速排序(典型的分治算法)
    /**
     * 我们对数组 a[l⋯r] 做快速排序的过程是（参考《算法导论》）：
     *
     * 分解： 将数组 a[l⋯r] 「划分」成两个子数组 a[l⋯q−1]、a[q+1⋯r]，使得 a[l⋯q−1] 中的每个元素小于等于 a[q]，且 a[q] 小于等于 a[q+1⋯r] 中的每个元素。其中，计算下标 q 也是「划分」过程的一部分。
     * 解决： 通过递归调用快速排序，对子数组 a[l⋯q−1] 和 a[q+1⋯r] 进行排序。
     * 合并： 因为子数组都是原址排序的，所以不需要进行合并操作，a[l⋯r] 已经有序。
     * 上文中提到的 「划分」 过程是：从子数组 a[l⋯r] 中选择任意一个元素 x 作为主元，调整子数组的元素使得左边的元素都小于等于它，右边的元素都大于等于它， x 的最终位置就是 q。
     */
    public int quickSelect(int[] a, int l, int r, int index) {
        int q = randomPartition(a, l, r);
        if (q == index) {
            return a[q];
        } else {
            return q < index ? quickSelect(a, q + 1, r, index) : quickSelect(a, l, q - 1, index);
        }
    }

    Random random = new Random();
    public int randomPartition(int[] a, int l, int r) {
        int i = random.nextInt(r - l + 1) + l;
        swap(a, i, r);
        return partition(a, l, r);//分割
    }

    public int partition(int[] a, int l, int r) {
        int x = a[r], i = l - 1;
        for (int j = l; j < r; ++j) {
            if (a[j] <= x) {
                swap(a, ++i, j);
            }
        }
        swap(a, i + 1, r);
        return i + 1;
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    //冒泡排序
    private int findKthLargest1(int[] nums, int k){
        int result = 0;
        //冒泡排序
        for(int i = 0; i < k; i++){
            for(int j = 0; j < nums.length - i; j++){
                int temp = nums[j];
                if(j < nums.length - 1 && nums[j] > nums[j + 1]){
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
                result = temp;
            }
        }
        return result;
    }

}

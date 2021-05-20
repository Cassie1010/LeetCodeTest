package com.zmm;

import java.util.Arrays;

/**
 * 4. 寻找两个正序数组的中位数
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 *
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * 示例 3：
 *
 * 输入：nums1 = [0,0], nums2 = [0,0]
 * 输出：0.00000
 * 示例 4：
 *
 * 输入：nums1 = [], nums2 = [1]
 * 输出：1.00000
 * 示例 5：
 *
 * 输入：nums1 = [2], nums2 = []
 * 输出：2.00000
 *
 *
 * 提示：
 *
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 *
 *
 * 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
 */
public class L4_MedianOfTwoArraysTest {
	public static void main(String[] args) {
		int[] nums1 = {1, 3};
		int[] nums2 = {};
		new L4_MedianOfTwoArraysTest().findMedianSortedArrays(nums1, nums2);
	}
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if(nums1.length > nums2.length){
			return findMedianSortedArrays(nums2, nums1);
		}
		int length = nums1.length + nums2.length;
		if(length == 0){
			return 0;
		}
		int mid = length / 2;
		int[] ints = new int[length];
		ints[mid] = nums2[0];
		int left = 0;
		int right = mid + 1;
		for(int i = 0; i < nums1.length; i++){
			if(i == mid){

			}else{

			}
		}
		for(int i = 1; i < nums2.length; i++){

		}
		double res = 0d;
		return res;
	}

	public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
		int m = nums1.length;
		int n = nums2.length;
		int length = m + n;
		int[] arrays = new int[length]; 
		for(int i = 0; i < m; i ++) {
			arrays[i] = nums1[i];
		}
		for(int i = 0; i < n; i ++) {
			arrays[m + i] = nums2[i];
		}
		Arrays.sort(arrays);
		boolean b = length%2 == 0;
		int me = length/2;
		int num1 = arrays[me];
		double result = b ? ((double)num1+arrays[me-1])/2 : num1;
        return result;
    }
	
}

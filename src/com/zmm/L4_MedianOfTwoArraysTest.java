package com.zmm;

import java.util.Arrays;

public class L4_MedianOfTwoArraysTest {
	public static void main(String[] args) {
		int[] nums1 = {1, 3};
		int[] nums2 = {};
		new L4_MedianOfTwoArraysTest().findMedianSortedArrays(nums1, nums2);
	}
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
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

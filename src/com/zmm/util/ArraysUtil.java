package com.zmm.util;

import java.util.Scanner;

/**
 * @author: zmm
 * @time: 2021/3/11 10:00
 */
public class ArraysUtil {

    /*

    1
    4 4
    .##.
    #@.#
    #*.*
    .#.#

     */

    private static int res = Integer.MAX_VALUE;
    private static boolean flag = false;

    public static int[] getIntArrays() {
        System.out.println("参考格式：1,2,3,4,5");
        Scanner sc = new Scanner(System.in);
        String[] temp = sc.nextLine().split(",");
        int len = temp.length;
        int[] ret = new int[len];
        for(int i = 0; i<len; i++){
            ret[i] = Integer.valueOf(temp[i]);
        }
        return ret;
    }
    public static char[][] getArrays() {
        Scanner sc = new Scanner(System.in);
        int group = sc.nextInt();
        sc.nextLine();
        char[][] matrix = new char[][]{};
        for (int i = 0; i < group; i++) {
            //每一组
            flag = false;
            res = Integer.MAX_VALUE;
            String[] temp = sc.nextLine().split(" ");
            int n = Integer.parseInt(temp[0]);
            int m = Integer.parseInt(temp[1]);
            int x = 0, y = 0;   //初始位置
            matrix = new char[n][m];
            for (int j = 0; j < n; j++) {
                matrix[j] = sc.nextLine().toCharArray();
                for (int k = 0; k < matrix[j].length; k++) {
                    if (matrix[j][k] == '@'){
                        x = j;
                        y = k;
                    }
                }
            }
        }
        return matrix;
    }

}

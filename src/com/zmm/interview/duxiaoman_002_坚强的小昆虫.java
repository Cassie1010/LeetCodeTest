package com.zmm.interview;

import java.util.Scanner;

/**
 * @author wjw
 * @date 2020/9/20 20:38
 */
public class duxiaoman_002_坚强的小昆虫 {

    private static int res = Integer.MAX_VALUE;
    private static boolean flag = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int group = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < group; i++) {   //每一组
            flag = false;
            res = Integer.MAX_VALUE;
            String[] temp = sc.nextLine().split(" ");
            int n = Integer.parseInt(temp[0]);
            int m = Integer.parseInt(temp[1]);
            int x = 0, y = 0;   //初始位置
            char[][] matrix = new char[n][m];
            for (int j = 0; j < n; j++) {
                matrix[j] = sc.nextLine().toCharArray();
                for (int k = 0; k < matrix[j].length; k++) {
                    if (matrix[j][k] == '@'){
                        x = j;
                        y = k;
                    }
                }
            }
            //处理完输入，进入正式逻辑
            backtrace(matrix, x, y, 0);
            if (!flag) {
                res = -1;
            }
            System.out.println(res);
        }
    }

    /**
     * 回溯
     * @param matrix
     */
    public static void backtrace(char[][] matrix, int x, int y, int num){
        if (matrix[x][y] == '#') {
            return;
        }
        if (matrix[x][y] == '*') {
            num++;
        }
        //结束条件
        if (x == 0 || y == 0 || x == matrix.length - 1 || y == matrix[0].length - 1){
            res = Math.min(res, num);
            flag = true;
            return ;
        }
        //四次枚举代替for循环
        matrix[x][y] = '#'; //不走回头路！
        backtrace(matrix, x - 1, y, num);   //上
        backtrace(matrix, x, y - 1, num);   //左
        backtrace(matrix, x + 1, y, num);   //下
        backtrace(matrix, x, y + 1, num);   //右
    }
}

/*

1
4 4
.##.
#@.#
#*.*
.#.#

 */
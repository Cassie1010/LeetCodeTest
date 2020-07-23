package com.zmm.gitee;

import java.util.HashMap;
import java.util.Map;

/**
 * 我们需要在与密函类似二维坐标轴的零件中，从（0,0）走到（2013,2020）找到最短路径才可破解,
 * 每次只能从东西南北选择一个方向行进（EWSN），并且可以走到负数坐标。
 * 第 i 步走的长度必须是 2^(i-1) ，例如，第一步走1格，第二步走2格，第三步走4格以此类推
 * （注：答案只包含EWSN四种大写字母）
 */
public class Test5 {

    static int x = 2013,y = 2020;
    static Map<Integer, String> map = new HashMap<>();

    static Integer minStep = null;

    public static void main(String[] args) {
    }

    public static int getStepCount(int step){
        int stepCount = 1;
        for(int i = 1; i < step; i++){
            stepCount *= 2;
        }
        return stepCount;
    }

}

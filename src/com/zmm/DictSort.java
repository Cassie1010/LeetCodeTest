package com.zmm;

import java.util.*;

public class DictSort {
    public static void main(String[] args) {
        Object[] result = new DictSort().sort(new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"}
            , 1000000);
        Arrays.stream(result).forEach(System.out::print);
    }
    private String[] sort(String[] oriArray, int number){
        Map<Integer, Integer> map = new HashMap<>();
        Integer temp = 1;
        int length = oriArray.length;
        for(int i = 1; i <= length; i++){
            temp *= i;
            map.put(i, temp);
        }
        String[] result = new String[length];
        System.arraycopy(oriArray, 0, result, 0, length);
        int divisible = 0;//整除
        int remainder = number - 1;//取余
        String tempA = null;
        for(int i = 0; i < length; i++){
            temp = map.get(length - i - 1);
            if(temp == null) break;
            divisible = remainder / temp;
            remainder = remainder % temp;
            if(divisible > 0){
                tempA = result[i + divisible];
                System.arraycopy(result, i, result, i + 1, divisible);
                result[i] = tempA;
            }
            if(remainder == 0){
                break;
            }
        }
        return result;
    }
}

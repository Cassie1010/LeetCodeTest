package com.zmm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class L60_PermutationSequence {
    public static void main(String[] args) {
        String result = new L60_PermutationSequence().sort(4, 9);
        System.out.println(result);
    }
    private String sort(int n, int k){
        Map<Integer, Integer> map = new HashMap<>();
        Integer temp = 1;
        int[] result = new int[n];
        for(int i = 1; i <= n; i++){
            result[i-1] = i;
            temp *= i;
            map.put(i, temp);
        }
        int divisible = 0;//整除
        int remainder = k - 1;//取余
        int tempValue = 0;
        for(int i = 0; i < n; i++){
            temp = map.get(n - i - 1);
            if(temp == null) break;
            divisible = remainder / temp;
            remainder = remainder % temp;
            if(divisible > 0){
                tempValue = result[i + divisible];
                System.arraycopy(result, i, result, i + 1, divisible);
                result[i] = tempValue;
            }
            if(remainder == 0){
                break;
            }
        }
        StringBuffer sb = new StringBuffer();
        Arrays.stream(result).forEach(i ->{
            sb.append(i);
        });
        return sb.toString();
    }
}

package com.zmm;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class L12_IntegerToRoman {
    public static void main(String[] args) {
        System.out.println(new L12_IntegerToRoman().intToRoman(144));
    }
    public String intToRoman(int num) {
        String result = "";
        Map<Integer, String> intToString = new LinkedHashMap<>();
        intToString.put(1000, "M");
        intToString.put(900, "CM");
        intToString.put(500, "D");
        intToString.put(400, "CD");
        intToString.put(100, "C");
        intToString.put(90, "XC");
        intToString.put(50, "L");
        intToString.put(40, "XL");
        intToString.put(10, "X");
        intToString.put(9, "IX");
        intToString.put(5, "V");
        intToString.put(4, "IV");
        intToString.put(1, "I");
        Iterator<Map.Entry<Integer, String>> ite = intToString.entrySet().iterator();
        Map.Entry<Integer, String> entry = null;
        int count = 0;
        while (ite.hasNext()){
            entry = ite.next();
            count = num/entry.getKey();
            num = num%entry.getKey();
            while(count > 0){
                result += entry.getValue();
                count --;
            }
        }
        return result;
    }
}

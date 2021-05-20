package com.zmm.interview;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * 旋转输出
 * @author: zmm
 * @time: 2021/5/20 19:13
 */
public class RotaryOutput {

    public static void main(String[] args) {
        List<Object> result = traverse(new Object[][] {
                        {'1' , '2' , '3' , '4' , '5' }
                        , {'e' , 'f' , 'g' , 'h' , '6' }
                        , {'d' , 'k' , 'j' , 'i' , '7' }
                        , {'c' , 'b' , 'a' , '9' , '8' }});
        System.out.println(JSON.toJSONString(result));
    }

    public static List<Object> traverse(Object[][] obj){
        List<Object> result = new ArrayList<>();
        int minx = 0;
        int miny = 0;
        int maxx = obj[0].length - 1;
        int maxy = obj.length - 1;
        int x = 0;
        int y = 0;
        while(maxx > minx){
            x = xInc(x, y, maxx, obj, result);
            miny++;
            y++;
            y = yInc(x, y, maxy, obj, result);
            maxx--;
            x--;
            x = xDec(x, y, minx, obj, result);
            maxy--;
            y--;
            y = yDec(x, y, miny, obj, result);
            minx++;
            x++;
        }

        return result;
    }

    public static int xInc(int x , int y, int maxx, Object[][] obj, List<Object> result){
        while (x <= maxx){
            result.add(obj[y][x]);
            x++;
        }
        return maxx;
    }
    public static int xDec(int x , int y, int minx, Object[][] obj, List<Object> result){
        while (x >= minx){
            result.add(obj[y][x]);
            x--;
        }
        return minx;
    }

    public static int yInc(int x , int y, int maxy, Object[][] obj, List<Object> result){
        while (y <= maxy){
            result.add(obj[y][x]);
            y++;
        }
        return maxy;
    }
    public static int yDec(int x , int y, int miny, Object[][] obj, List<Object> result){
        while (x >= miny){
            result.add(obj[y][x]);
            y--;
        }
        return miny;
    }

}

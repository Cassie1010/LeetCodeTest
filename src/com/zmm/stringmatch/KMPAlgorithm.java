package com.zmm.stringmatch;

/**
 * @author: zmm
 * @time: 2021/6/9 15:35
 */
public class KMPAlgorithm {

    public static void main(String[] args) {
        String s = "askddhrsdhdfdhrsdhslk";
        String p = "dhrsdhs";
        System.out.println(getIndex(s, p));
    }

    public static int getIndex(String s, String p){
        int[] next = getNext(p);
        int index = -1;
        int x = 0;
        int y = 0;
        while (x + y < s.length()){
            if(s.charAt(x + y) == p.charAt(y)){
                y ++;
                if(y == p.length()){
                    index = x;
                    break;
                }
            }else if(y > 0 && next[y-1] > 0){
                x = x + y - next[y-1];
                y = 0;
            }else {
                x ++;
                y = 0;
            }
        }
        return index;
    }

    public static int[] getNext(String p){
        char[] pc = p.toCharArray();
        int length = pc.length;
        int[] next = new int[length];
        int x = 1;
        int y = 0;
        while (x < length){
            if(pc[y] == pc[x]){
                next[x] = next[x-1] + 1;
                y ++;
            }else{
                y=0;
            }
            x ++;
        }
        return next;
    }

}

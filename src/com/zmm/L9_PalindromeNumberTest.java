package com.zmm;

public class L9_PalindromeNumberTest {
    public static void main(String[] args) {
        System.out.println(new L9_PalindromeNumberTest().isPalindrome(32));
    }
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        if(x < 10){
            return true;
        }
        String data =  String.valueOf(x);
        int length = data.length();
        int middle = length / 2;
        Character c = null;
        for(int i = 0; i < middle; i++){
            c = data.charAt(i);
            if(!c.equals(data.charAt(length - i - 1))){
                return false;
            }
        }
        return true;
    }
}

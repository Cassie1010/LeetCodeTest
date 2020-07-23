package com.zmm;

public class L7_ReverseIntegerTest {
	public static void main(String[] args) {
		System.out.println(new L7_ReverseIntegerTest().reverse(1534236469));
	}
	public int reverse(int x) {
		boolean isNegative = false;
		if(x < 0) isNegative = true;
		x = Math.abs(x);
		String temp = String.valueOf(x);
		StringBuilder sb = new StringBuilder();
		for(int i = 0, length = temp.length(); i< length; i++) {
			sb.append(temp.charAt(i));
		}
		try {
			x = Integer.parseInt(sb.reverse().toString());
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return 0;
		}
		if(isNegative)
			x = -x;
        return x;
    }
}

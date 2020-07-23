package com.zmm;

public class L8_StringToIntegerAtoiTest {
	public static void main(String[] args) {
		System.out.println(new L8_StringToIntegerAtoiTest().myAtoi(" -    283 475 8 "));
	}
	public int myAtoi(String str) {
		if(null == str) {
			return 0;
		}
		int result = 0;
		String s = str;
		boolean isStart = true;
		Character ch = null;
		for(int i = 0, length = str.length(); i < length; i++) {
			ch = str.charAt(i);
			if(!Character.isDigit(ch)) {
				if(!isStart) {
					s = str.substring(0, i);
					break;
				}else {
					if(!Character.isSpaceChar(ch) && !ch.equals('+') && !ch.equals('-')) {
						s = null;
						break;
					}else if(!Character.isSpaceChar(ch)){
						isStart = false;
					}
				}
			}else {
				isStart = false;
			}
		}
		if(s != null) {
			s = s.replaceAll(" ", "");
			try {
				result = Integer.parseInt(String.valueOf(s));
			} catch (NumberFormatException e) {
				return  s.length() < 2 ? 0 : s.startsWith("-") ? (int)Math.pow(-2, 31) : (int)Math.pow(2, 31);
			}
		}
        return result;
    }
}

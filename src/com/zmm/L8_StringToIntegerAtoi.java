package com.zmm;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class L8_StringToIntegerAtoi {
	public static void main(String[] args) {
		System.out.println(new L8_StringToIntegerAtoi().myAtoi("-34588888888888888888888ji793"));
	}
	public int myAtoi(String str) {
		if(null == str || "".equals("str")) {
			return 0;
		}
		str = str.replaceAll(" ", "");
		Pattern p = Pattern.compile("^[+-]{0,1}\\d*");
		Matcher m = p.matcher(str);
		String s = null;
		boolean f = false;
		if(m.lookingAt()) {
			s = m.group(0);
			Pattern p1 = Pattern.compile("^[-]");
			Matcher m1 = p1.matcher(s);
			if(m1.lookingAt()) {
				f = true;
			}
		}
		int result = 0;
		if(s != null) {
			try {
				result = Integer.parseInt(String.valueOf(s));
			} catch (NumberFormatException e) {
				return  f ? (int)Math.pow(-2, 31) : (int)Math.pow(2, 31);
			}
		}
        return result;
    }
}

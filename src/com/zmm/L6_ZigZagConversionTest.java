package com.zmm;

public class L6_ZigZagConversionTest {
	public static void main(String[] args) {
		System.out.println(new L6_ZigZagConversionTest().convert("PAYPALISHIRING", 3));
	}
	public String convert(String s, int numRows) {
        if(s == null || "".equals(s) || numRows == 1) {
        	return s;
        }
        int length = s.length();
        int a = length%(2*numRows - 2);
        int numLengths = length/(2*numRows - 2)*(numRows-1);
        if(a > 0) {
        	numLengths ++;
        	numLengths += (a>numRows) ? a-numRows : 0;
        }
        Character[][] array = new Character[numRows][numLengths];
        int nl = 0;
        int il = a>0 ? length/(2*numRows - 2) + 1 : length/(2*numRows - 2);
        int index = 0;
        for(int i = 0; i < il; i ++){
        	int nr = 0;
        	for(int j = 0; j < (2*numRows - 2); j++) {
        		array[nr][nl] = s.charAt(index ++);
        		if(index >= length) {
        			break;
        		}
        		if(j + 1 >= numRows) {
        			nr--;nl++;
        		}else {
        			nr++;
        		}
        		
        	}
        }
        StringBuilder result = new StringBuilder();
        Character temp;
        for(int i = 0; i < numRows; i++) {
        	System.out.println();
        	for(int j = 0; j < numLengths; j++) {
        		temp = array[i][j];
        		System.out.print(temp == null? "* ":temp+" ");
        		if(temp != null) {
        			result.append(temp);
        		}
        	}
        }
        System.out.println();
        return result.toString();
    }
}

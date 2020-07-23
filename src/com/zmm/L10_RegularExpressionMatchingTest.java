package com.zmm;

import java.util.ArrayList;
import java.util.List;

public class L10_RegularExpressionMatchingTest {
	public static void main(String[] args) {
		System.out.println(new L10_RegularExpressionMatchingTest().isMatch("aaaaaaaaaaaaab",
				"a*a*a*a*a*a*a*a*a*a*a*a*b"));
		//System.out.println(new L10_RegularExpressionMatchingTest().isMatch("",".*"));
	}
	
	/**
	 * @author mengmeng_zuo
	 * @param s could be empty and contains only lowercase letters a-z.
	 * @param p could be empty and contains only lowercase letters a-z, and characters like . or *.
	 * '.' Matches any single character. '*' Matches zero or more of the preceding element.
	 * @return
	 */
	public boolean isMatch(String s, String p) {
		boolean isMatch = false;
		if(null == s || null == p) {
			return isMatch;
		}
		List<String> pList = new ArrayList<>();
		boolean isContinue = false;
		char[] chars = p.toCharArray();
		String c = null;
		for(int i = 0; i < chars.length ; i++){
			c = String.valueOf(chars[i]);
			if(isContinue){
				pList.set(pList.size()-1, pList.get(pList.size() -1) + c);
			}else{
				pList.add(c);
			}
			if(chars.length > i + 1 && "*".equals(String.valueOf(chars[i+1]))){
				isContinue = true;
			}else{
				isContinue = false;
			}
		}
		List<String> result = new ArrayList<>();
		result.add(s);
		List<String> temp = null;
		String tempStar = null;
		String tempR = null;
		boolean isContainStar = false;
		for(String str : pList){
			if(result.isEmpty()){
				break;
			}
			temp = new ArrayList<>();
			isContainStar = false;
			if(str.equals("*")){
				continue;
			}else if(str.endsWith("*")){
				isContainStar = true;
				str = str.substring(0, str.indexOf("*"));
			}
			for(String r : result){
				tempStar = null;
				if(isContainStar){
					temp.add(r);
				}
				if(str.equals(".") || r.startsWith(str)){
					if(r.length() > 0){
						tempStar = str;
						tempR = r.substring(str.length());
						if(!temp.contains(tempR)){
							temp.add(tempR);
						}
					}
				}
				if(isContainStar && tempStar != null){
					tempR = temp.get(temp.size() - 1);
					while (true){
						if(tempR.length()>0 && (".".equals(tempStar) || tempR.startsWith(tempStar))){
							if(tempStar.length() >= tempR.length()){
								tempR = "";
							}else{
								tempR = tempR.substring(tempStar.length());
							}
							if(!temp.contains(tempR)){
								temp.add(tempR);
							}
						}else{
							break;
						}
					}
				}
			}
			result = temp;
		}
		if(!result.isEmpty()){
			for(String r:result){
				if("".equals(r)){
					isMatch = true;
					break;
				}
			}
		}
		return isMatch;
    }
}

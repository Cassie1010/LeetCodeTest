package com.zmm.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 * @author: zmm
 * @time: 2020/8/3 17:12
 */
public class L20_ValidParentheses {
    public static void main(String[] args) {
        System.out.println(new L20_ValidParentheses().isValid("[{}]"));
    }
    public boolean isValid(String s) {
        boolean isValid = false;
        if(s == null)
            return isValid;
        char[] cs = s.toCharArray();
        Map<Character, Character> list = new HashMap<>();
        list.put('(',')');
        list.put('{','}');
        list.put('[',']');
        Stack stack = new Stack();
        for(char c : cs){
            if(list.containsKey(c)){
                stack.push(c);
            }else if(stack.isEmpty() || c != list.get(stack.pop())){
                return false;
            }
        }
        if(stack.isEmpty()){
            isValid = true;
        }
        return isValid;
    }
}

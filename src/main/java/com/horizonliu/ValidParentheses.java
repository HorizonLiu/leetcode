package com.horizonliu;

import java.util.Stack;

/**
 * @author horizonliu
 * @date 2020/3/11 7:59 下午
 */
public class ValidParentheses {
    public static void main(String[] args) {
        String input = "([)]";
        System.out.println("isValidParentheses : " + isValidParentheses(input));
    }

    public static boolean isValidParentheses(String arg) {
        // 空字符串恒为true
        if (arg == null || arg.isEmpty()) {
            return true;
        }

        // 字符串长度为奇数
        if (arg.length() % 2 != 0) {
            return false;
        }

        // 用栈来解决
        // 当栈为空时:push；当栈顶元素和当前元素是一对时:pop
        Stack<Character> stack = new Stack<>();
        for (int index = 0; index < arg.length(); ++index) {
            char tmp = arg.charAt(index);
            if (stack.isEmpty()) {
                stack.push(tmp);
                continue;
            }
            char peek = stack.peek();
            if (peek == '(' && tmp == ')'
                    || peek == '{' && tmp == '}'
                    || peek == '[' && tmp == ']') {
                stack.pop();
            } else {
                stack.push(tmp);
            }
        }
        return stack.isEmpty();
    }
}

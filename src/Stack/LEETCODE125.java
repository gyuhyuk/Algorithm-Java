package Stack;

import java.util.Stack;

public class LEETCODE125 {
    public boolean isPalindrome(String s) {
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()) {
            if(Character.isLetterOrDigit(c)) {
                stack.push(Character.toLowerCase(c));
            }
        }

        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                char top = stack.pop(); // 스택에서 문자 꺼내기
                if (Character.toLowerCase(c) != top) {
                    return false; // 문자가 다르면 팰린드롬 아님
                }
            }
        }

        return true;
    }
}

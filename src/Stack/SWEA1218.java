package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SWEA1218 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int t=1; t<=10; t++) {
            int answer = 0;

            N = Integer.parseInt(br.readLine());
            String s = br.readLine();

            if(isValid(s)) {
                answer = 1;
            }

            System.out.println("#" + t + " " + answer);
        }
    }

    static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<N; i++) {
            char temp = s.charAt(i);

            if(temp == '(' || temp == '{' || temp == '[' || temp == '<') {
                stack.push(temp);
            }
            else if (temp == ')' || temp == '}' || temp == ']' || temp == '>') {
                if(stack.isEmpty()) {
                    return false;
                }

                char open = stack.pop();

                // 괄호 쌍이 맞는지 확인
                if ((open == '(' && temp != ')') ||
                        (open == '{' && temp != '}') ||
                        (open == '[' && temp != ']') ||
                        (open == '<' && temp != '>')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}

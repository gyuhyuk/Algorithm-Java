package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            Stack<Character> stack = new Stack<>();
            String s = br.readLine();
            boolean isVPS = true;

            for(char c : s.toCharArray()) {
                if(c == '(') {
                    stack.push(c);
                } else {
                    if(stack.isEmpty()) {
                        isVPS = false;
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
            if(!stack.isEmpty()) {
                isVPS = false;
            }

            System.out.println(isVPS ? "YES" : "NO");
        }
    }
}

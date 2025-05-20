package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SWEA8931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            Stack<Integer> stack = new Stack<>();

            int K = Integer.parseInt(br.readLine());
            int sum = 0;

            for(int i=0; i<K; i++) {
                int num = Integer.parseInt(br.readLine());

                if(num != 0) {
                    stack.push(num);
                } else {
                    stack.pop();
                }
            }

            int temp = stack.size();

            for(int i=0; i<temp; i++) {
                sum += stack.pop();
            }

            System.out.println("#" + t + " " + sum);
        }
    }
}

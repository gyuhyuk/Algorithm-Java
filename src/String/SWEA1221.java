package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA1221 {
    static final String[] numStr = {"ZRO", "ONE", "TWO", "THR", "FOR",
            "FIV", "SIX", "SVN", "EGT", "NIN"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++) {
            String[] temp = br.readLine().split(" ");
            int len = Integer.parseInt(temp[1]);

            int[] count = new int[10]; // 0 ~ 9 숫자별 개수 저장

            String[] input = br.readLine().split(" ");
            for(String s : input) {
                for(int i = 0; i < 10; i++) {
                    if(s.equals(numStr[i])) {
                        count[i]++;
                        break;
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            sb.append(temp[0]).append("\n"); // #t 형식 그대로 출력

            for(int i = 0; i < 10; i++) {
                for(int j = 0; j < count[i]; j++) {
                    sb.append(numStr[i]).append(" ");
                }
            }

            System.out.println(sb);
        }
    }
}

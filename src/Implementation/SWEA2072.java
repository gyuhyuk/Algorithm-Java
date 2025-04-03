package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA2072 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine()); // BufferedReader 사용

        for (int test_case = 1; test_case <= T; test_case++) {
            int result = 0;
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < 10; i++) {
                int n = Integer.parseInt(st.nextToken());
                if (n % 2 != 0) {
                    result += n;
                }
            }
            System.out.println("#" + test_case + " " + result);
        }
    }
}

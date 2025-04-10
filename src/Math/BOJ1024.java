package Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ1024 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        // L부터 100까지 가능한 길이에 대해 탐색
        for (int len = L; len <= 100; len++) {
            // 수열의 합 공식 (n * (2*a + (n-1) * d)) / 2
            int temp = N - (len * (len - 1)) / 2; // temp가 위 식에서 a (첫 항)

            if (temp < 0) break; // a가 음수가 되면 더 이상 확인할 필요 없음

            if (temp % len == 0) {
                int a = temp / len;

                for (int i = 0; i < len; i++) {
                    System.out.print((a + i) + " ");
                }
                System.out.println();
                return;
            }
        }

        // 조건을 만족하는 수열이 없는 경우
        System.out.println("-1");
    }
}

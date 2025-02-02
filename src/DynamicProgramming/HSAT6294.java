package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HSAT6294 {
        static long[] arr;
        static long[] dp;
        static int N, K;
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            StringBuilder sb = new StringBuilder();

            N = Integer.parseInt(st.nextToken()); // N
            K = Integer.parseInt(st.nextToken()); // K

            arr = new long[1000001]; // arr 배열
            dp = new long[1000001]; // dp 배열

            st = new StringTokenizer(br.readLine()); // st 초기화

            for(int i=1; i<=N; i++) {
                arr[i] = Long.parseLong(st.nextToken());
            }

            dp[0] = 0;
            dp[1] = arr[1];
            for(int i=2; i<=N; i++) {
                dp[i] = dp[i-1] + arr[i]; // dp 배열 만들었음
            }

            for(int i=0; i<K; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken()); // 시작점
                int end = Integer.parseInt(st.nextToken()); // 끝점

                int len = end-start+1; // 구간 길이

                long result = dp[end]-dp[start-1];
                sb.append(String.format("%.2f%n", (double) result / len));
            }

            System.out.println(sb);
        }
}

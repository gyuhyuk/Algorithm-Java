package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ13270 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int a = 1;
        int b = 2;

        int[] min = new int[N+1];
        int[] max = new int[N+1];

        for(int i=1; i<=N; i++) {
            min[i] = 987654321;
        }

        while (b <= N) {
            for(int i=b; i<=N; i++) {
                min[i] = Math.min(min[i], min[i-b] + a);
                max[i] = Math.max(max[i], max[i-b] + a);
            }

            int temp = b;
            b += a;
            a = temp;
        }

        System.out.println(min[N] + " " + max[N]);
    }
}

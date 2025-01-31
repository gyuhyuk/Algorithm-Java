package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1003 {
    static long[] zeroFib;
    static long[] oneFib;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());

        zeroFib = new long[41];
        oneFib = new long[41];

        zeroFib[0] = 1;
        zeroFib[1] = 0;
        zeroFib[2] = 1;
        oneFib[0] = 0;
        oneFib[1] = 1;
        oneFib[2] = 1;


        for(int i=3; i<=40; i++) {
            zeroFib[i] = zeroFib[i-1] + zeroFib[i-2];
            oneFib[i] = oneFib[i-1] + oneFib[i-2];
        }

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            sb.append(zeroFib[num]).append(" ").append(oneFib[num]).append("\n");
        }
        System.out.println(sb);
    }
}

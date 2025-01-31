package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9461 {
    static long[] Padovan;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int test = Integer.parseInt(st.nextToken());

        Padovan = new long[101];
        Padovan[1] = 1;
        Padovan[2] = 1;
        Padovan[3] = 1;

        for(int i=4; i<=100; i++) {
            Padovan[i] = Padovan[i-3] + Padovan[i-2];
        }

        for(int i=0; i<test; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            sb.append(Padovan[n]).append("\n");
        }

        System.out.println(sb);
    }
}

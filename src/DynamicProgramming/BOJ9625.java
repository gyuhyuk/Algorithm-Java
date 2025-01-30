package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9625 {
    static long[] A;
    static long[] B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        A = new long[46];
        B = new long[46];

        A[0] = 1;
        B[0] = 0;
        A[1] = 0;
        B[1] = 1;

        for(int i=2; i<=45; i++) {
            A[i] = A[i-1] + A[i-2];
            B[i] = B[i-1] + B[i-2];
        }

        sb.append(A[N]).append(" ");
        sb.append(B[N]);

        System.out.println(sb);
    }
}

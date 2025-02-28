package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15489 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int answer = 0;

        int[][] triangle = new int[31][31];

        triangle[1][1] = 1;
        triangle[2][1] = 1;
        triangle[2][2] = 1;

        for(int i=3; i<=30; i++) {
            triangle[i][1] = 1;
            triangle[i][i] = 1;
        }

        for(int i=3; i<=30; i++) {
            for(int j=2; j<i; j++) {
                triangle[i][j] = triangle[i-1][j-1] + triangle[i-1][j];
            }
        }

        for(int i=0; i<W; i++) {
            for(int j=0; j<=i; j++) {
                answer += triangle[R + i][C + j];
            }
        }

        System.out.println(answer);
    }
}

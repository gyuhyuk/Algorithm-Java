package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15645 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][3];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] minArr = new int[N][3];
        int[][] maxArr = new int[N][3];

        for(int i=0; i<3; i++) {
            minArr[0][i] = arr[0][i];
            maxArr[0][i] = arr[0][i];
        }

        for(int i=1; i<N; i++) {
            maxArr[i][0] = Math.max(maxArr[i-1][0], maxArr[i-1][1]) + arr[i][0];
            maxArr[i][1] = Math.max(Math.max(maxArr[i-1][0], maxArr[i-1][1]), maxArr[i-1][2]) + arr[i][1];
            maxArr[i][2] = Math.max(maxArr[i-1][1], maxArr[i-1][2]) + arr[i][2];
        }

        for(int i=1; i<N; i++) {
            minArr[i][0] = Math.min(minArr[i-1][0], minArr[i-1][1]) + arr[i][0];
            minArr[i][1] = Math.min(Math.min(minArr[i-1][0], minArr[i-1][1]), minArr[i-1][2]) + arr[i][1];
            minArr[i][2] = Math.min(minArr[i-1][1], minArr[i-1][2]) + arr[i][2];
        }

        int max = Math.max(Math.max(maxArr[N-1][0], maxArr[N-1][1]), maxArr[N-1][2]);
        int min = Math.min(Math.min(minArr[N-1][0], minArr[N-1][1]), minArr[N-1][2]);

        System.out.print(max + " " + min);
    }
}

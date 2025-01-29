package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11049 {
    static int N;
    static Matrix[] M;
    static int[][] D;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // N 입력
        M = new Matrix[N+1]; // 행렬을 저장할 matrix
        D = new int[N+1][N+1]; // DP 테이블

        for(int i=1; i<=N; i++) { // DP 테이블 -1로 초기화
            for(int j=1; j<=N; j++) {
                D[i][j] = -1;
            }
        }

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            M[i] = new Matrix(y, x);
        }
        System.out.println(excute(1, N));
    }

    static int excute(int start, int end) {
        int result = Integer.MAX_VALUE;

        if(D[start][end] != -1) {
            return D[start][end];
        }

        if(start == end) {
            return 0;
        }

        if(start + 1 == end) {
            return M[start].y * M[start].x * M[end].x;
        }

        for(int i=start; i<end; i++) {
            result = Math.min(result, M[start].y * M[i].x * M[end].x + excute(start, i) + excute(i+1, end));
        }
        return D[start][end] = result;
    }

    static class Matrix {
        int y;
        int x;

        public Matrix(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}

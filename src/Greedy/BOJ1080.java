package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1080 {
    static int N, M;
    static int[][] A;
    static int[][] B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N][M];
        B = new int[N][M];

        for(int i=0; i<N; i++) {
            String s = br.readLine();
            for(int j=0; j<M; j++) {
                A[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }
        for(int i=0; i<N; i++) {
            String s = br.readLine();
            for(int j=0; j<M; j++) {
                B[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }

        if(N < 3 || M < 3) {
            if(isSameMatrix(N, M)) {
                System.out.println("0");
            } else {
                System.out.println("-1");
            }
            return;
        }

        int answer = 0;

        for(int i=0; i<N-2; i++) {
            for(int j=0; j<M-2; j++) {
                if(A[i][j] != B[i][j]) {
                    changeMatrix(i, j);
                    answer++;
                }
            }
        }

        if(!isSameMatrix(N, M)) {
            answer = -1;
        }

        System.out.println(answer);
    }
    static boolean isSameMatrix(int N, int M) {
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(A[i][j] != B[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    static void changeMatrix(int startY, int startX) {
        for(int i=startY; i<startY+3; i++) {
            for(int j=startX; j<startX+3; j++) {
                if(A[i][j] == 1) {
                    A[i][j] = 0;
                } else {
                    A[i][j] = 1;
                }
            }
        }
    }
}

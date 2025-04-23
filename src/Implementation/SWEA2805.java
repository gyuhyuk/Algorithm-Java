package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            int answer = 0;
            int N = Integer.parseInt(br.readLine());
            int[][] map = new int[N][N];

            for(int i=0; i<N; i++) {
                String s = br.readLine();
                for(int j=0; j<N; j++) {
                    map[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
                }
            }

            int center = N/2; // 중심 설정

            for(int i=0; i<N; i++) {
                int range = Math.abs(center - i);

                for(int j=range; j<N-range; j++) {
                    answer += map[i][j];
                }
            }

            System.out.println("#" + t + " " + answer);
        }
    }
}
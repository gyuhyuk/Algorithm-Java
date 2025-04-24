package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA2001 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for(int t=1; t<=T; t++) {
            int max = 0;

            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] map = new int[N][N];

            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i=0; i<=N-M; i++) {
                for(int j=0; j<=N-M; j++) {
                    int value = 0;
                    for(int k=0; k<M; k++) {
                        for(int a=0; a<M; a++) {
                            value += map[i+k][j+a];
                            max = Math.max(max, value);
                        }
                    }
                }
            }

            System.out.println("#" + t + " " + max);
        }
    }
}

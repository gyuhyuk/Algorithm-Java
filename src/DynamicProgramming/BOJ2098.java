package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2098 {
    static final int INF = 1000000 * 16 + 1;
    static int N;
    static int[][] W;
    static int[][] D;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        W = new int[16][16];
        D = new int[16][1 << 16];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(tsp(0, 1));

    }

    static int tsp(int c, int v) {
        if(v == (1<<N) - 1) {
            return W[c][0] == 0 ? INF : W[c][0];
        }

        if(D[c][v] != 0) {
            return D[c][v];
        }
        int min_val = INF;

        for(int i=0; i<N; i++) {
            if((v & (1<< i)) == 0 && W[c][i] != 0) {
                min_val = Math.min(min_val, tsp(i, (v | (1<<i))) + W[c][i]);
            }
        }

        D[c][v] = min_val;
        return D[c][v];
    }
}

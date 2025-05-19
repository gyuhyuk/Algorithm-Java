package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA3752 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            int N = Integer.parseInt(br.readLine());

            int[] scores = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int i=0; i<N; i++) {
                scores[i] = Integer.parseInt(st.nextToken());
            }

            boolean[] possible = new boolean[10001];
            possible[0] = true;

            for(int i=0; i<N; i++) {
                int score = scores[i];

                for(int j=10000; j>=0; j--) {
                    if(possible[j]) {
                        possible[j + score] = true;
                    }
                }
            }

            int count = 0;

            for(boolean p : possible) {
                if(p) {
                    count++;
                }
            }

            System.out.println("#" + t + " " + count);
        }
    }
}

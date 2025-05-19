package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1486 {
    static int N, B, answer;
    static int[] heights;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            heights = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                heights[i] = Integer.parseInt(st.nextToken());
            }

            answer = Integer.MAX_VALUE;

            DFS(0, 0);

            System.out.println("#" + t + " " + (answer - B));
        }
    }

    static void DFS(int index, int sum) {
        if(sum >= B) {
            answer = Math.min(answer, sum);
        }

        if(index == N) {
            return;
        }

        DFS(index + 1, sum + heights[index]);

        DFS(index+1, sum);
    }
}

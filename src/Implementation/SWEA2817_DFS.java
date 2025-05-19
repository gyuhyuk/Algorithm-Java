package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA2817_DFS {
    static int N, K, count;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            arr = new int[N];

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            count = 0;
            DFS(0, 0);

            System.out.println("#" + t + " " + count);
        }
    }

    static void DFS(int index, int sum) {
        if(sum == K) {
            count++;
            return;
        }

        if (index == N || sum > K) return;

        DFS(index+1, sum);
        DFS(index+1, sum + arr[index]);
    }
}

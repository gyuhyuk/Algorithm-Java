package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2491 {
    static int N;
    static int[] arr = new int[1000001];
    static long[] decreaseDp = new long[1000001];
    static long[] increaseDp = new long[1000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        increaseDp[0] = 1;
        decreaseDp[0] = 1;

        for(int i=1; i<N; i++) {
            if(arr[i-1] <= arr[i]) {
                increaseDp[i] = increaseDp[i-1] + 1;
            }
            else {
                increaseDp[i] = 1;
            }
            if(arr[i-1] >= arr[i]) {
                decreaseDp[i] = decreaseDp[i-1] + 1;
            }
            else {
                decreaseDp[i] = 1;
            }
        }

        long max = 0;
        for(int i=0; i<N; i++) {
            max = Math.max(max, Math.max(increaseDp[i], decreaseDp[i]));
        }

        System.out.println(max);
    }
}

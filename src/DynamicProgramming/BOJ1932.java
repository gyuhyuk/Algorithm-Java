package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1932 {
    static long[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        arr = new long[501][501];

        for(int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=i; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // n = 5라고 할때,
        // i는 4, 3, 2, 1
        for(int i=n-1; i>=1; i--) {
            for(int j=1; j<=i; j++) {
                arr[i][j] = Math.max((arr[i][j] + arr[i+1][j]), (arr[i][j] + arr[i+1][j+1]));
            }
        }

        System.out.println(arr[1][1]);
    }
}

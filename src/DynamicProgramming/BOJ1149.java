package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ1149 {
    static long[][] arr;
    static long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int home = Integer.parseInt(st.nextToken());

        arr = new long[home+1][4];
        dp = new long[home+1][4];

        for(int i=1; i<=home; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[1][1] = arr[1][1];
        dp[1][2] = arr[1][2];
        dp[1][3] = arr[1][3];

        for(int i=2; i<=home; i++) {
                dp[i][1] = Math.min((dp[i-1][2] + arr[i][1]), (dp[i-1][3] + arr[i][1]));
                dp[i][2] = Math.min((dp[i-1][1] + arr[i][2]), (dp[i-1][3] + arr[i][2]));
                dp[i][3] = Math.min((dp[i-1][1] + arr[i][3]), (dp[i-1][2] + arr[i][3]));
        }

        long a = dp[home][1];
        long b = dp[home][2];
        long c = dp[home][3];

        ArrayList<Long> arrayList = new ArrayList<>();
        arrayList.add(a);
        arrayList.add(b);
        arrayList.add(c);
        Collections.sort(arrayList);

        System.out.println(arrayList.get(0));
    }
}

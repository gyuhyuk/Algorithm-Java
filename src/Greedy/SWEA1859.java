package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1859 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for(int t=1; t<=T; t++) {
            long answer = 0;
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int[] arr = new int[N];

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            long max = 0;

            for(int i=arr.length-1; i>=0; i--) {
                if(arr[i] > max) {
                    max = arr[i];
                } else {
                    answer += (max - arr[i]);
                }
            }

            System.out.println("#" + t + " " + answer);
        }
    }
}

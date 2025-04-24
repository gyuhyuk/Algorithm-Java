package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1204 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            int num = Integer.parseInt(br.readLine());
            int[] arr = new int[101];

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<1000; i++) {
                arr[Integer.parseInt(st.nextToken())]++;
            }

            int max = 0;
            int answer = 0;

            for(int i=1; i<=100; i++) {
                if(arr[i] >= max) {
                    max = arr[i];
                    answer = i;
                }
            }

            System.out.println("#" + num + " " + answer);
        }
    }
}

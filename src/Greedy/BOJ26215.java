package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ26215 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        Integer[] arr = new Integer[N];

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, Collections.reverseOrder());

        int answer = 0;

        while (arr[0] > 0) {

            if(arr.length > 1) {
                if(arr[0] > 0) {
                    arr[0] -= 1;
                }
                if(arr[1] > 0) {
                    arr[1] -= 1;
                }
            } else {
                arr[0] -= 1;
            }

            answer++;

            Arrays.sort(arr, Collections.reverseOrder());
        }

        if(answer > 1440) {
            System.out.println(-1);
            System.exit(0);
        }
        else {
            System.out.println(answer);
        }
    }
}

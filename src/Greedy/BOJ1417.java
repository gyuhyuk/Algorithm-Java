package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1417 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr;

        int N = Integer.parseInt(st.nextToken());

        arr = new int[N];

        int count = 0;

        st = new StringTokenizer(br.readLine());
        int dasom = Integer.parseInt(st.nextToken());

        for(int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        while (dasom <= arr[arr.length-1]) {
            count++;
            arr[arr.length-1] -= 1;
            Arrays.sort(arr);
            dasom += 1;
        }


        System.out.println(count);
    }
}

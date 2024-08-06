package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10813 {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        arr = new int[N+1];

        for(int i=1; i<=N; i++) {
            arr[i] = i;
        }

        for(int i=0; i<M; i++) {
            s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);

            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }

        for(int i=1; i<=N; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA6485 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            StringBuilder sb = new StringBuilder();
            int[] arr = new int[5001];

            int N = Integer.parseInt(br.readLine());

            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());

                for(int j=A; j<=B; j++) {
                    arr[j]++;
                }
            }

            int P = Integer.parseInt(br.readLine());

            for(int i=0; i<P; i++) {
                int C = Integer.parseInt(br.readLine());
                sb.append(arr[C]).append(" ");
            }

            System.out.println("#" + t + " " + sb);
        }
    }
}

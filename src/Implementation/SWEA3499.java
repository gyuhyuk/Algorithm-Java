package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA3499 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for(int t=1; t<=T; t++) {
            int N = Integer.parseInt(br.readLine());
            String[] cards = br.readLine().split(" ");

            String[] left = new String[(N + 1) / 2];
            String[] right = new String[N / 2];

            for(int i=0; i<(N+1) / 2; i++) {
                left[i] = cards[i];
            }

            for(int i=0; i < N/2; i++) {
                right[i] = cards[(N+1) / 2 + i];
            }

            StringBuilder sb = new StringBuilder();

            sb.append("#").append(t).append(" ");
            for (int i = 0; i < N / 2; i++) {
                sb.append(left[i]).append(" ").append(right[i]).append(" ");
            }

            if(N % 2 == 1) {
                sb.append(left[N / 2]);
            }

            System.out.println(sb);
        }
    }
}

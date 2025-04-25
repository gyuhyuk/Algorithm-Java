package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA21425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());

        for(int t=1; t<=T; t++) {
            st = new StringTokenizer(br.readLine());
            long A = Long.parseLong(st.nextToken());
            long B = Long.parseLong(st.nextToken());
            long N = Long.parseLong(st.nextToken());
            int count = 0;

            while(true) {
                if (A >= B) {
                    B += A;
                    count++;
                } else {
                    A += B;
                    count++;
                }
                if(A > N || B > N) {
                    break;
                }
            }
            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }
}

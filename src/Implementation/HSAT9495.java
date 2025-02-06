package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HSAT9495 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int X = 0;

        int N = Integer.parseInt(st.nextToken());
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            if(Math.abs(P-X) > C) {
                continue;
            }

            if (Math.abs(P-X) <= C) {
                X++;
            }
        }

        System.out.println(X);
    }
}

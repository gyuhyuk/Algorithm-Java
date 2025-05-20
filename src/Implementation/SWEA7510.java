package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA7510 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            int N = Integer.parseInt(br.readLine());
            int count = 0;

            for(int i=1; i<=N; i++) {
                int sum = 0;
                int current = i;

                while (sum < N) {
                    sum += current;
                    current++;
                }

                if(sum == N) {
                    count++;
                }
            }

            System.out.println("#" + t + " " + count);
        }
    }
}

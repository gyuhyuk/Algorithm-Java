package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA14178 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());
            int answer;

            if(N <= D) {
                answer = 1;
            } else {
                if((2*D+1) >= N) {
                    answer = 1;
                } else {
                    if(N % (2*D+1) == 0) {
                        answer = N / (2*D+1);
                    } else {
                        answer = N / (2*D+1) + 1;
                    }
                }
            }

            System.out.println("#" + t + " " + answer);
        }
    }
}

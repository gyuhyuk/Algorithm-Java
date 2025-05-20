package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA7272 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            StringBuilder sb = new StringBuilder();
            st = new StringTokenizer(br.readLine());
            String A = st.nextToken();
            String B = st.nextToken();
            String result = "SAME";

            if(A.length() != B.length()) {
                result = "DIFF";
            } else {
                for(int i=0; i<A.length(); i++) {
                    if(getHoleCount(A.charAt(i)) != getHoleCount(B.charAt(i))) {
                        result = "DIFF";
                        break;
                    }
                }
            }

            System.out.println("#" + t + " " + result);
        }
    }

    static int getHoleCount(char c) {
        if(c == 'B') {
            return 2;
        }
        if("ADOPQR".indexOf(c) >= 0) {
            return 1;
        }
        return 0;
    }
}

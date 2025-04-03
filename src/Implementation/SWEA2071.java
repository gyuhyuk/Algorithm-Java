package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA2071 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for(int i=1; i<=T; i++) {
            double result = 0;
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<10; j++) {
                int num = Integer.parseInt(st.nextToken());
                result += num;
            }
            result = Math.round(result / 10);

            System.out.println("#" + i + " " + (int) result);
        }
    }
}

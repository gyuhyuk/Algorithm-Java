package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA16910 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++) {
            int N = Integer.parseInt(br.readLine());

            int count = 0;
            for(int i=-200; i<=200; i++) {
                for(int j=-200; j<=200; j++) {
                    if(Math.pow(i, 2) + Math.pow(j, 2) <= Math.pow(N, 2)) {
                        count++;
                    }
                }
            }
            System.out.println("#" + t + " " + count);
        }
    }
}

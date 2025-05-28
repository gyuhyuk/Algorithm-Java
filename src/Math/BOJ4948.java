package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ4948 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int N = Integer.parseInt(br.readLine());

            int count = 0;

            if(N == 0) {
                break;
            }

            for(int i=N+1; i<=N*2; i++) {
                if(isPrime(i)) {
                    count++;
                }
            }

            System.out.println(count);
        }
    }

    static boolean isPrime(int x) {
        if(x < 2) {
            return false;
        }

        for(int i=2; i<=Math.sqrt(x); i++) {
            if(x % i == 0) {
                return false;
            }
        }

        return true;
    }
}

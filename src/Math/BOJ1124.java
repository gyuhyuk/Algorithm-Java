package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1124 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int answer = 0;

        for(int i=A; i<=B; i++) {
            int temp = primeFactorization(i);
            if(temp >= 2 && isPrime(temp)) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    static int primeFactorization(int x) {
        int count = 0;
        for(int i=2; i<=Math.sqrt(x); i++) {
            while (x % i == 0) {
                count++;
                x /= i;
            }
        }
        if(x > 1) count++;
        return count;
    }

    static boolean isPrime(int x) {
        if(x < 2) return false;
        for(int i=2; i<x; i++) {
            if(x % i == 0) {
                return false;
            }
        }
        return true;
    }
}

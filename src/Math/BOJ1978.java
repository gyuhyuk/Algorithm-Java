package Math;

import java.util.Scanner;

public class BOJ1978 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int cnt = 0;

        for(int i=0; i<N; i++) {
            int x = scanner.nextInt();
            if(isPrime(x)) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    public static boolean isPrime(int num) {
        if(num<2) {
            return false;
        }
        for(int i=2; i*i<=num; i++) {
                if(num % i == 0) {
                    return false;
                }
            }
        return true;
    }
}

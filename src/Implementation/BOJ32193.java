package Implementation;

import java.util.Scanner;

public class BOJ32193 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int firstA = sc.nextInt();
        int firstB = sc.nextInt();

        int firstTemp = firstA-firstB;

        System.out.println(firstTemp);

        for(int i=1; i<N; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();

            int temp = A-B;

            firstTemp += temp;

            System.out.println(firstTemp);
        }
    }
}

package Math;

import java.util.Scanner;

public class SWEA1217 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int t=1; t<=10; t++) {
            int user = sc.nextInt();

            int x = sc.nextInt();
            int y = sc.nextInt();

            int answer = x;

            for(int i=1; i<y; i++) {
                answer = answer * x;
            }

            System.out.println("#" + user + " " + answer);
        }
    }
}

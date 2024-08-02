package Greedy;

import java.util.Scanner;

public class BOJ1343 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        String answer = "";
        String A = "AAAA";
        String B = "BB";

        s = s.replaceAll("XXXX", A);
        answer = s.replaceAll("XX", B);

        if (answer.contains("X")) {
            System.out.println("-1");
        }

        else {
            System.out.println(answer);
        }
    }
}

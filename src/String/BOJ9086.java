package String;

import java.util.Scanner;

public class BOJ9086 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());

        for(int i=0; i<N; i++) {
            String s = sc.nextLine();
            System.out.println(s.charAt(0) + "" + s.charAt(s.length()-1));
        }
    }
}

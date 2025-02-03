package Implementation;

import java.util.Scanner;

public class HSAT7698 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int x = sc.nextInt();
            if (x >= 5) {
                int a = x / 5;
                int b = x % 5;
                for (int j = 0; j < a; j++) {
                    System.out.print("++++ ");
                }
                for (int k = 0; k < b; k++) {
                    System.out.print("|");
                }
            } else {
                for (int l = 0; l < x; l++) {
                    System.out.print("|");
                }
            }
            System.out.println();
        }
    }
}
package Greedy;

import java.util.Scanner;

public class CodeUp3120 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();

        int temp = Math.abs(A-B);

        int count = 0;

        while(true) {
            if(temp >= 10) {
                temp -= 10;
                count++;
            }
            else if (temp > 7) {
                temp -= 10;
                count++;
            }
            else if(temp >=5) {
                temp -= 5;
                count++;
            } else if (temp > 3) {
                temp -= 5;
                count++;
            } else if (temp > 0) {
                temp -= 1;
                count++;
            } else if (temp == 0) {
                break;
            }
            else {
                temp += 1;
                count++;
            }
        }

        System.out.println(count);
    }
}

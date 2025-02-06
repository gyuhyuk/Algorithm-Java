package Implementation;

import java.util.Scanner;
public class HSAT9497 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                sb.append(j).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ25206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double result = 0;
        int numSum = 0;

        for(int i=0; i<20; i++) {
            String s = br.readLine();

            String[] temp = s.split("\\.");
            int num = Integer.parseInt(String.valueOf(temp[0].charAt(temp[0].length()-1))); // 학점
            String score = temp[1].substring(2);
            if (score.equals("P")) {
                continue; // P는 계산에서 제외
            }
            numSum += num;
            if (score.equals("A+")) {
                result += num * 4.5;
            } else if (score.equals("A0")) {
                result += num * 4.0;
            } else if (score.equals("B+")) {
                result += num * 3.5;
            } else if (score.equals("B0")) {
                result += num * 3.0;
            } else if (score.equals("C+")) {
                result += num * 2.5;
            } else if (score.equals("C0")) {
                result += num * 2.0;
            } else if (score.equals("D+")) {
                result += num * 1.5;
            } else if (score.equals("D0")) {
                result += num * 1.0;
            } else if (score.equals("F")) {
                result += 0;
            }
        }

        System.out.println(result / numSum);
    }
}

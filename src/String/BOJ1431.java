package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ1431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<String> list = new ArrayList<>();

        for(int i=0; i<N; i++) {
            String temp = br.readLine();
            list.add(temp);
        }

        list.sort((o1, o2) -> {
          if(o1.length() != o2.length()) {
              return o1.length() - o2.length();
          }

          int sum1 = getDigitSum(o1);
          int sum2 = getDigitSum(o2);

          if(sum1 != sum2) {
              return sum1 - sum2;
          }

          return o1.compareTo(o2);
        });

        for(String s : list) {
            System.out.println(s);
        }
    }

    static int getDigitSum(String s) {
        int sum = 0;
        for(char c : s.toCharArray()) {
            if(Character.isDigit(c)) {
                sum += c - '0';
            }
        }

        return sum;
    }
}

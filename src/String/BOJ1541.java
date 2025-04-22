package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        String[] minusSplit = s.split("-");
        int result = 0;

        for(int i=0; i<minusSplit.length; i++) {
            String[] plusSplit = minusSplit[i].split("\\+");
            int sum = 0;
            for(String temp : plusSplit) {
                sum += Integer.parseInt(temp);
            }

            if(i == 0) {
                result += sum;
            } else {
                result -= sum;
            }
        }
        System.out.println(result);
    }
}

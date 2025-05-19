package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA1213 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int t=1; t<=10; t++) {
            int user = Integer.parseInt(br.readLine());
            String searchString = br.readLine();
            String sentence = br.readLine();

            int count = 0;
            int index = 0;

            while ((index = sentence.indexOf(searchString, index)) != -1) {
                count++;
                index += searchString.length();
            }

            System.out.println("#" + t + " " + count);
        }
    }
}

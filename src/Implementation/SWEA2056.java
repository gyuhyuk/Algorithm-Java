package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA2056 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] daysInMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        for (int i = 1; i <= N; i++) {
            String s = br.readLine();
            String year = s.substring(0, 4);
            int month = Integer.parseInt(s.substring(4, 6));
            int day = Integer.parseInt(s.substring(6, 8));

            if (month < 1 || month > 12 || day < 1 || day > daysInMonth[month]) {
                System.out.println("#" + i + " -1");
            } else {
                System.out.println("#" + i + " " + year + "/" + s.substring(4, 6) + "/" + s.substring(6, 8));
            }
        }
    }
}

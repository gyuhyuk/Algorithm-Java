package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA2058 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int answer = 0;

        String s = st.nextToken();

        for(int i=0; i<s.length(); i++) {
            answer += Integer.parseInt(String.valueOf(s.charAt(i)));
        }

        System.out.println(answer);
    }
}

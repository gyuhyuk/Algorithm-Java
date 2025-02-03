package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HSAT7703 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            String s1 = st.nextToken();
            String s2 = st.nextToken();
            int count = 0;
            for (char s : s1.toCharArray()) {
                if(s == 'X' || s == 'x') {
                    break;
                }
                count++;
            }
            s2 = s2.toUpperCase();
            char temp = s2.charAt(count);

            sb.append(temp);
        }

        System.out.println(sb);
    }
}

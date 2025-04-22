package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int answer = 0;

        String s = br.readLine();

        for(int i=0; i<s.length(); i++) {
            if (i < s.length() - 2 && s.charAt(i) == 'd' && s.charAt(i + 1) == 'z' && s.charAt(i + 2) == '=') {
                answer++;
                i += 2; // 다음 문자를 두 칸 건너뛰기
            } else if (i < s.length() - 1) {
                String pair = s.substring(i, i + 2);
                if(pair.equals("c=") || pair.equals("c-") || pair.equals("d-") ||
                        pair.equals("lj") || pair.equals("nj") ||
                        pair.equals("s=") || pair.equals("z=")) {
                    answer++;
                    i++;
                }
                else {
                    answer++;
                }
            }

            else {
                answer++;
            }
        }

        System.out.println(answer);
    }
}

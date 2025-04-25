package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA1926 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for(int i=1; i<=N; i++) {
            String temp = String.valueOf(i);
            if(temp.contains("3") || temp.contains("6") || temp.contains("9")) { // 3, 6, 9가 포함되어 있으면
                for(int j=0; j<temp.length(); j++) {
                    char c = temp.charAt(j);
                    if(c == '3' || c == '6' || c == '9') {
                        sb.append("-");
                    }
                }
                sb.append(" ");
            }
            else {
                sb.append(i).append(" ");
            }
        }

        System.out.println(sb);
    }
}

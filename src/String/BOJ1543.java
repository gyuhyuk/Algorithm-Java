package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String document = br.readLine();
        String user = br.readLine();
        int answer = 0;

        for(int i=0; i<=document.length()-user.length();) {
            if(document.startsWith(user, i)) {
                answer++;
                i += user.length();
            } else {
                i++;
            }
        }

        System.out.println(answer);
    }
}

package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int count = 0;

        for(int i=0; i<N; i++) {
            int[] check = new int[26]; // a가 들어오면 0번째 체크, z가 들어오면 25번째 체크
            char[] text = br.readLine().toCharArray();

            char first = text[0];
            check[first-'a'] = 1;

            boolean group = true;

            for(int j=1; j<text.length; j++) {
                char now = text[j];

                // 연속된 글자가 아닌데, 이전에 들어온 경우가 있는 경우 (그룹단어 아님)
                if(first != now && check[now-'a'] == 1) {
                    group = false;
                    break;
                }
                check[now - 'a'] = 1;
                first = now;
            }

            if(group) {
                count++;
            }
        }

        System.out.println(count);
    }
}

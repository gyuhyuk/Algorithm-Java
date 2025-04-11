package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ11117 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            String s = br.readLine();
            int[] sourceCount = new int[26];

            for(char c : s.toCharArray()) {
                sourceCount[c - 'A']++;
            }

            int testcase = Integer.parseInt(br.readLine());

            for(int j=0; j<testcase; j++) {
                String target = br.readLine();
                int[] targetCount = new int[26];

                for(char c : target.toCharArray()) {
                    targetCount[c - 'A']++;
                }

                boolean canMake = true;
                for(int k=0; k<26; k++) {
                    if(targetCount[k] > sourceCount[k]) {
                        canMake = false;
                        break;
                    }
                }

                sb.append(canMake ? "YES\n" : "NO\n");
            }
        }
        System.out.println(sb);
    }
}

package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1283 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        boolean[] alpha = new boolean[26];

        for(int i=0; i<N; i++) {
            String s = br.readLine();
            String[] words = s.split(" ");
            boolean shortcut = false;

            StringBuilder sb = new StringBuilder();

            for(int j=0; j<words.length; j++) {
                char temp = Character.toUpperCase(words[j].charAt(0));
                int index = temp - 'A';

                if(!alpha[index]) {
                    alpha[index] = true;
                    shortcut = true;

                    for(int k=0; k < words.length; k++) {
                        if(k > 0) {
                            sb.append(" ");
                        }
                        if(k == j) {
                            sb.append("[").append(words[k].charAt(0)).append("]").append(words[k].substring(1));
                        }
                        else {
                            sb.append(words[k]);
                        }
                    }
                    break;
                }
            }
            if(!shortcut) {
                sb.setLength(0);
                boolean found = false;
                for(int j=0; j<s.length(); j++) {
                    char c = s.charAt(j);
                    if(c == ' ') continue;
                    char upper = Character.toUpperCase(c);
                    int index = upper - 'A';
                    if(!alpha[index]) {
                        alpha[index] = true;
                        found = true;
                        sb.append(s, 0, j).append("[").append(c).append("]").append(s.substring(j+1));
                        break;
                    }
                }
                if(!found) {
                    sb.append(s);
                }
            }

            System.out.println(sb);
        }
    }
}

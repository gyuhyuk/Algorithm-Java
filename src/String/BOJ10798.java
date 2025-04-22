package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[][] map = new char[5][15];

        for(int i=0; i<5; i++) {
            String s = br.readLine();
            for(int j=0; j<s.length(); j++) {
                map[i][j] = s.charAt(j);
            }
        }

        for(int j=0; j<15; j++) {
            for(int i=0; i<5; i++) {
                if(map[i][j] == '\0') {
                    continue;
                } else {
                    System.out.print(map[i][j]);
                }
            }
        }
    }
}

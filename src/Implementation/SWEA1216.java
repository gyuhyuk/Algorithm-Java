package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA1216 {
    static int maxLength;
    static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int t=1; t<=10; t++) {
            int user = Integer.parseInt(br.readLine());

            map = new char[100][100];

            for (int i = 0; i < 100; i++) {
                String line = br.readLine();
                for (int j = 0; j < 100; j++) {
                    map[i][j] = line.charAt(j);
                }
            }

            for (int len = 100; len >= 1; len--) {
                if (findPalindrome(len)) {
                    maxLength = len;
                    break; // 가장 긴 회문을 찾았으므로 종료
                }
            }

            System.out.println("#" + user + " " + maxLength);
        }
    }

    static boolean findPalindrome(int len) {
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j <= 100 - len; j++) {
                boolean isPalindrome = true;
                for (int k = 0; k < len / 2; k++) {
                    if (map[i][j + k] != map[i][j + len - 1 - k]) {
                        isPalindrome = false;
                        break;
                    }
                }
                if (isPalindrome) return true;
            }
        }

        for (int j = 0; j < 100; j++) {
            for (int i = 0; i <= 100 - len; i++) {
                boolean isPalindrome = true;
                for (int k = 0; k < len / 2; k++) {
                    if (map[i + k][j] != map[i + len - 1 - k][j]) {
                        isPalindrome = false;
                        break;
                    }
                }
                if (isPalindrome) return true;
            }
        }

        return false;
    }
}

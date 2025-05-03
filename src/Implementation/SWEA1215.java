package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;

public class SWEA1215 {
    static int count;
    static char[][] arr;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int t=1; t<=10; t++) {
            count = 0;
            N = Integer.parseInt(br.readLine());

            arr = new char[8][8];

            for(int i=0; i<8; i++) {
                String s = br.readLine();
                for(int j=0; j<8; j++) {
                    arr[i][j] = s.charAt(j);
                }
            }

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j <= 8 - N; j++) {
                    if (isPalindromeX(i, j)) {
                        count++;
                    }
                }
            }

            for (int i = 0; i <= 8 - N; i++) {
                for (int j = 0; j < 8; j++) {
                    if (isPalindromeY(i, j)) {
                        count++;
                    }
                }
            }

            System.out.println("#" + t + " " + count);
        }
    }

    static boolean isPalindromeX(int x, int y) {
        ArrayList<String> StringArr = new ArrayList<>();
        for(int i=0; i<N; i++) {
            StringArr.add(String.valueOf(arr[x][y+i]));
        }
        int leftIndex = 0;
        int rightIndex = StringArr.size()-1;

        while (leftIndex < rightIndex) {
            String leftTemp = StringArr.get(leftIndex);
            String rightTemp = StringArr.get(rightIndex);

            if(!Objects.equals(leftTemp, rightTemp)) {
                return false;
            }

            leftIndex++;
            rightIndex--;
        }
        return true;
    }

    static boolean isPalindromeY(int x, int y) {
        ArrayList<String> StringArr = new ArrayList<>();
        for(int i=0; i<N; i++) {
            StringArr.add(String.valueOf(arr[x+i][y]));
        }
        int leftIndex = 0;
        int rightIndex = StringArr.size()-1;

        while (leftIndex < rightIndex) {
            String leftTemp = StringArr.get(leftIndex);
            String rightTemp = StringArr.get(rightIndex);

            if(!Objects.equals(leftTemp, rightTemp)) {
                return false;
            }

            leftIndex++;
            rightIndex--;
        }
        return true;
    }

}

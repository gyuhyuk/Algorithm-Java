package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ20125 {
    static int N;
    static char[][] A;
    static int heartX = -1;
    static int heartY = -1;
    static int leftArm = 0;
    static int leftLeg = 0;
    static int rightArm = 0;
    static int rightLeg = 0;
    static int waist = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        A = new char[N+1][N+1];

        for(int i=1; i<=N; i++) {
            String s = br.readLine();
            for(int j=1; j<=N; j++) {
                A[i][j] = s.charAt(j-1);
                if(A[i][j] == '*' && heartX == -1) {
                    heartX = i+1;
                    heartY = j;
                }
            }
        }

        int n1 = heartX;
        int n2 = heartY-1;
        while (n2 >=1 && A[n1][n2] == '*') {
            leftArm++;
            n2--;
        }

        n1 = heartX;
        n2 = heartY+1;
        while (n2 <= N && A[n1][n2] == '*') {
            rightArm++;
            n2++;
        }

        int wx = heartX+1;
        int wy = heartY;
        while (wx <= N && wy <= N && A[wx][wy] == '*') {
            waist++;
            wx++;
        }

        n1 = wx + 1;
        n2 = wy - 1;
        leftLeg = 1;
        while (n1 <= N && n2 <= N && A[n1][n2] == '*') {
            leftLeg++;
            n1++;
        }

        n1 = wx + 1;
        n2 = wy + 1;
        rightLeg = 1;
        while (n1 <= N && n2 <= N && A[n1][n2] == '*') {
            rightLeg++;
            n1++;
        }

        System.out.println(heartX + " " + heartY);
        System.out.println(leftArm + " " + rightArm + " " + waist + " " + leftLeg + " " + rightLeg);
    }
}

package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ12756 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int attackA = Integer.parseInt(st.nextToken());
        int lifeA = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int attackB = Integer.parseInt(st.nextToken());
        int lifeB = Integer.parseInt(st.nextToken());

        while (true) {
            lifeA -= attackB;
            lifeB -= attackA;

            if(lifeA > 0) { // A가 0보다 크고
                if(lifeB <= 0) { // B가 0이하면
                    System.out.println("PLAYER A"); // A의 승리
                    return;
                }
            } else { // A가 0 이하고
                if(lifeB > 0) { // B가 0보다 크면
                    System.out.println("PLAYER B");
                    return;
                }
                else {
                    System.out.println("DRAW");
                    return;
                }
            }
        }
    }
}

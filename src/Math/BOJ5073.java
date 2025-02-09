package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ5073 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // 종료 조건
            if (a == 0 && b == 0 && c == 0) {
                break;
            }

            // 배열을 사용하여 정렬
            int[] sides = {a, b, c};
            Arrays.sort(sides);

            // 삼각형 판별
            if (sides[0] + sides[1] <= sides[2]) {
                sb.append("Invalid").append("\n");
            } else if (sides[0] == sides[2]) { // 세 변의 길이가 같음
                sb.append("Equilateral").append("\n");
            } else if (sides[0] == sides[1] || sides[1] == sides[2]) { // 두 변만 같음
                sb.append("Isosceles").append("\n");
            } else { // 모든 변의 길이가 다름
                sb.append("Scalene").append("\n");
            }
        }

        System.out.println(sb);
    }
}

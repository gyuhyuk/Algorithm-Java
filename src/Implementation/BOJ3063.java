package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ3063 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++) {
            int answer = 0;

            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x3 = Integer.parseInt(st.nextToken());
            int y3 = Integer.parseInt(st.nextToken());
            int x4 = Integer.parseInt(st.nextToken());
            int y4 = Integer.parseInt(st.nextToken());

            int s1 = (x2 - x1) * (y2 - y1);

            int h = (Math.min(x2, x4) - Math.max(x1, x3));
            int w = (Math.min(y2, y4) - Math.max(y1, y3));

            int s2 = 0;

            if(h > 0 && w > 0) {
                s2 = h * w;
            }

            answer = s1 - s2;

            System.out.println(answer);
        }
    }
}

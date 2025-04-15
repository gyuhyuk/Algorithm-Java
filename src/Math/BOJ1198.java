package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1198 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] points = new int[n][2];

        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            points[i][0] = Integer.parseInt(st.nextToken());
            points[i][1] = Integer.parseInt(st.nextToken());
        }

        double maxArea = 0;

        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                for(int k=j+1; k<n; k++) {
                    double area = getArea(points[i], points[j], points[k]);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        System.out.println(maxArea);
    }

    static double getArea(int[] a, int[] b, int[] c) {
        return 0.5 * Math.abs(a[0] * (b[1]-c[1]) + b[0] * (c[1] - a[1]) + c[0] * (a[1] - b[1]));
    }
}

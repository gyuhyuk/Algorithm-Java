package Implementation;

import java.io.*;
import java.util.*;
public class HSAT7374 {
    static int[][] A;
    static int currentCost;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        ArrayList<Integer> row = new ArrayList<>();

        A = new int[3][3];
        int min = Integer.MAX_VALUE;

        for(int i=0; i<3; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++) {
                int height = Integer.parseInt(st.nextToken());
                A[i][j] = height;
                row.add(height);
            }
            Collections.sort(row);
            currentCost = 0;
            if(row.get(0) == row.get(2)) {
                System.out.println(0);
                return;
            } else {
                currentCost = (row.get(2) - row.get(0)) + (row.get(2) - row.get(1));
            }
            if(currentCost < min) {
                min = currentCost;
            }

            row.clear();
        }

        for(int i=0; i<3; i++) {
            currentCost = 0;
            for(int j=0; j<3; j++) {
                row.add(A[j][i]);
            }
            Collections.sort(row);
            if(row.get(0) == row.get(2)) {
                System.out.println(0);
                return;
            }
            else {
                currentCost = (row.get(2) - row.get(0)) + (row.get(2) - row.get(1));
            }
            if(currentCost < min) {
                min = currentCost;
            }

            row.clear();
        }
        System.out.println(min);
    }
}

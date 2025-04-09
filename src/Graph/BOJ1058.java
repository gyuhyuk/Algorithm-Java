package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1058 {
    static int N;
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 0;

        N = Integer.parseInt(st.nextToken());
        A = new ArrayList[N+1];
        for(int i=1; i<=N; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            for (int j = 1; j <= N; j++) {
                if (line.charAt(j - 1) == 'Y') {
                    A[i].add(j);
                }
            }
        }

        for(int i=1; i<=N; i++) {
            visited = new boolean[N+1];
            int count = 0;

            for(int friend : A[i]) {
                if(!visited[friend]) {
                    visited[friend] = true;
                    count++;
                }

                for(int friends : A[friend]) {
                    if(friends != i && !visited[friends]) {
                        visited[friends] = true;
                        count++;
                    }
                }

                max = Math.max(max, count);
            }
        }

        System.out.println(max);
    }
}

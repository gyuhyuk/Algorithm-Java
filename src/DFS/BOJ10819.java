package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ10819 {
    static int N;
    static int max = 0;
    static int[] arr;
    static ArrayList<Integer> arrayList = new ArrayList<>();
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        DFS(0);

        System.out.println(max);
    }

    static void DFS(int depth) {
        if(depth == N) {
            int sum = 0;
            for(int i=0; i<N-1; i++) {
                sum += Math.abs(arrayList.get(i) - arrayList.get(i+1));
            }

            max = Math.max(sum, max);
            return;
        }

        for(int i=0; i<N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                arrayList.add(arr[i]);
                DFS(depth + 1);
                arrayList.remove(arrayList.size() - 1);
                visited[i] = false;
            }
        }
    }
}

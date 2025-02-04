package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class HSAT6289 {
    static int N, M;
    static ArrayList<Integer> arr = new ArrayList<>();
    static int[] best;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 5
        M = Integer.parseInt(st.nextToken()); // 3
        best = new int[N+1]; // best 초기화
        Arrays.fill(best, 1); // 전부 1로 초기화

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            arr.add(Integer.parseInt(st.nextToken())); // 배열에 넣기
        }

        // 1,2중에 1, 0
        // 2,3중에 0, 1
        // 3,4중에 똑같아서 둘다 0, 0
        // 5는 비교 상대 없으니 1
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(arr.get(a-1) > arr.get(b-1)) {
                best[b] = 0;
            }
            else if(arr.get(a-1) < arr.get(b-1)) {
                best[a] = 0;
            }
            else {
                best[a] = 0;
                best[b] = 0;
            }
        }

        int ans = 0;
        for(int i=1; i<best.length; i++) {
            ans += best[i];
        }

        System.out.print(ans);
    }
}

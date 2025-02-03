package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class HSAT6288 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int w = Integer.parseInt(st.nextToken()); // 가방의 최대 무게
        int n = Integer.parseInt(st.nextToken()); // 아이템 개수

        List<int[]> items = new ArrayList<>(); // (무게, 가격) 저장

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken()); // 무게
            int p = Integer.parseInt(st.nextToken()); // 가격
            items.add(new int[]{m, p});
        }

        // 가격(P) 기준으로 내림차순 정렬
        items.sort((a, b) -> b[1] - a[1]);

        int max = 0; // 최대 가치 저장

        for (int[] item : items) {
            int m = item[0]; // 무게
            int p = item[1]; // 가격

            if (w <= 0) break; // 가방이 꽉 찼다면 종료

            if (m <= w) { // 전체 무게를 가방에 넣을 수 있으면
                max += m * p; // 가치 추가
                w -= m; // 무게 줄이기
            } else { // 일부만 넣을 수 있는 경우
                max += w * p; // 남은 무게만큼 가치 추가
                w = 0; // 가방이 꽉 참
            }
        }

        System.out.println(max);
    }
}

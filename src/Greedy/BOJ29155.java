package Greedy;

import java.io.*;
import java.util.*;

public class BOJ29155 {
    static int N;
    static ArrayList<Integer>[] problems;
    static int[] required; // 난이도별 풀어야 하는 문제 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        required = new int[6]; // 난이도 1~5

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= 5; i++) {
            required[i] = Integer.parseInt(st.nextToken()); // 난이도별 문제 개수
        }

        problems = new ArrayList[6]; // 난이도별 문제 리스트
        for (int i = 1; i <= 5; i++) {
            problems[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int difficulty = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            problems[difficulty].add(time);
        }

        // 각 난이도의 문제들을 오름차순 정렬 (최소한의 시간 선택)
        for (int i = 1; i <= 5; i++) {
            Collections.sort(problems[i]);
        }

        // 문제 풀이 시작
        int totalTime = 0; // 총 걸리는 시간
        int prevDifficulty = 0; // 이전 문제 난이도

        for (int i = 1; i <= 5; i++) {
            if (problems[i].size() < required[i]) {
                System.out.println(-1); // 풀어야 할 문제 수보다 적다면 -1 출력
                return;
            }

            int lastTime = 0; // 현재 난이도에서 마지막으로 푼 문제 시간

            for (int j = 0; j < required[i]; j++) {
                int currentTime = problems[i].get(j);
                totalTime += currentTime; // 문제 풀이 시간 추가

                if (j > 0) {
                    totalTime += (currentTime - lastTime); // 같은 난이도 문제 간 휴식 시간 추가
                }

                lastTime = currentTime; // 마지막으로 푼 문제 업데이트
            }

            // 난이도 변경 시 60분 추가
            if (prevDifficulty != 0 && prevDifficulty < i) {
                totalTime += 60;
            }

            prevDifficulty = i; // 이전 난이도 업데이트
        }

        System.out.println(totalTime);
    }
}

package Greedy;

import java.io.*;
import java.util.*;

public class BOJ32185 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int jaewon = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            jaewon += Integer.parseInt(st.nextToken());
        }

        ArrayList<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int sum = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
            students.add(new Student(i, sum));
        }

        Collections.sort(students, (a, b) -> b.score - a.score); // b.score - a.score는 점수를 기준으로 내림차순 정렬 수행
        // 즉, 점수가 높은 학생이 리스트의 앞쪽에 위치

        ArrayList<Integer> answerList = new ArrayList<>();
        answerList.add(0);  // 재원이의 인덱스

        for (Student student : students) {
            if (student.score <= jaewon && answerList.size() < m) {
                answerList.add(student.index + 1);
            }
            if (answerList.size() == m) break;
        }

        Collections.sort(answerList);

        for (int index : answerList) {
            bw.write(index + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class Student {
        int index;
        int score;

        Student(int index, int score) {
            this.index = index;
            this.score = score;
        }
    }
}
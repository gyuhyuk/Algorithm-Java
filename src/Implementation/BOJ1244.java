package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1244 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1]; // index 1부터 쓰기위해

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(st.nextToken()); // 스위치 채워넣기
        }

        st = new StringTokenizer(br.readLine());
        int student = Integer.parseInt(st.nextToken()); // 학생 수

        for(int i=0; i<student; i++) { // 학생 수 만큼 반복
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int index = Integer.parseInt(st.nextToken());

            if(gender == 1) { // 남자면, 받은 수의 배수를 switch
                for (int j = 1; index * j <= N; j++) {
                    arr[index * j] = arr[index * j] == 0 ? 1 : 0;
                }
            } if (gender == 2) { // 여자일 때
                int count = 1;

                // 자신 먼저 토글
                arr[index] = arr[index] == 0 ? 1 : 0;

                // 대칭을 검사하며 토글
                while (index - count >= 1 && index + count <= N && arr[index - count] == arr[index + count]) {
                    arr[index - count] = arr[index - count] == 0 ? 1 : 0;
                    arr[index + count] = arr[index + count] == 0 ? 1 : 0;
                    count++;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(arr[i] + " ");
            if (i % 20 == 0) {
                System.out.println();
            }
        }
    }

}
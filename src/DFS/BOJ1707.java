package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ1707 {
    static int[] check; // 1과 0을 저장할 check 배열 (노드를 번갈아가면서 1과 0을 저장할 예정)
    static boolean[] visited; // 방문 배열
    static ArrayList<Integer>[] A; // 노드와 엣지를 저장할 배열
    static boolean isEven; // 이분 그래프 판별하는 boolean
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        for(int t=0; t<testCase; t++) {
            String[] s = br.readLine().split(" "); // split으로 노드와 엣지를 입력 받음
            int node = Integer.parseInt(s[0]);
            int edge = Integer.parseInt(s[1]);

            A = new ArrayList[node+1]; // 1부터 시작할 것이므로 node+1로 초기화
            visited = new boolean[node+1]; // 1부터 시작할 것이므로 node+1로 초기화
            check = new int[node+1]; // 1부터 시작할 것이므로 node+1로 초기화

            isEven = true; // true로 초기화

            for(int i=1; i<=node; i++) { // 노드와 엣지를 저장할 배열 초기화
                A[i] = new ArrayList<>();
            }

            for(int i=0; i<edge; i++) { // 양방향으로 매핑
                s = br.readLine().split(" ");
                int start = Integer.parseInt(s[0]);
                int end = Integer.parseInt(s[1]);

                A[start].add(end);
                A[end].add(start);
            }

            for(int i=1; i<=node; i++) { // 전체 노드에서 DFS 탐색
                if(isEven) {
                    DFS(i);
                }
                else { // 이분 그래프가 아니면 break로 빠져나옴
                    break;
                }
            }

            if(isEven) { // 이분 그래프라면 YES 출력
                System.out.println("YES");
            }

            else { // 그렇지 않다면 NO 출력
                System.out.println("NO");
            }
        }
    }

    private static void DFS(int node) {
        visited[node] = true; // 방문 배열 true로 변경
        for(int i : A[node]) { // 노드와 연결된 곳을 다 방문
            if(!visited[i]) { // 방문하지 않은 곳이면
                check[i] = (check[node] + 1) % 2; // 전에 탐색했던 노드가 1이면 0으로 저장하고, 0이면 1로 저장하기
                DFS(i); // DFS 수행
            }

            else { // 방문한 곳이면
                if(check[node] == check[i]) { // 만약 방문한 곳과 그전의 노드의 check값이 같으면
                    isEven = false; // 이분 그래프가 false이다.
                }
            }
        }
    }
}

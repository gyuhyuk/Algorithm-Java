package DFS;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ13023 {
    static boolean[] visited;
    static ArrayList<Integer>[] A;
    static boolean arrive;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        arrive = false; // 5 까지 도착 했는지는 처음에 false로 저장

        int N = scanner.nextInt();
        int M = scanner.nextInt();

        A = new ArrayList[N];

        visited = new boolean[N];

        for(int i=0; i<N; i++) {
            A[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<M; i++) {
            int S = scanner.nextInt(); // start
            int E = scanner.nextInt(); // end
            A[S].add(E); // 양방향으로 저장
            A[E].add(S); // 양방향으로 저장
        }

        for(int i=0; i<N; i++) {
            DFS(i, 1); // depth를 1부터 시작
            if(arrive) {
                break;
            }
        }

        if(arrive) {
            System.out.println(1);
        }
        else {
            System.out.println(0);
        }
    }

    public static void DFS(int now, int depth) {
        if(depth == 5 || arrive) { // 깊이가 5가 되거나, arrive가 true면
            arrive = true;
            return;
        }
        visited[now] = true; // 방문 노드를 true로 변경

        for(int i : A[now]) { // A[now]에 연결된 모든 노드를 탐색하는 것
            if(!visited[i]) { // 아직 방문하지 않은 노드면
                DFS(i, depth+1); // 재귀 호출, depth를 1증가시키면서
            }
        }
        visited[now] = false;
        // 이 부분이 없다면, 한 번 방문한 노드는 계속 방문된 상태로 남아 이후의 다른 경로 탐색에 지장을 줌
        // 예를 들어, 노드 A에서 B로 이동한 후, B에서 C로 이동하고 다시 B로 돌아오는 경로를 탐색할 때,
        // B가 이미 방문된 상태로 남아있다면 B를 다시 방문할 수 없게 됨
    }
}

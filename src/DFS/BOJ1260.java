package DFS;

import org.w3c.dom.Node;

import java.util.*;

public class BOJ1260 {
    static boolean[] visited;
    static ArrayList<Integer>[] A;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int Node = scanner.nextInt();
        int Edge = scanner.nextInt();
        int Start = scanner.nextInt();

        A = new ArrayList[Node+1]; // index가 0부터 시작이므로 +1을 해주자
        for(int i=1; i<Node+1; i++) { // 1번부터 노드 개수 까지
            A[i] = new ArrayList<>(); // 각각 배열 형태로 만들자
        }

        for(int i=0; i<Edge; i++) { // 양방향 엣지이므로
            int S = scanner.nextInt();
            int E = scanner.nextInt();

            A[S].add(E);
            A[E].add(S);
        }

        for(int i=1; i<Node+1; i++) {
            Collections.sort(A[i]); // 각각의 배열을 오름차순으로 정렬
        }

        visited = new boolean[Node+1]; // visited 배열 초기화
        DFS(Start); // DFS

        System.out.println();

        visited = new boolean[Node+1]; // visited 배열 초기화
        BFS(Start); // BFS

        System.out.println();
    }

    private static void BFS(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;

        while(!queue.isEmpty()) { // 큐가 빌때까지
            int now_node = queue.poll();
            System.out.print(now_node + " "); // 시작 노드 넣기
            for(int i : A[now_node]) { // 노드에서 갈 수 있는 곳을 순회하는 거라고 생각
                if(!visited[i]) { // 방문했던 곳이 아니라면
                    visited[i] = true; // 큐에 넣어주는 순간 방문 처리
                    queue.add(i); // 큐에 넣어줌
                }
            }
        }
    }

    private static void DFS(int node) {
        System.out.print(node + " "); // 처음 노드를 출력
        visited[node] = true; // 방문한 노드 true로 설정

        for(int i : A[node]) { // 현재 노드가 갈 수 있는 곳을 찾음
            if(!visited[i]) { // 방문한 곳이 아니라면
                DFS(i); // 재귀호출
            }
        }
    }
}

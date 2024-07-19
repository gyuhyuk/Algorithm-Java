package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1167 {
    static boolean[] visited; // 방문 배열
    static int[] distance; // 거리 배열
    static ArrayList<Edge>[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        A = new ArrayList[N+1]; // 인덱스를 1부터 사용하기 위해서

        for(int i=1; i<=N; i++) {
            A[i] = new ArrayList<Edge>(); // A 리스트 초기화
        }

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            while(true) {
                int E = Integer.parseInt(st.nextToken());
                if(E == -1) {
                    break;
                }
                int V = Integer.parseInt(st.nextToken());
                A[S].add(new Edge(E, V));
            }
        }

        distance = new int[N+1];
        visited = new boolean[N+1];

        BFS(1);
        int Max = 1; // 현재 Max인 노드 인덱스를 나타냄

        for(int i=2; i<=N; i++) { // distance 배열에서 가장 큰 값으로 다시 시작점 설정
            if(distance[Max] < distance[i]) {
                Max = i;
            }
        }

        distance = new int[N+1]; // distance 배열 초기화
        visited = new boolean[N+1]; // visited 배열 초기화

        BFS(Max); // Max인 것으로 BFS 한번 더 돌리기

        Arrays.sort(distance); // 거리 배열 오름차순 정렬
        System.out.println(distance[N]); // 오름차순이므로 거리 배열의 맨 마지막에 있는 것이 가장 큰 값이 된다
    }

    private static void BFS(int index) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(index);
        visited[index] = true;

        while(!queue.isEmpty()) {
            int now_node = queue.poll();
            for (Edge i : A[now_node]) { // 엣지들을 뽑아온다
                int e = i.e;
                int value = i.value;
                if(!visited[e]) {
                    visited[e] = true;
                    queue.add(e);
                    distance[e] = distance[now_node] + value; // 거리 배열을 전에 있던 노드에 거리를 더해준 것으로 업데이트
                }
            }
        }
    }
}

class Edge {
    int e;
    int value;

    public Edge(int e, int value) {
        this.e = e;
        this.value = value;
    }
}

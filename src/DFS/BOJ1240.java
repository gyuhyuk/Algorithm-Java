package DFS;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ1240 {
    static ArrayList<myEdge>[] A; // 인접 리스트
    static boolean[] visited; // 방문 배열
    static int distance;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // N
        int M = sc.nextInt(); // M

        A = new ArrayList[N+1];

        for(int i=1; i<N+1; i++) {
            A[i] = new ArrayList<>();
        }

        for(int i=0; i<N-1; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int value = sc.nextInt();

            A[start].add(new myEdge(end, value));
            A[end].add(new myEdge(start, value));
        }

        for(int i=0; i<M; i++) {
            distance = 0; // 거리 초기화
            visited = new boolean[N+1]; // 방문 배열 초기화

            int start = sc.nextInt();
            int end = sc.nextInt();

            visited[start] = true;
            DFS(start, end, 0);
            System.out.println(distance);
        }
    }

    private static void DFS(int start, int end, int sum) {
        if(start == end) {
            distance = sum;
            return;
        }
        for(myEdge myEdge : A[start]) {
            if(!visited[myEdge.e]) {
                visited[myEdge.e] = true;
                DFS(myEdge.e, end, sum + myEdge.value);
                visited[myEdge.e] = false;
            }
        }

    }
}

class myEdge {
    int e;
    int value;

    public myEdge(int e, int value) {
        this.e = e;
        this.value = value;
    }
}

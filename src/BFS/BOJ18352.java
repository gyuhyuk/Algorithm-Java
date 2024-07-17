package BFS;

import java.util.*;

public class BOJ18352 {
    static int[] visited;
    static ArrayList<Integer>[] A;
    static int N, M, K, X;
    static List<Integer> answer;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        K = scanner.nextInt();
        X = scanner.nextInt();

        A = new ArrayList[N+1];
        answer = new ArrayList<>();
        for(int i=1; i<=N; i++) {
            A[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<M; i++) {
            int S = scanner.nextInt();
            int E = scanner.nextInt();
            A[S].add(E);
        }

        visited = new int[N+1];
        for(int i=0; i<=N; i++) {
            visited[i] = -1;
        }
        BFS(X);
        for(int i=0; i<=N; i++) {
            if(visited[i] == K) {
                answer.add(i);
            }
        }
        if(answer.isEmpty()) {
            System.out.println("-1");
        }
        else {
            Collections.sort(answer);
            for(int temp : answer) {
                System.out.println(temp);
            }
        }
    }

    public static void BFS(int Node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(Node);
        visited[Node]++;
        while (!queue.isEmpty()) {
            int nowNode = queue.poll();
            for(int i : A[nowNode]) {
                if(visited[i] == -1) {
                    visited[i] = visited[nowNode] + 1;
                    queue.add(i);
                }
            }
        }
    }
}

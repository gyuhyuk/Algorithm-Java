package DFS;

import java.util.*;

public class BOJ1967 {
    static boolean[] visited;
    static int[] distance;
    static ArrayList<Edge>[] A;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int node = scanner.nextInt();

        A = new ArrayList[node + 1];

        for (int i = 1; i <= node; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < node - 1; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            int value = scanner.nextInt();

            A[start].add(new Edge(end, value));
            A[end].add(new Edge(start, value)); // 양방향 간선 추가
        }

        distance = new int[node + 1];
        visited = new boolean[node + 1];

        BFS(1);

        int Max = 1;
        for (int i = 2; i <= node; i++) {
            if (distance[Max] < distance[i]) {
                Max = i;
            }
        }

        distance = new int[node + 1];
        visited = new boolean[node + 1];

        BFS(Max);

        Arrays.sort(distance);
        System.out.println(distance[node]);
    }

    private static void BFS(int index) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(index);
        visited[index] = true;

        while (!queue.isEmpty()) {
            int now_node = queue.poll();
            for (Edge edge : A[now_node]) {
                int e = edge.e;
                int value = edge.value;
                if (!visited[e]) {
                    visited[e] = true;
                    queue.add(e);
                    distance[e] = distance[now_node] + value;
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

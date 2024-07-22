package DFS;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ2644 {
    static boolean[] visited;
    static ArrayList<Integer>[] A;
    static int startNode;
    static int endNode;
    static boolean find;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        find = false;

        int node = scanner.nextInt();

        startNode = scanner.nextInt();
        endNode = scanner.nextInt();

        int count = scanner.nextInt();

        visited = new boolean[node+1];
        A = new ArrayList[node+1];

        for(int i=1; i<=node; i++) {
            A[i] = new ArrayList<>();
        }

        for(int i=0; i<count; i++) {
            int s = scanner.nextInt();
            int e = scanner.nextInt();
            A[s].add(e);
            A[e].add(s);
        }
        DFS(startNode, 0);
        if (!find) {
            System.out.println("-1");
        }
    }

    private static void DFS(int now, int depth) {
        if(now == endNode) {
            find = true;
            System.out.println(depth);
        }
        else {
            visited[now] = true;
            for(int i : A[now]) {
                if(!visited[i]) {
                    DFS(i, depth+1);
                }
            }
        visited[now] = false;
        }
    }
}

package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ15591 {
    static int N, Q;
    static ArrayList<Node>[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        arr = new ArrayList[N+1];

        for(int i=1; i<=N; i++) {
            arr[i] = new ArrayList<>();
        }

        for(int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            arr[p].add(new Node(q, r)); // 양방향
            arr[q].add(new Node(p, r));
        }

        for(int i=0; i<Q; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken()); // 유사도
            int v = Integer.parseInt(st.nextToken()); // 노드

            int count = 0;

            Queue<Integer> queue = new LinkedList<>();
            visited = new boolean[N+1];

            visited[v] = true;
            queue.add(v);

            while (!queue.isEmpty()) {
                int now = queue.poll();

                List<Node> list = arr[now];

                for(int j=0; j<list.size(); j++) {
                    if(!visited[list.get(j).index] && list.get(j).cost >= k) {
                        count++;
                        queue.add(list.get(j).index);
                        visited[list.get(j).index] = true;
                    }
                }
            }
            sb.append(count + "\n");
        }
        System.out.println(sb);
    }

    static class Node {
        int index;
        int cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
    }
}

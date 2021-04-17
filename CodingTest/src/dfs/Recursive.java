package dfs;

import java.util.Scanner;

// https://www.youtube.com/watch?v=0Njv04WiLV0&t=102s
// DFS - 재귀호출
public class Recursive {
    static final int MAX_N = 10;
    static int N,E;
    static int[][] graph = new int[MAX_N][MAX_N];
    static  boolean[] visited = new boolean[MAX_N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();   // 노드의 갯수
        E = sc.nextInt();   // 간선(노드끼리 연결된 선

        // 연결된 노드끼리 정의
        for(int i = 0; i<E; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u][v] = graph[v][u] = 1;
        }

        dfs(0);
    }

    static void dfs(int node){
        visited[node] = true;
        System.out.println("방문한 노드 순서 : " + node);

        for(int next = 0; next < N; next++){
            if(!visited[next] && graph[node][next]!=0){
                dfs(next);
            }
        }
    }
}

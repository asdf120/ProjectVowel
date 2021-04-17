package dfs;

import java.util.*;

//DFS - 스택
public class Stack {
    static final int MAX_N = 10;
    static int N, E;
    static int[][] graph = new int[MAX_N][MAX_N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        E = sc.nextInt();
        for(int i = 0; i<E; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();

            graph[u][v] =  graph[v][u] = 1;
        }
        dfs(0);
    }

    static void dfs(int node){
        boolean[] visited = new boolean[MAX_N];

        java.util.Stack<Integer> stack = new java.util.Stack<>();
        stack.push(node);

        while(!stack.empty()){
            int curr = stack.pop();

            if(visited[curr]){
                continue;
            }

            visited[curr] = true;
            System.out.println("방문한 노드 순서 : " + curr);

            for(int next = 0; next<N; next++){
                if(!visited[next] && graph[curr][next] != 0){
                    stack.push(next);
                }
            }
        }
    }

}

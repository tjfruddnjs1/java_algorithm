package com.algorithm.Programmers.Search.DFS_BFS;

public class Network_2 {

    static boolean[] visited;

    public void dfs(int start, int[][] computers, int n) {
        visited[start] = true;

        for (int i = 0; i < n; i++) {
            if (computers[start][i] == 1 && !visited[i]) {
                dfs(i, computers, n);
            }
        }
    }

    public int solution(int n, int[][] computers) {
        visited = new boolean[n];

        int answer = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                answer++;
                dfs(i, computers, n);
            }
        }

        return answer;
    }
}

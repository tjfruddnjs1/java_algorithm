package com.algorithm.Programmers.Search.DFS_BFS;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Network {

    static boolean[] visited;
    static List<TreeMap<Integer, Integer>> adj;

    public static int solution(int n, int[][] computers) {
        int answer = 0;

        visited = new boolean[n];
        adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new TreeMap<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }

                if (computers[i][j] == 1) {
                    adj.get(i).put(j, i);
                    adj.get(j).put(i, j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                dfs(i);
                answer++;
            }
        }

        return answer;
    }

    public static void dfs(int start) {
        visited[start] = true;
        TreeMap<Integer, Integer> getAdjElements = adj.get(start);
        for (int i : getAdjElements.keySet()) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        solution(n, computers);
    }
}

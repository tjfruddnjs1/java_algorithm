package com.algorithm.Programmers.Search.DFS_BFS;

import java.util.Arrays;

public class ConvertWord {

    static boolean[] visited;
    static int answer;

    public static void dfs(String begin, String target, String[] words, int count) {
        int wordLength = begin.length();
        if (begin.equals(target)) {
            answer = count;
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (!visited[i]) {
                int matchCnt = 0;

                for (int j = 0; j < wordLength; j++) {
                    if (begin.charAt(j) == words[i].charAt(j)) {
                        matchCnt++;
                    }
                }

                if (matchCnt == wordLength - 1) {
                    visited[i] = true;
                    dfs(words[i], target, words, count+1);
                    visited[i] = false;
                }
            }
        }
    }

    public static int solution(String begin, String target, String[] words) {
        if (Arrays.stream(words).noneMatch(v -> v.equals(target))) {
            return 0;
        }

        visited = new boolean[words.length];

        dfs(begin, target, words, 0);

        return answer;
    }

    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

        System.out.println(solution(begin, target, words));
    }
}

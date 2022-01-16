package com.algorithm.BaekJoon.Search.DFS_BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class ConnectionCount_11724 {
    static int N;
    static int M;
    static ArrayList<TreeMap<Integer, Integer>> link;
    static boolean visited[];
    static int answer;

    public static void dfs(int start_vertex){
        visited[start_vertex] = true;
        TreeMap<Integer, Integer> getAdjElements = link.get(start_vertex);
        for(int i :getAdjElements.keySet()){
            if(!visited[i]){
                dfs(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        link = new ArrayList<>();

        for(int i=0;i<N+1;i++){
            link.add(new TreeMap<>());
        }

        visited = new boolean[N+1];
        answer = 0;

        for(int i=1;i<M+1;i++){
            st = new StringTokenizer(reader.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            link.get(start).put(end, start);
            link.get(end).put(start, end);
        }

        for(int i=1; i< N+1;i++){
            if(visited[i]) continue;

            dfs(i);
            answer++;
        }

        writer.write(String.valueOf(answer));
        writer.flush();
        writer.close();
        reader.close();
    }
}

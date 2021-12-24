package com.algorithm.Search;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class SolutionFrame_DFS {
  static boolean[] visited;
  static ArrayList<TreeMap<Integer, Integer>> arrayList;
  static int vertex,edge;

  public static void dfs(int start_vertex){
    visited[start_vertex] = true;
    TreeMap<Integer, Integer> getAdjElements = arrayList.get(start_vertex);
    for(int i : getAdjElements.keySet()){
      if(!visited[i]){
        dfs(i);
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(reader.readLine());

    vertex = Integer.parseInt(st.nextToken());
    edge = Integer.parseInt(reader.readLine());
    visited = new boolean[vertex+1];
    arrayList = new ArrayList<>();

    for(int i=0;i<vertex+1;i++){
      arrayList.add(new TreeMap<Integer,Integer>());
    }

    for(int i=0;i<edge;i++){
      st = new StringTokenizer(reader.readLine());
      int vertex_1 = Integer.parseInt(st.nextToken());
      int vertex_2 = Integer.parseInt(st.nextToken());
      arrayList.get(vertex_1).put(vertex_2, vertex_1);
      arrayList.get(vertex_2).put(vertex_1, vertex_2);
    }

    dfs(1);

    writer.flush();
    writer.close();
    reader.close();
  }
}

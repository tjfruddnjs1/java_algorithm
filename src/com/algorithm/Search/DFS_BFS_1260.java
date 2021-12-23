package com.algorithm.Search;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class DFS_BFS_1260 {
  static int[][] map;
  static boolean[] visited;
  static ArrayList<TreeMap<Integer, Integer>> arrayList;
  static int vertex, edge, start_vertex;

  public static void dfs(int start_vertex){
    visited[start_vertex] = true;
    System.out.print(start_vertex+" ");
    TreeMap<Integer, Integer> getAdjElements = arrayList.get(start_vertex);
    for(int i : getAdjElements.keySet()){
      if(!visited[i]) {
        dfs(i);
      }
    }
  }

  public static void bfs(int start_vertex){
    Queue<Integer> queue = new LinkedList<Integer>();
    queue.offer(start_vertex);
    visited[start_vertex] = true;

    while(!queue.isEmpty()){
      int temp = queue.poll();
      System.out.print(temp+" ");

      for(int i=1;i<=vertex;i++){
        if(map[temp][i] == 1 && !visited[i]){
          queue.offer(i);
          visited[i] = true;
        }
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(reader.readLine());
    vertex = Integer.parseInt(st.nextToken());
    edge = Integer.parseInt(st.nextToken());
    start_vertex = Integer.parseInt(st.nextToken());
    map = new int[vertex+1][vertex+1];
    visited = new boolean[vertex+1];
    arrayList = new ArrayList<>();

    for(int i=0;i<vertex+1;i++){
      Arrays.fill(map[i], 0);
      arrayList.add(new TreeMap<Integer, Integer>());
    }

    Arrays.fill(visited,false);

    for(int i = 0; i < edge ; i++){
      st = new StringTokenizer(reader.readLine());
      int vertex_1 = Integer.parseInt(st.nextToken());
      int vertex_2 = Integer.parseInt(st.nextToken());
      map[vertex_1][vertex_2] = 1;
      map[vertex_2][vertex_1] = 1;
      arrayList.get(vertex_1).put(vertex_2, vertex_1);
      arrayList.get(vertex_2).put(vertex_1, vertex_2);
    }

    dfs(start_vertex);
    System.out.println();

    Arrays.fill(visited,false);
    bfs(start_vertex);

    writer.flush();
    writer.close();
    reader.close();
  }
}

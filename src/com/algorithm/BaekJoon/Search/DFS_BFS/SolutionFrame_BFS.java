package com.algorithm.BaekJoon.Search.DFS_BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SolutionFrame_BFS {
  static int[][] map;
  static boolean[][] visited;
  static int vertex;
  static int width;
  static int height;
  static int[] direction_x = {-1, 1, 0, 0};
  static int[] direction_y = {0, 0, -1, 1};

  public static void bfs(int x, int y) {
    Queue<int[]> queue = new LinkedList<>();
    queue.offer(new int[]{x, y});
    visited[y][x] = true;

    while(!queue.isEmpty()){
      int[] now = queue.poll();
      int nowX = now[0];
      int nowY = now[1];

      for(int i=0;i<4;i++){
        int nextX = nowX + direction_x[i];
        int nextY = nowY + direction_y[i];
        if(nextX < 0 || nextY < 0 || nextX >= width || nextY >= height) continue;
        if(visited[nextY][nextX] || map[nextY][nextX] == 0) continue;

        queue.offer(new int[]{nextX, nextY});
        map[nextY][nextX]++;
        visited[nextY][nextX] = true;
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(reader.readLine());
    width = Integer.parseInt(st.nextToken());
    height = Integer.parseInt(st.nextToken());
    vertex = Integer.parseInt(st.nextToken());

    visited = new boolean[height][width];
    map = new int[height][width];

    for(int i=0;i<vertex;i++){
      st = new StringTokenizer(reader.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());

      map[y][x] = 1;
    }

    for(int i=0;i<width;i++){
      for(int j=0;j<height;j++){
        if(map[j][i] == 1){
          bfs(i,j);
        }
      }
    }

    writer.flush();
    writer.close();
    reader.close();
  }
}

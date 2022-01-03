package com.algorithm.BaekJoon.Search.DFS_BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Tomato_7576 {
  static int[][] map;
  static boolean[][] visited;
  static int width;
  static int height;
  static int maxDays = 1;
  static Queue<int[]> queue;
  static int[] direction_x = {-1, 1, 0, 0};
  static int[] direction_y = {0, 0, -1, 1};

  public static void bfs() {
    while(!queue.isEmpty()){
      int[] now = queue.poll();
      int nowX = now[0];
      int nowY = now[1];

      for(int i=0;i<4;i++){
        int nextX = nowX + direction_x[i];
        int nextY = nowY + direction_y[i];
        if(nextX < 0 || nextY < 0 || nextX >= width || nextY >= height) continue;
        if(visited[nextY][nextX] || map[nextY][nextX] == -1) continue;

        queue.offer(new int[]{nextX, nextY});
        map[nextY][nextX] = map[nowY][nowX] + 1;
        maxDays = Math.max(maxDays, map[nowY][nowX] + 1);
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

    visited = new boolean[height][width];
    map = new int[height][width];
    queue = new LinkedList<>();

    for(int i=0;i<height;i++){
      st = new StringTokenizer(reader.readLine());
      for(int j=0;j<width;j++){
        map[i][j] = Integer.parseInt(st.nextToken());
        if(map[i][j] == 1) {
          queue.offer(new int[]{j, i});
          visited[i][j] = true;
        }
      }
    }

    bfs();

    boolean hasUnreachableData = Arrays.stream(map).flatMapToInt(Arrays::stream).anyMatch(v -> v == 0);

    if(hasUnreachableData) writer.write(String.valueOf(-1));
    else writer.write(String.valueOf(maxDays-1));

    writer.flush();
    writer.close();
    reader.close();
  }
}

package com.algorithm.Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Maze_2178 {
  static int[][] map;
  static boolean[][] visited;
  static int row;
  static int col;
  static int[] direction_x = {-1, 1, 0, 0};
  static int[] direction_y = {0, 0, -1, 1};

  public static void bfs(int x, int y){
    Queue<int[]> queue = new LinkedList<>();
    queue.offer(new int[]{x,y});

    while(!queue.isEmpty()){
      int[] now = queue.poll();
      int nowX = now[0];
      int nowY = now[1];

      for(int i=0;i<4;i++){
        int nextX = nowX + direction_x[i];
        int nextY = nowY + direction_y[i];

        if(nextX < 0 || nextY < 0 || nextX >= row || nextY >= col) continue;
        if(visited[nextX][nextY] || map[nextX][nextY] == 0) continue;

        queue.offer(new int[]{nextX, nextY});
        map[nextX][nextY] = map[nowX][nowY] + 1;
        visited[nextX][nextY] = true;
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(reader.readLine());
    row = Integer.parseInt(st.nextToken());
    col = Integer.parseInt(st.nextToken());
    map = new int[row][col];

    for(int i=0;i<row;i++){
      char[] i_row = reader.readLine().toCharArray();
      for(int j=0;j<col;j++){
        map[i][j] = Character.getNumericValue(i_row[j]);
      }
    }

    visited = new boolean[row][col];
    visited[0][0] = true;
    bfs(0,0);

    System.out.println(map[row-1][col-1]);
  }
}

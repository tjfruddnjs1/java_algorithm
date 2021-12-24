package com.algorithm.Search;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class ApartmentComplex_2667 {
  static int[][] map;
  static boolean[][] visited;
  static int side;
  static int[] direction_x = {-1,1,0,0};
  static int[] direction_y = {0,0,-1,1};
  static List<Integer> answer;

  public static void bfs(int x, int y, int count){
    Queue<int[]> queue = new LinkedList<>();
    queue.offer(new int[]{x, y});

    while(!queue.isEmpty()){
      int[] now = queue.poll();
      int nowX = now[0];
      int nowY = now[1];
      count++;

      for(int i=0;i<4;i++) {
        int nextX = nowX + direction_x[i];
        int nextY = nowY + direction_y[i];

        if (nextX < 0 || nextY < 0 || nextX >= side || nextY >= side)
          continue;
        if (visited[nextX][nextY] || map[nextX][nextY] == 0)
          continue;

        queue.offer(new int[]{nextX, nextY});
        map[nextX][nextY] = map[nowX][nowY] + 1;
        visited[nextX][nextY] = true;
      }

      if(queue.isEmpty()) {
        answer.add(count);
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(reader.readLine());

    side = Integer.parseInt(st.nextToken());
    map = new int[side][side];
    visited = new boolean[side][side];
    answer = new ArrayList<>();

    for(int i=0;i<side;i++){
      char[] row = reader.readLine().toCharArray();
      for(int j=0;j<side;j++){
        map[i][j] = Character.getNumericValue(row[j]);
      }
    }

    for(int i=0;i<side;i++){
      for(int j=0;j<side;j++){
        if(map[i][j]==1){
          visited[i][j] = true;
          bfs(i,j,0);
        }
      }
    }

    Collections.sort(answer);

    writer.write(String.valueOf(answer.size()));
    writer.newLine();
    for (Integer i : answer) {
      writer.write(String.valueOf(i));
      writer.newLine();
    }

    writer.flush();
    writer.close();
    reader.close();
  }
}

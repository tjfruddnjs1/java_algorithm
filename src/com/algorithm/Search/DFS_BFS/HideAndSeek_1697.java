package com.algorithm.Search.DFS_BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class HideAndSeek_1697 {
    static int[] map;
    static boolean[] visited;
    static int inputX;
    static int purposeX;
    static int maxSize;
    static int[] direction_x = {-1, 1};

    public static int bfs(int x){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);
        map[x] = 1;
        visited[x] = true;

        while(!queue.isEmpty()){
            int nowX = queue.poll();
            if(nowX == purposeX) break;

            for(int i=0;i<3;i++){
                int nextX;
                if(i == 2) nextX = nowX * 2;
                else nextX = nowX + direction_x[i];

                if(nextX < 0 || nextX >= maxSize) continue;
                if(visited[nextX]) continue;

                queue.offer(nextX);
                map[nextX] += map[nowX] + 1;
                visited[nextX] = true;
            }
        }

        return map[purposeX] - 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        inputX = Integer.parseInt(st.nextToken());
        purposeX = Integer.parseInt(st.nextToken());

        maxSize = Math.max((inputX*2)+1 ,(purposeX*2) +1);

        map = new int[maxSize];
        visited = new boolean[maxSize];

        writer.write(String.valueOf(bfs(inputX)));
        writer.flush();
        writer.close();
        reader.close();
    }
}

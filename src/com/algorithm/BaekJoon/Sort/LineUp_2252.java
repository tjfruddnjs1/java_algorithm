package com.algorithm.BaekJoon.Sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class LineUp_2252 {

    static int num_size;
    static int info_size;
    static List<List<Integer>> info;
    static int[] inDegree;
    static StringBuilder answer;

    public static void solution() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 1; i <= num_size; i++) {
            if (inDegree[i] == 0) {
                pq.offer(i);
            }
        }

        while (!pq.isEmpty()) {
            int num = pq.poll();
            answer.append(num).append(" ");

            for (Integer i : info.get(num)) {
                inDegree[i]--;

                if (inDegree[i] == 0) {
                    pq.offer(i);
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        num_size = Integer.parseInt(st.nextToken());
        info_size = Integer.parseInt(st.nextToken());

        inDegree = new int[num_size + 1];
        info = new ArrayList<>();
        answer = new StringBuilder();

        for (int i = 0; i <= num_size; i++) {
            info.add(new ArrayList<>());
        }

        for (int i = 0; i < info_size; i++) {
            st = new StringTokenizer(reader.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            info.get(v1).add(v2);
            inDegree[v2]++;
        }

        solution();

        writer.write(answer.toString());
        writer.flush();
        writer.close();
        reader.close();
    }
}

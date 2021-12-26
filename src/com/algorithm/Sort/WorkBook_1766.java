package com.algorithm.Sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class WorkBook_1766 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int input = Integer.parseInt(st.nextToken());
        int info_count = Integer.parseInt(st.nextToken());

        int[] inDegree = new int[input + 1];
        ArrayList<ArrayList<Integer>> map = new ArrayList<>();

        for (int i = 0; i <= input; i++) {
            map.add(new ArrayList<>());
        }

        for (int i = 0; i < info_count; i++) {
            st = new StringTokenizer(reader.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            map.get(v1).add(v2);
            inDegree[v2]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= input; i++) {
            if (inDegree[i] == 0) {
                pq.offer(i);
            }
        }

        while (!pq.isEmpty()) {
            int node = pq.poll();
            sb.append(node).append(" ");

            for (int i : map.get(node)) {
                inDegree[i]--;

                if(inDegree[i] == 0){
                    pq.offer(i);
                }
            }
        }

        writer.write(sb.toString());
        writer.flush();
        writer.close();
        reader.close();
    }
}

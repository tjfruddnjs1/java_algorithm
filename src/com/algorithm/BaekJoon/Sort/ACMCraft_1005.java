package com.algorithm.BaekJoon.Sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class ACMCraft_1005 {

    static int node;
    static int edge;
    static int[] map;

    public static int solution(int[] inDegree, List<List<Integer>> map_info, int purpose_num) {
        Queue<Integer> queue = new LinkedList<>();
        int[] result = new int[node+1];

        for (int i = 1; i <= node; i++) {
            result[i] = map[i];

            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int num = queue.poll();

            for (Integer i : map_info.get(num)) {
                result[i] = Math.max(result[i], result[num] + map[i]);
                inDegree[i]--;

                if (inDegree[i] == 0) {
                    queue.offer(i);
                }
            }
        }

        return result[purpose_num];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int test_case = Integer.parseInt(reader.readLine());

        for (int test = 0; test < test_case; test++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());

            node = Integer.parseInt(st.nextToken());
            edge = Integer.parseInt(st.nextToken());
            map = new int[node + 1];

            List<List<Integer>> map_info = new ArrayList<>();

            for (int i = 0; i < node + 1; i++) {
                map_info.add(new ArrayList<>());
            }

            st = new StringTokenizer(reader.readLine());

            for (int i = 1; i <= node; i++) {
                map[i] = Integer.parseInt(st.nextToken());
            }

            int[] inDegree = new int[node + 1];

            for (int i = 0; i < edge; i++) {
                st = new StringTokenizer(reader.readLine());
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());

                map_info.get(v1).add(v2);
                inDegree[v2]++;
            }

            int purpose_num = Integer.parseInt(reader.readLine());

            writer.write(String.valueOf(solution(inDegree, map_info, purpose_num)));
            writer.newLine();
        }

        writer.flush();
        writer.close();
        reader.close();
    }
}

package com.algorithm.Programmers.Search.Binary;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SteppingStone {

    public static long solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        return binarySearch(distance, rocks, n);
    }

    public static long binarySearch(int distance, int[] rocks, int n) {
        long low = 1;
        long high = distance;
        long answer = 0;

        while (low <= high) {
            long mid = (low + high) / 2;
            int cnt = 0;
            int prev = 0;

            for (int rock : rocks) {
                if (rock - prev < mid) {
                    cnt++;
                } else {
                    prev = rock;
                }
            }

            if (distance - rocks[rocks.length - 1] < mid) {
                cnt++;
            }

            if (cnt <= n) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int distance = Integer.parseInt(reader.readLine());
        int rockSize = Integer.parseInt(reader.readLine());
        int[] rocks = new int[rockSize];

        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < rockSize; i++) {
            rocks[i] = Integer.parseInt(st.nextToken());
        }

        int n = Integer.parseInt(reader.readLine());

        solution(distance, rocks, n);

        writer.flush();
        writer.close();
        reader.close();
    }

}

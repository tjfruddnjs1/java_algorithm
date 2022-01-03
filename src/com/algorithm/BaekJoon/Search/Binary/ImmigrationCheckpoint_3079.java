package com.algorithm.BaekJoon.Search.Binary;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class ImmigrationCheckpoint_3079 {

    static int N;
    static long M;
    static long[] T;

    public static long binarySearch(long low, long high) {
        while (low <= high) {
            long mid = (low + high) / 2;
            long sum = 0;

            for (long t : T) {
                sum += mid / t;
            }

            if (sum >= M) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Long.parseLong(st.nextToken());
        T = new long[N];

        long max = 0;

        for (int i = 0; i < N; i++) {
            T[i] = Integer.parseInt(reader.readLine());
            max = Math.max(max, T[i]);
        }

        writer.write(String.valueOf(binarySearch(1, max * M)));
        writer.flush();
        writer.close();
        reader.close();
    }
}

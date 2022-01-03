package com.algorithm.BaekJoon.Search.Binary;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Game_1072 {

    static long X;
    static long Y;
    static long Z;

    public static long binarySearch(long low, long high) {
        while (low <= high) {
            long mid = (low + high) / 2;
            long percentage = getPercentage(X + mid, Y + mid);
            if (percentage > Z) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    public static long getPercentage(long x, long y) {
        return y * 100 / x;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        X = Long.parseLong(st.nextToken());
        Y = Long.parseLong(st.nextToken());
        Z = getPercentage(X, Y);

        if (Z >= 99) {
            writer.write("-1");
        } else {
            writer.write(String.valueOf(binarySearch(1, X)));
        }
        writer.flush();
        writer.close();
        reader.close();
    }

}

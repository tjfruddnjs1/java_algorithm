package com.algorithm.BaekJoon.Search.Binary;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class GuitarLesson_2343 {

    static int[] lessons;
    static int parse;

    public static int binarySearch(int low, int high) {
        while (low <= high) {
            int mid = (low + high) / 2;
            int sum = 0;
            int cnt = 0;

            for (int lesson : lessons) {
                if (lesson + sum > mid) {
                    sum = 0;
                    cnt++;
                }
                sum += lesson;
            }
            if(sum != 0) cnt++;

            if (cnt > parse) {
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
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int input = Integer.parseInt(st.nextToken());
        parse = Integer.parseInt(st.nextToken());
        lessons = new int[input];

        st = new StringTokenizer(reader.readLine());
        int low = 0;
        for (int i = 0; i < input; i++) {
            lessons[i] = Integer.parseInt(st.nextToken());
            low = Math.max(low, lessons[i]);
        }

        int high = Arrays.stream(lessons).sum();
        writer.write(String.valueOf(binarySearch(low, high)));
        writer.flush();
        writer.close();
        reader.close();
    }

}

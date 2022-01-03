package com.algorithm.BaekJoon.Search.Binary;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class KingOfMemorization_2776 {

    static int input;
    static int[] input_array;

    public static int binarySearch(int key, int low, int high) {
        while (low <= high) {
            int mid = (low + high) / 2;

            if (key == input_array[mid]) {
                return 1;
            } else if (key > input_array[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int testcase = Integer.parseInt(reader.readLine());

        while (testcase != 0) {
            input = Integer.parseInt(reader.readLine());
            input_array = new int[input];

            StringTokenizer st = new StringTokenizer(reader.readLine());
            for (int i = 0; i < input; i++) {
                input_array[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(input_array);

            int find = Integer.parseInt(reader.readLine());

            st = new StringTokenizer(reader.readLine());
            for (int i = 0; i < find; i++) {
                writer.write(String.valueOf(binarySearch(Integer.parseInt(st.nextToken()), 0, input_array.length - 1)));
                writer.newLine();
            }

            testcase--;
        }

        writer.flush();
        writer.close();
        reader.close();
    }
}

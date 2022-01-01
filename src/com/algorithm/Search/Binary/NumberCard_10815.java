package com.algorithm.Search.Binary;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NumberCard_10815 {

    static int input;
    static int find;
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
        input = Integer.parseInt(reader.readLine());
        input_array = new int[input];

        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < input; i++) {
            input_array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(input_array);

        find = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();

        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < find; i++) {
            answer.append(binarySearch(Integer.parseInt(st.nextToken()), 0, input_array.length - 1)).append(" ");
        }

        writer.write(answer.toString());
        writer.flush();
        writer.close();
        reader.close();
    }
}

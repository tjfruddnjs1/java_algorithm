package com.algorithm.Greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Treasure_1026 {

    static int input;
    static int[] A;
    static Integer[] B;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        input = Integer.parseInt(reader.readLine());

        A = new int[input];
        B = new Integer[input];

        StringTokenizer st = new StringTokenizer(reader.readLine());

        for (int i = 0; i < input; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);

        st = new StringTokenizer(reader.readLine());

        for (int i = 0; i < input; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(B, Collections.reverseOrder());

        for (int i = 0; i < input; i++) {
            answer += A[i] * B[i];
        }

        writer.write(String.valueOf(answer));
        writer.flush();
        writer.close();
        reader.close();
    }

}

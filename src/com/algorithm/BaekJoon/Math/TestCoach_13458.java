package com.algorithm.BaekJoon.Math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class TestCoach_13458 {

    static int input;
    static float[] student;
    static float first;
    static float second;
    static long answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        input = Integer.parseInt(reader.readLine());
        student = new float[input];

        StringTokenizer st = new StringTokenizer(reader.readLine());

        for (int i = 0; i < input; i++) {
            student[i] = Float.parseFloat(st.nextToken());
        }

        st = new StringTokenizer(reader.readLine());
        first = Float.parseFloat(st.nextToken());
        second = Float.parseFloat(st.nextToken());

        for (int i = 0; i < input; i++) {
            if (student[i] == 0) {
                continue;
            }

            student[i] -= first;
            answer++;
            if (student[i] / second > 0) {
                answer += Math.ceil(student[i] / second);
            }
        }

        writer.write(String.valueOf(answer));
        writer.flush();
        writer.close();
        reader.close();
    }
}

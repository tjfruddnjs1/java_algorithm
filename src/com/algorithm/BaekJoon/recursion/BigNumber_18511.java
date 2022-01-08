package com.algorithm.BaekJoon.recursion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BigNumber_18511 {

    static int N;
    static int K;
    static int[] nums;
    static int answer;

    public static void solution(int now) {
        if (now > N) {
            return;
        }

        if (answer < now) {
            answer = now;
        }

        for (int i = K - 1; i > -1; i--) {
            solution(10 * now + nums[i]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(reader.readLine());
        nums = new int[K];

        for (int i = 0; i < K; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        solution(0);

        writer.write(String.valueOf(answer));
        writer.flush();
        writer.close();
        reader.close();
    }

}

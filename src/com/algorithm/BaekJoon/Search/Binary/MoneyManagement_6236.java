package com.algorithm.BaekJoon.Search.Binary;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MoneyManagement_6236 {

    static int T;
    static int A;
    static int B;
    static int[] array_A;
    static int[] array_B;
    static int answer;

    public static void solution() {
        for(int i=0;i<A;i++){
            for(int j=B-1;j>=0;j--){
                if(array_A[i] > array_B[j]){
                    answer += j+1;
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(reader.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());

            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            array_A = new int[A];
            array_B = new int[B];
            answer = 0;

            st = new StringTokenizer(reader.readLine());

            for (int j = 0; j < A; j++) {
                array_A[j] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(reader.readLine());

            for (int j = 0; j < B; j++) {
                array_B[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(array_B);
            solution();

            writer.write(String.valueOf(answer));
            writer.newLine();
        }

        writer.flush();
        writer.close();
        reader.close();
    }

}

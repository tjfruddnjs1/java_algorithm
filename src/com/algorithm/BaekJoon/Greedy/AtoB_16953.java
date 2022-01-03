package com.algorithm.BaekJoon.Greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class AtoB_16953 {
    static long inputX;
    static long purposeX;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        inputX = Long.parseLong(st.nextToken());
        purposeX = Long.parseLong(st.nextToken());
        answer = 1;

        while(purposeX != inputX){
            if(purposeX < inputX) {
                answer = -1;
                break;
            }

            int unit = (int)(purposeX % 10);

            if(unit != 1 && purposeX % 2 != 0){
                answer = -1;
                break;
            }

            if(purposeX % 2 == 0) purposeX /= 2;
            else purposeX /= 10;
            answer++;
        }

        writer.write(String.valueOf(answer));
        writer.flush();
        writer.close();
        reader.close();
    }
}

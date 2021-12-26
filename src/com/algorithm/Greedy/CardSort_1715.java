package com.algorithm.Greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class CardSort_1715 {
    static int input;
    static PriorityQueue<Integer> card;
    static int answer;

    public static void solution(){
        while(card.size() >= 2){
            int first = card.poll();
            int second = card.poll();

            answer += first+second;
            card.offer(first+second);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        input = Integer.parseInt(reader.readLine());
        card = new PriorityQueue<>();
        answer = 0;

        for(int i =0;i<input;i++){
            card.offer(Integer.parseInt(reader.readLine()));
        }

        solution();

        writer.write(String.valueOf(answer));
        writer.flush();
        writer.close();
        reader.close();
    }
}

package com.algorithm.BaekJoon.Search.Binary;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Budget_2512 {
    static int[] budgets;
    static long whole_budget;
    static long answer;

    public static void binarySearch(long low, long high){
        while(low <= high){
            long mid = (low + high) / 2;
            long sum = 0;
            for(int budget : budgets){
                if(budget > mid) sum += mid;
                else sum += budget;
            }

            if(sum > whole_budget) high = mid - 1;
            else {
                low = mid + 1;
                answer = Math.max(answer, mid);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int input = Integer.parseInt(reader.readLine());
        budgets = new int[input];

        StringTokenizer st = new StringTokenizer(reader.readLine());
        long low = 0;
        long high = 0;
        for(int i=0;i<input;i++){
            budgets[i] = Integer.parseInt(st.nextToken());
            high = Math.max(budgets[i], high);
        }

        whole_budget= Long.parseLong(reader.readLine());
        binarySearch(low, high);
        writer.write(String.valueOf(answer));
        writer.flush();
        writer.close();
        reader.close();
    }
}

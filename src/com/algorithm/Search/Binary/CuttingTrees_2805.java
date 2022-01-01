package com.algorithm.Search.Binary;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class CuttingTrees_2805 {

    static int input;
    static int[] trees;
    static int purpose;

    public static int binarySearch(int low, int high) {
        while (low < high) {
            int mid = (low + high) / 2;
            long sum = 0;

            for (int tree : trees) {
                if (tree - mid > 0) {
                    sum += (tree-mid);
                }
            }

            if (sum < purpose) {
                high = mid;
            } else {
                low = mid+1;
            }
        }

        return low-1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        input = Integer.parseInt(st.nextToken());
        purpose = Integer.parseInt(st.nextToken());

        trees = new int[input];
        int low = 0;
        int high = 0;

        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < input; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            high = Math.max(trees[i], high);
        }

        writer.write(String.valueOf(binarySearch(low, high)));

        writer.flush();
        writer.close();
        reader.close();
    }
}

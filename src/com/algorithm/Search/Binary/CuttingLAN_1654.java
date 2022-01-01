package com.algorithm.Search.Binary;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class CuttingLAN_1654 {

    static int input;
    static int purpose;
    static int[] lines;

    public static long binarySearch(long low, long high) {
        /* mid 0인 경우 고려 */
        high++;

        while (low < high) {
            long mid = (low + high) / 2;
            int sum = 0;

            for (int line : lines) {
                sum += line / mid;
            }

            if (sum < purpose) {
                high = mid;
            } else {
                low = mid + 1;
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

        lines = new int[input];
        long low = 0;
        long high = 0;

        for (int i = 0; i < input; i++) {
            lines[i] = Integer.parseInt(reader.readLine());
            high = Math.max(lines[i], high);
        }

        writer.write(String.valueOf(binarySearch(low, high)));

        writer.flush();
        writer.close();
        reader.close();
    }
}

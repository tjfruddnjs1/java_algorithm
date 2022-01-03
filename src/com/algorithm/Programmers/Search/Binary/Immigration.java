package com.algorithm.Programmers.Search.Binary;

import java.util.Arrays;

public class Immigration {

    public long solution(int n, int[] times) {
        Arrays.sort(times);

        long low = 1;
        long high = (long) times[times.length - 1] * n;

        while (low <= high) {
            long mid = (low + high) / 2;
            long sum = 0;

            for (long time : times) {
                sum += mid / time;
            }

            if (sum >= n) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}

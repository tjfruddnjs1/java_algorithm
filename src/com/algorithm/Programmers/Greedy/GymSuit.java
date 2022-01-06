package com.algorithm.Programmers.Greedy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicInteger;

public class GymSuit {

    public int solution(int n, int[] lost, int[] reserve) {
        AtomicInteger prev = new AtomicInteger(n - lost.length);
        HashSet<Integer> set = new HashSet<>();
        Arrays.stream(reserve).forEach(set::add);

        for (int i = 0; i < lost.length; i++) {
            if (set.contains(lost[i])) {
                prev.getAndIncrement();
                set.remove(lost[i]);
                lost[i] = -1;
            }
        }

        Arrays.sort(lost);

        for (int v : lost) {
            if (set.contains(v - 1)) {
                set.remove(v - 1);
                prev.getAndIncrement();
                continue;
            } else if (set.contains(v + 1)) {
                set.remove(v + 1);
                prev.getAndIncrement();
            }
        }

        return prev.get();
    }
}

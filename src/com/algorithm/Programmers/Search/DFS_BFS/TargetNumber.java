package com.algorithm.Programmers.Search.DFS_BFS;

public class TargetNumber {

    public static int solution(int[] numbers, int target) {

        return dfs(0, 0, numbers, target);
    }

    public static int dfs(int sum, int depth, int[] numbers, int target) {
        if (depth == numbers.length) {
            if (sum == target) {
                return 1;
            } else {
                return 0;
            }
        } else {
            return dfs(sum + numbers[depth], depth + 1, numbers, target)
                + dfs(sum - numbers[depth], depth + 1, numbers, target);
        }
    }

    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(solution(numbers, target));
    }
}

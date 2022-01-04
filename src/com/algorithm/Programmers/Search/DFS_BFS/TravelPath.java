package com.algorithm.Programmers.Search.DFS_BFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TravelPath {

    public static List<String> answers;
    public static boolean[] visited;

    public static void dfs(String[][] tickets, String present, String answer, int count) {
        if(count == tickets.length){
            answers.add(answer);
            return;
        }

        for(int i=0;i<tickets.length;i++){
            if(!visited[i] && tickets[i][0].equals(present)){
                visited[i] = true;
                dfs(tickets, tickets[i][1],answer + " " + tickets[i][1], count+1);
                visited[i] = false;
            }
        }
    }

    public static String[] solution(String[][] tickets) {
        answers = new ArrayList<>();
        visited = new boolean[tickets.length];

        dfs(tickets, "ICN", "ICN", 0);

        Collections.sort(answers);
        return answers.get(0).split(" ");
    }


    public static void main(String[] args) {
        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};

        solution(tickets);
    }
}

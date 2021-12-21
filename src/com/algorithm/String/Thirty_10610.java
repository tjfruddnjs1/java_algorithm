package com.algorithm.String;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Thirty_10610 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();

    List<Integer> input_array = new ArrayList<>();
    for(int i=0;i<input.length();i++){
      input_array.add(Character.getNumericValue(input.charAt(i)));
    }

    boolean is_10_divided = input_array.contains(0);
    boolean is_3_divided = input_array.stream().mapToInt(v-> v).sum() % 3 == 0;

    if (!(is_10_divided && is_3_divided)) {
      System.out.println(-1);
    }else{
      input_array.sort(Collections.reverseOrder());
      System.out.println(input_array.stream().map(String::valueOf).collect(Collectors.joining("")));
    }
  }
}
package com.algorithm.String;

import java.util.List;
import java.util.Scanner;

public class KMP_2902 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();

    List<String> split_input = List.of(input.split("-"));

    for (String str : split_input) {
      System.out.print(str.charAt(0));
    }
  }
}

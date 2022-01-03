package com.algorithm.BaekJoon.String;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Alphabet_10808 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();

    int[] alphabet_number = new int[26];
    char[] alphabet = input.toCharArray();

    for(char alpha : alphabet){
      alphabet_number[Character.getNumericValue(alpha)-10]++;
    }

    IntStream stream = Arrays.stream(alphabet_number);
    stream.forEach(v -> System.out.print(v+" "));
  }
}

package com.algorithm.BaekJoon.Stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Explosion_9935 {

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    StringBuilder answer = new StringBuilder();
    char[] input = reader.readLine().toCharArray();

    String explosion_word = reader.readLine();
    char explosion_last_word = explosion_word.charAt(explosion_word.length() - 1);

    for (char c : input) {
      answer.append(c);

      if (c == explosion_last_word) {
        if (answer.length() >= explosion_word.length()) {
          String confirmWord = answer.substring(answer.length() - explosion_word.length());

          if (confirmWord.equals(explosion_word)) {
            answer.delete(answer.length() - explosion_word.length(), answer.length());
          }
        }
      }
    }

    if(answer.length() == 0) writer.write("FRULA");
    else writer.write(answer.toString());

    writer.flush();
    writer.close();
    reader.close();
  }
}

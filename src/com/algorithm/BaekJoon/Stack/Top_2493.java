package com.algorithm.BaekJoon.Stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

class Top {

  int num;
  int height;

  Top(int num, int height) {
    this.num = num;
    this.height = height;
  }
}

public class Top_2493 {

  public static void main(String[] args) throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    int N = Integer.parseInt(reader.readLine());
    StringTokenizer st = new StringTokenizer(reader.readLine());

    Stack<Top> stack = new Stack<>();
    StringBuilder answer = new StringBuilder();

    for (int i = 1; i <= N; i++) {
      int height = Integer.parseInt(st.nextToken());
      if (stack.empty()) {
        answer.append("0 ");
        stack.push(new Top(i, height));
      } else {
        while (true) {
          if (stack.empty()) {
            answer.append("0 ");
            stack.push(new Top(i, height));
            break;
          }

          Top top = stack.peek();

          if (top.height > height) {
            answer.append(top.num).append(" ");
            stack.push(new Top(i, height));
            break;
          } else {
            stack.pop();
          }
        }
      }
    }
    writer.write(answer.toString() + "\n");
    writer.flush();
    writer.close();
    reader.close();
  }
}

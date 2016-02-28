package com.company;

import static java.lang.System.out;

public class Main {
  public static void main(String[] args) {
    doChange(3, 'A', 'B', 'C');
  }

  public static void doChange(int n, char source, char middle, char target) {
    if (n == 1) {
      out.printf("%c => %c\n", source, target);
    } else {
      doChange(n - 1, source, target, middle);
      out.printf("%c => %c\n", source, target);
      doChange(n - 1, middle, source, target);
    }
  }
}








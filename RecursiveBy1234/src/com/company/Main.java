package com.company;

import java.util.Arrays;
import static java.lang.System.out;

public class Main {
  public static void main(String[] args) {
    int arr[] = {1, 2, 3, 4};
    recursive(arr, 0);
  }

  public static void recursive(int arr[], int n) {
    if (n < arr.length - 1) {
      for (int j = n; j < arr.length; j++) {
        int tempArray[] = Arrays.copyOf(arr, arr.length);
        rotate(tempArray, n, j);
        recursive(tempArray, n + 1);
      }
    } else {
      for (int k : arr) out.print(k);
      out.println();
    }
  }

  public static void rotate(int[] arr, int i, int j) {
    int val = arr[j];
    for (int k = j; k > i; k--) arr[k] = arr[k-1];
    arr[i] = val;
  }
}

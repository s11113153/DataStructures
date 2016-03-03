package com.company;

/**
 * Created by xuyouren on 2016/3/3.
 */

public class Graph {
  private static final int MAX_VERTICES = 6;

  public interface Item {
    void print();
  }

  public interface GraphCallback {
    void getGraphItem(Graph.Item item);
  }

  public static void createGraph(Edge edge, GraphCallback callback) {
    int graphs[][] = new int[MAX_VERTICES][MAX_VERTICES];
    int arr[][] = edge.getEdges();
    for (int i = 0; i < arr.length; i++) {
      int l = arr[i][0];
      int r = arr[i][1];
      graphs[l][r] = 1;
    }
    callback.getGraphItem(() -> {
      for (int i = 1; i < MAX_VERTICES; i++) {
        for (int j = 1; j < MAX_VERTICES; j++) {
          System.out.printf(" %d ", graphs[i][j]);
        }
        System.out.println();
      }
    });
    System.out.println();
  }
}


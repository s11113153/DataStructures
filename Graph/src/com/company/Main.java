package com.company;

public class Main {
  public static void main(String[] args) {

    // example 1
    Edge edges = new Edge.Builder(new int[][] {
        {1, 2}, {2, 1}, {1, 3}, {3, 1}, {2, 3}, {3, 2},
        {2, 4}, {4, 2}, {3, 5}, {5, 3}, {4, 5}, {5, 4}
    }).build();
    // execute example 1
    Graph.callGraph(edges, item -> {
      System.out.println("====================");
      item.printGraph();
      item.printGraphNode();
      item.print_DFS_withStack();
    });

    // example 2
    Edge edges2 = new Edge.Builder(new int[][] {
        {1, 3}, {3, 1}, {1, 4}, {4, 1}, {2, 1}, {1, 2},
        {2, 4}, {4, 2}, {2, 5}, {5, 2}, {4, 3}, {3, 4}
    }).build();

    // execute example 2
    Graph.callGraph(edges2, item -> {
      System.out.println("====================");
      item.printGraph();
      item.printGraphNode();
      item.print_DFS_withStack();
    });
  }
}

package com.company;

public class Main {
  public static void main(String[] args) {
    Edge edges = new Edge.Builder(new int[][] {
        {1, 2}, {2, 1}, {1, 3}, {3, 1}, {2, 3}, {3, 2},
        {2, 4}, {4, 2}, {3, 5}, {5, 3}, {4, 5}, {5, 4}
    }).build();
    Graph.createGraph(edges, (item) -> item.print());

    Edge edges2 = new Edge.Builder(new int[][] {
        {1, 3}, {3, 1}, {1, 4}, {4, 1}, {2, 1}, {1, 2},
        {2, 4}, {4, 2}, {2, 5}, {5, 2}, {4, 3}, {3, 4}
    }).build();
    Graph.createGraph(edges2, (item -> item.print()));
  }
}

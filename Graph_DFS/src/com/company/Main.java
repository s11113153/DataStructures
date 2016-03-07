package com.company;

class Node {
  int data;
  Node next;
}

public class Main {
  public static final int MAX_VERTICES = 9;
  private static Node[] nodes = new Node[MAX_VERTICES];
  private static int[] visited = new int[MAX_VERTICES];

  public static void main(String[] args) {
    int edges[][] = {
        {1, 2}, {2, 1}, {1, 3}, {3, 1},
        {2, 4}, {4, 2}, {2, 5}, {5, 2},
        {3, 6}, {6, 3}, {3, 7}, {7, 3},
        {4, 8}, {8, 4}, {5, 8}, {8, 5},
        {6, 8}, {8, 6}, {7, 8}, {8, 7},
    };
    initNodes();
    createGraph(edges);
    printGraph();
    System.out.print("圖型的深度優先採訪");
    dfs(1);
  }

  public static void initNodes() {
    for (int i = 0; i < nodes.length; i++)
      nodes[i] = new Node();
  }

  public static void createGraph(int[][] edges) {
    Node ptr;

    for (int i = 0; i < edges.length; i++) {
      int l = edges[i][0];
      int r = edges[i][1];
      ptr = nodes[l];
      while (ptr.next != null) ptr = ptr.next;
      ptr.next = new Node();
      ptr.next.data = r;
    }
  }

  public static void printGraph() {
    for (int i = 1; i < MAX_VERTICES; i++) {
      Node ptr = nodes[i];
      System.out.print(i + " =>");
      while (ptr.next != null) {
        ptr = ptr.next;
        System.out.print(" " + ptr.data);
      }
      System.out.println();
    }
  }

  public static void dfs(int vertex) {
    Node ptr;
    visited[vertex] = 1;
    System.out.printf("[V%d]", vertex);
    ptr = nodes[vertex].next;
    while (ptr != null) {
      if (visited[ptr.data] == 0) dfs(ptr.data);
      ptr = ptr.next;
    }
  }
}

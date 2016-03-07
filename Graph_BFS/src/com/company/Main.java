package com.company;

import java.util.ArrayDeque;
import java.util.Queue;

class Node {
  int data;
  Node next;
}

public class Main {
  public static final int MAX_VERTICES = 9;
  private static Queue<Integer> queue = new ArrayDeque<>();
  private static int[] visited = new int[MAX_VERTICES];
  private static Node[] nodes = new Node[MAX_VERTICES];

  public static void main(String[] args) {
    initNodes();
    int[][] edges = {
        {1, 2}, {2, 1}, {1, 3}, {3, 1},
        {2, 4}, {4, 2}, {2, 5}, {5, 2},
        {3, 6}, {6, 3}, {3, 7}, {7, 3},
        {4, 8}, {8, 4}, {5, 8}, {8, 5},
        {6, 8}, {8, 6}, {7, 8}, {8, 7}
    };
    createGraph(edges);
    printGraph();
    BFS(1);
  }

  public static void initNodes() {
    for (int i = 0; i < MAX_VERTICES; i++) {
      nodes[i] = new Node();
      visited[i] = 0;
    }
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
    Node ptr;
    for (int i = 1; i < MAX_VERTICES; i++) {
      ptr = nodes[i];
      System.out.printf("[V%d]", i);
      while (ptr.next != null) {
        ptr = ptr.next;
        System.out.printf("->[V%d]", ptr.data);
      }
      System.out.println();
    }
  }

  public static void BFS(int vertex) {
    queue.add(vertex);
    System.out.print(vertex);
    visited[vertex] = 1;
    Node ptr;
    while (!queue.isEmpty()) {
      int v = queue.poll();
      ptr = nodes[v].next;
      while (ptr != null) {
        if (visited[ptr.data] == 0) {
          queue.add(ptr.data);
          visited[ptr.data] = 1;
          System.out.print(ptr.data);
        }
        ptr = ptr.next;
      }
    }
  }
}
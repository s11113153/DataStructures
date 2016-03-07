package com.company;

class Node {
  int data;
  Node next;
}

public class Main {
  public static final int MAX_VERTICES = 6;
  private static Node[] nodes = new Node[MAX_VERTICES];

  public static void main(String[] args) {
    int edges[][] = {
      {1, 2}, {2, 1}, {1, 3}, {3, 1}, {2, 3}, {3, 2},
      {2, 4}, {4, 2}, {3, 5}, {5, 3}, {4, 5}, {5, 4}
    };
    for (int i = 0; i < MAX_VERTICES; i++) {
      nodes[i] = new Node();
    }
    createGraph(edges);
    printGraph();
  }

  public static void createGraph(int[][] edges) {
    Node node;
    Node ptr;
    for (int i = 0; i < edges.length; i++) {
      int l = edges[i][0];
      int r = edges[i][1];
      node = new Node();
      node.data = r;
      ptr = nodes[l];
      while (ptr.next != null) ptr = ptr.next;
      ptr.next = node;
    }
  }

  public static void printGraph() {
    for (int i = 1; i < MAX_VERTICES; i++) {
      System.out.printf("頂點 V%d =>", i);
      Node ptr = nodes[i];
      while (ptr.next != null) {
        ptr = ptr.next;
        System.out.print(" " + ptr.data);
      }
      System.out.println();
    }
  }
}

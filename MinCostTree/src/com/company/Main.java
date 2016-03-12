package com.company;

import static java.lang.System.out;

class Node {
  int weight;
  int from;
  int to;
  Node next;
}

public class Main {
  public static int[] vertex = new int[10];

  public static void main(String[] args) {
    int[][] edges = {
        {1, 2, 2},
        {2, 4, 3},
        {1, 4, 4},
        {3, 5, 5},
        {2, 5, 6},
        {2, 3, 8},
        {3, 4, 10},
        {4, 5, 15}
    };
    int[][] edges2 = {
        {3, 4, 1},
        {1, 6, 2},
        {2, 6, 3},
        {5, 4, 4},
        {2, 4, 5},
        {1, 2, 7},
        {6, 4, 10},
        {1, 3, 12},
        {2, 5, 14},
        {3, 6, 18}
    };
    minCostTree(getNodeList(edges2));
    for (int i = 1; i < vertex.length; i++) {
      out.printf("[%d]:%d\n", i, vertex[i]);
    }
  }

  public static Node getNodeList(int[][] edges) {
    Node first = null;
    Node ptr = null;
    for (int i = 0; i < edges.length; i++) {
      int l = edges[i][0];
      int r = edges[i][1];
      int w = edges[i][2];
      Node newNode = new Node();
      newNode.from = l;
      newNode.to = r;
      newNode.weight = w;
      if (first == null) {
        first = newNode;
        ptr = first;
      } else {
        ptr.next = newNode;
        ptr = ptr.next;
      }
    }
    return first;
  }

  public static void minCostTree(Node first) {
    Node ptr = first;
    while (ptr != null) {
      if (!isSameSet(ptr.from, ptr.to)) {
        out.printf("%d %d %d\n", ptr.from, ptr.to, ptr.weight);
        addSet(ptr.from, ptr.to);
      }
      ptr = ptr.next;
    }
  }

  public static void addSet(int from, int to) {
    int to_root = to;
    while (vertex[to_root] > 0) to_root = vertex[to_root];
    vertex[to_root] = from;
  }

  public static boolean isSameSet(int from, int to) {
    int from_top = from;
    int to_top = to;
    while (vertex[from_top] > 0) {
      from_top = vertex[from_top];
    }
    while (vertex[to_top] > 0) {
      to_top = vertex[to_top];
    }
    out.printf("f = %d ft=%d, t = %d tt=%d\n", from, from_top, to, to_top);
    return from_top == to_top;
  }
}


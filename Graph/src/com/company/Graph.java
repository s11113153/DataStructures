package com.company;

import java.util.Stack;

import static java.lang.System.out;

/**
 * Created by xuyouren on 2016/3/3.
 */

public class Graph {
  private static final int MAX_VERTICES = 6;

  public interface Item {
    void print_DFS_withStack();
    void printGraphNode();
    void printGraph();
  }

  public interface GraphCallback {
    void getGraphItem(Graph.Item item);
  }

  public static void callGraph(Edge edge, GraphCallback callback) {
    Node[] nodes = new Node[MAX_VERTICES];
    for (int i = 0; i < nodes.length; i++) nodes[i] = new Node();
    int arr[][] = edge.getEdges();
    for (int i = 0; i < arr.length; i++) {
      int l = arr[i][0];
      int r = arr[i][1];
      Node ptr = nodes[l];
      while (ptr.next != null) {
        ptr = ptr.next;
      }
      ptr.next = new Node();
      ptr.next.data = r;
    }

    callback.getGraphItem(new Item() {
      @Override
      public void print_DFS_withStack() {
        boolean[] visited = new boolean[MAX_VERTICES];
        Stack<Node> stack = new Stack<>();
        stack.push(nodes[1]);
        visited[1] = true;
        out.print(1);
        while (!stack.isEmpty()) {
          Node ptr = stack.pop();
          while (ptr.next != null) {
            ptr = ptr.next;
            if (visited[ptr.data]) { /* continue */ }
            else {
              out.print(ptr.data);
              visited[ptr.data] = true;
              stack.push(ptr);
              ptr = nodes[ptr.data];
            }
          }
        }
        out.println();
      }

      @Override
      public void printGraphNode() {
        for (int i = 1; i < nodes.length; i++) {
          Node ptr = nodes[i];
          System.out.print(i);
          while ((ptr = ptr.next) != null) {
            System.out.print(ptr.data);
          }
          System.out.println();
        }
      }

      @Override
      public void printGraph() {
        int graphs[][] = new int[MAX_VERTICES][MAX_VERTICES];
        int arr[][] = edge.getEdges();
        for (int i = 0; i < arr.length; i++) {
          int l = arr[i][0];
          int r = arr[i][1];
          graphs[l][r] = 1;
        }
        for (int i = 1; i < MAX_VERTICES; i++) {
          for (int j = 1; j < MAX_VERTICES; j++) {
            System.out.printf(" %d ", graphs[i][j]);
          }
          System.out.println();
        }
      }
    });
  }
}




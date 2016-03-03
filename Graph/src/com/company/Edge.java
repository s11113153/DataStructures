package com.company;

/**
 * Created by xuyouren on 2016/3/3.
 */
public class Edge {
  private final int[][] edges;

  private Edge(Builder b) {
    this.edges = b.edges;
  }

  public int[][] getEdges () { return edges; }

  public static class Builder {
    private final int edges[][];

    public Builder(int[][] edges) {
      this.edges = edges;
    }

    public Edge build() {
      return new Edge(this);
    }
  }
}

package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.out;

public class Main {
  private static int queueSize = -1;
  private static int front = -1;
  private static int rear = -1;
  private static String queue[];
  private static int tag = 0;

  public static final int CHOOSE_EXIT = 0x00;
  public static final int CHOOSE_INIT = 0x01;
  public static final int CHOOSE_ENQUEUE = 0x02;
  public static final int CHOOSE_DEQUEUE = 0x03;

  private static final String QUEUE_MSG_FULL = "queue is full !!!";
  private static final String QUEUE_MSG_EMPTY = "queue is empty !!!";


  public static void main(String[] args) throws IllegalArgumentException, IOException  {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    out.print("請輸入佇列的大小：");

    int size = Integer.parseInt(reader.readLine());
    queueSize = size;
    if (queueSize < 0) throw new IllegalArgumentException("size must > 0");
    front = rear = queueSize - 1;
    queue = new String[queueSize];

    int choose = CHOOSE_INIT;
    while (choose != CHOOSE_EXIT) {
      out.println("請選擇[2]插入或[3]刪除");
      choose = Integer.valueOf(reader.readLine());
      if (choose == CHOOSE_ENQUEUE) {
        out.print("item: ");
        enqueue(reader.readLine());
      } else if (choose == CHOOSE_DEQUEUE) {
        dequeue();
      }
    }
  }

  private static boolean isEmpty() {
    return (front == rear && tag == 0);
  }

  public static void enqueue(String item) {
    if (isFull()) {
      out.println(QUEUE_MSG_FULL);
      return;
    }
    rear = (rear + 1) % queueSize;
    queue[rear] = item;
    if (rear == front) tag = 1;
  }

  public static void dequeue() {
    if (isEmpty()) {
      out.println(QUEUE_MSG_EMPTY);
      return;
    }
    front = (front + 1) % queueSize;
    out.println(queue[front]);
    if (rear == front) tag = 0;
  }

  private static boolean isFull() {
    return ((rear == front) && tag == 1);
  }
}




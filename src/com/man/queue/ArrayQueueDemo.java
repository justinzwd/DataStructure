package com.man.queue;

import java.util.Scanner;

public class ArrayQueueDemo
{

    public static void main(String[] args)
    {

        //数据实现队列的缺点就是不能复用
        //可以改进为一个环形的队列

        //创建一个队列，个数最大为3，方便测试
        ArrayQueue arrayQueue = new ArrayQueue(3);
        //定义一个char，用于接收用户键盘输入的字符
        char ch = ' ';
        //定义一个boolean类型的变量，用于控制循环，默认为true，一直循环下去
        boolean loop = true;
        //创建Scanner类实例
        Scanner scanner = new Scanner(System.in);

        while (loop)
        {
            System.out.println("s(show):查看队列所有数据");
            System.out.println("a(add):添加数据到队列中");
            System.out.println("g(get):取出队列头部数据");
            System.out.println("h(head):查看队列头部数据但不取出");
            System.out.println("e(exit):退出程序");

            ch = scanner.next().charAt(0);      //ch存放用户输入的第一个字符

            switch(ch)
            {
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    try
                    {
                        System.out.println("请输入您将要添加的数据：");
                        int value = scanner.nextInt();
                        arrayQueue.addQueue(value);
                    }
                    catch (Exception e)
                    {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'g':
                    try
                    {
                        int value = arrayQueue.getQueue();
                        System.out.println("取出的数据是"+value);
                    }
                    catch (Exception e)
                    {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try
                    {
                        int value = arrayQueue.headQueue();
                        System.out.println("队列头部的数据是"+value);
                    }
                    catch (Exception e)
                    {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    loop = false;
                    scanner.close();
                    break;
                default:
                    break;
            }


        }
        System.out.println("程序运行结束");
    }
}

//使用数组模拟队列-创建一个ArrayQueue类

class ArrayQueue
{
    private int maxSize; // 表示数组的最大容量
    private int front; // 队列头
    private int rear; // 队列尾
    private int[] arr; // 该数据用于存放数据, 模拟队列

    // 创建队列的构造器
    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1; // 指向队列头部，分析出front是指向队列头的前一个位置.
        rear = -1; // 指向队列尾，指向队列尾的数据(即就是队列最后一个数据)
    }

    // 判断队列是否满
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    // 判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    // 添加数据到队列
    public void addQueue(int n) {
        // 判断队列是否满
        if (isFull()) {
            System.out.println("队列满，不能加入数据~");
            return;
        }
        rear++; // 让rear 后移
        arr[rear] = n;
    }

    // 获取队列的数据, 出队列
    public int getQueue() {
        // 判断队列是否空
        if (isEmpty()) {
            // 通过抛出异常
            throw new RuntimeException("队列空，不能取数据");
        }
        front++; // front后移
        return arr[front];

    }

    // 显示队列的所有数据
    public void showQueue() {
        // 遍历
        if (isEmpty()) {
            System.out.println("队列空的，没有数据~~");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    // 显示队列的头数据， 注意不是取出数据
    public int headQueue() {
        // 判断
        if (isEmpty()) {
            throw new RuntimeException("队列空的，没有数据~~");
        }
        return arr[front + 1];
    }
}
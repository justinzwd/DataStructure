package com.man.queue;

import java.util.Scanner;

public class CircleArrayQueueDemo
{

    public static void main(String[] args)
    {
        //创建一个环形队列，个数最大为4，其实有效数据个数为3，方便测试
        //因为我们预留了一个空
        CircleArrayQueue circleArrayQueue = new CircleArrayQueue(4);
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
                    circleArrayQueue.showQueue();
                    break;
                case 'a':
                    try
                    {
                        System.out.println("请输入您将要添加的数据：");
                        int value = scanner.nextInt();
                        circleArrayQueue.addQueue(value);
                    }
                    catch (Exception e)
                    {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'g':
                    try
                    {
                        int value = circleArrayQueue.getQueue();
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
                        int value = circleArrayQueue.getHeadQueue();
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

class CircleArrayQueue
{
    //数组最大容量
    private int maxSize;
    //队列头
    private int front=0;      //规定front指向队列的第一个数据的前一个位置
    //队列尾
    private int rear=0;       //规定rear指向队列的最后一个数据
    //定义数组存放队列数据，模拟队列
    private int[] arr;

    //创建队列的构造器
    public CircleArrayQueue(int arrMaxSize)
    {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        //front和rear的初始值在定义的时候已经初始化
    }

    //判断队列是否为空
    public boolean isEmpty()
    {
        return front == rear;
    }

    //判断队列是否为满
    public boolean isFull()
    {
        return (rear + 1) % maxSize == front;
    }

    //添加数据到队列
    public void addQueue(int n)
    {
        //首先判断队列是否为满
        if (isFull())
        {
            System.out.println("队列已满，不能再往里面插入数据");
            return;
        }
        arr[rear] = n;
        //rear后移的时候，必须考虑取模
        rear = (rear + 1) % maxSize;
    }

    //获取队列数据，出队列
    public int getQueue()
    {
        //首先判断为空
        if (isEmpty())
        {
            throw new RuntimeException("队列为空，不能取出数据");
        }
        int value = arr[front];
        //front后移的时候，必须考虑取模
        front = (front + 1) % maxSize;
        return value;
    }

    //查看队列有多少个有效的数据，或者说，已经被填充值的数据
    public int size()
    {
        return (rear - front + maxSize) % maxSize;
    }

    //查看队列头数据，不出队列
    public int getHeadQueue()
    {
        //首先判断为空
        if (isEmpty())
        {
            throw new RuntimeException("队列为空，不能取出数据");
        }
        return arr[front];
    }

    //遍历所有数据，但不出队列
    public void showQueue()
    {
        //首先判断是否为空
        if (isEmpty())
        {
            System.out.println("队列为空");
            return;
        }

        for (int i = front; i < front + size(); i++)
        {
            System.out.printf("arr[%d] = %d\n",i % maxSize,arr[i % maxSize]);     //格式化输出数据
        }
    }
}
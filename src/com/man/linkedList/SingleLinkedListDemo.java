package com.man.linkedList;

import java.util.Stack;

public class SingleLinkedListDemo
{
    public static int getLength(HeroNode head)
    {
        HeroNode current = head.next;
        if (current == null)
        {
            System.out.println("链表为空");
            return 0;
        }

        int length = 0;
        while(current != null)
        {
            length++;
            current = current.next;
        }
        return length;
    }

    public static HeroNode getLastKNode(HeroNode head,int index)
    {
        //获得链表的长度
        int size = getLength(head);
        //从头开始遍历size-index个，即可遍历到倒数index个

        //判断index是否合法,index为自然语言中的下标，从1开始
        if (index <= 0 || index > size)
        {
            return null;
        }

        HeroNode current = head.next;
        for (int i=0;i<size-index;i++)
        {
            current = current.next;
        }

        return current;

    }

    public static void reversePrint(HeroNode head)
    {
        Stack<HeroNode> stack = new Stack<>();
        if (head.next == null)
        {
            System.out.println("链表为空，不能打印");
        }

        HeroNode cur = head.next;
        while(cur != null)
        {
            stack.push(cur);
            cur = cur.next;
        }

        while(stack.size()>0)
        {
            System.out.println(stack.pop());
        }
    }

    public static void reverseSingleLinkedList(HeroNode head)
    {
        HeroNode current = head.next;
        if (current == null || current.next == null)
        {
            System.out.println("链表为空或者只有一个元素，反转后与原链表一样");
            return;
        }
        HeroNode reverse = new HeroNode(0,"","");
        reverse.next = current;
        HeroNode temp = current.next;
        current.next = null;
        while(temp!=null)
        {
            current = temp;
            temp = temp.next;
            current.next = reverse.next;
            reverse.next = current;
        }

        head.next = reverse.next;
    }

    public static void main(String[] args)
    {
        //创建结点
        HeroNode h1 = new HeroNode(1,"1","11");
        HeroNode h2 = new HeroNode(2,"2","22");
        HeroNode h3 = new HeroNode(3,"3","33");
        HeroNode h4 = new HeroNode(4,"4","44");

        //创建单链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        //将结点加入到单链表中
        singleLinkedList.addByOrder(h1);
        singleLinkedList.addByOrder(h3);
        singleLinkedList.addByOrder(h4);
        singleLinkedList.addByOrder(h2);
        //singleLinkedList.addByOrder(h2);

        //显示
        //System.out.println("修改前显示");
        //singleLinkedList.list();
        //
        //HeroNode h5 = new HeroNode(4,"5","55");
        //singleLinkedList.update(h5);

        //显示
        System.out.println("删除前显示");
        singleLinkedList.list();
        System.out.println("删除前的结点个数为：" + getLength(singleLinkedList.getHead()));

        //System.out.println(getLastKNode(singleLinkedList.getHead(),1));

        //System.out.println("删除后显示");
        ////singleLinkedList.delete(5);
        //singleLinkedList.delete(1);
        //singleLinkedList.delete(2);
        //singleLinkedList.delete(3);
        //singleLinkedList.delete(4);
        //singleLinkedList.list();

        //System.out.println("删除后的结点个数为：" + getLength(singleLinkedList.getHead()));

        //reverseSingleLinkedList(singleLinkedList.getHead());
        //System.out.println("反转之后");
        //singleLinkedList.list();

        System.out.println("反转之后");
        reversePrint(singleLinkedList.getHead());

    }
}

class SingleLinkedList
{
    private HeroNode head = new HeroNode(0,"","");

    //获得头结点
    public HeroNode getHead()
    {
        return head;
    }
    public void add(HeroNode heroNode)
    {

        //1.先找到链表的最后一个结点
        //2.将结点赋值给最后一个结点的next域
        HeroNode temp = head;
        while(true)
        {
            if (temp.next == null)
                break;
            temp = temp.next;
        }
        temp.next = heroNode;
    }

    public void addByOrder(HeroNode heroNode)
    {
        HeroNode temp = head;
        boolean flag = false;   //表示结点编号是否已经存在

        while(true)
        {
            if (temp.next == null)
                break;  //如果到了链表的最后了还没找到合适的插入位置，那就停止，在最后插入

            if (temp.next.no > heroNode.no)
            {
                break;  //temp和temp.next之间的位置将是插入的位置
            }
            else if (temp.next.no == heroNode.no)
            {
                flag = true;
                System.out.println("存在重复的结点编号" + heroNode.no);
                break;
            }
            else
            {
                temp = temp.next;
            }
        }

        //根据flag判断是否可以插入，根据temp判断插入的位置
        if (flag)
        {
            return;
        }
        else
        {
            //插入
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    public void list()
    {
        //首先判断链表是否为空
        if (head.next == null)
        {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        while(true)
        {
            if (temp == null)
                break;
            System.out.println(temp.toString());
            temp = temp.next;
        }
    }

    public void update(HeroNode heroNode)
    {
        HeroNode temp = head.next;

        boolean flag = false;    //表示编号结点是否已经找到
        while(true)
        {
            if (temp == null)
            {
                System.out.println("链表为空，不能修改");
                break;
            }
            if (temp.no == heroNode.no)
            {
                flag = true;
                break;
            }
            else
                temp = temp.next;
        }

        if (flag)
        {
            temp.name = heroNode.name;
            temp.nickName = heroNode.nickName;
        }
        else
        {
            System.out.printf("编号%d未找到\n",heroNode.no);
        }
    }

    public void delete(int hNo)
    {
        HeroNode temp = head;
        if (temp.next == null)
        {
            System.out.println("链表为空，不能删除结点");
            return;
        }
        boolean flag = false;
        while(true)
        {
            if (temp.next == null)
            {
                //System.out.println("已到链表尾部，无法删除");
                break;
            }
            if (temp.next.no == hNo)
            {
                flag = true;
                break;
            }
            else
            {
                temp = temp.next;
            }
        }
        if (flag)
        {
            temp.next = temp.next.next;
        }
        else
        {
            System.out.println("没有找到相对应的编号，不能进行删除");
        }
    }
}

//每个HeroNode对象就是一个结点
class HeroNode
{
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;

    //构造器
    public HeroNode(int no,String name,String nickName)
    {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    //重写toString()方法

    @Override
    public String toString()
    {
        return "Heronode [no = "+ no + ",name = " + name + ",nickName = " + nickName +" ]";
    }
}
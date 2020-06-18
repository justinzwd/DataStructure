package com.man.linkedList;

public class SingleLinkedListDemo
{

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

        //显示
        singleLinkedList.list();

    }
}

class SingleLinkedList
{
    private HeroNode head = new HeroNode(0,"","");

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
                System.out.println("存在重复的结点编号 %d" + heroNode.no);
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
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
        singleLinkedList.add(h1);
        singleLinkedList.add(h2);
        singleLinkedList.add(h3);
        singleLinkedList.add(h4);

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
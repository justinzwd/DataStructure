package com.man.linkedList;

import java.util.Stack;

public class StackTest
{

    public static void main(String[] args)
    {
        Stack<String> stringStack = new Stack<>();
        stringStack.add("11");
        stringStack.add("22");
        stringStack.add("33");

        while (stringStack.size() > 0)
        {
            System.out.println(stringStack.pop());
        }
    }

}

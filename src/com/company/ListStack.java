package com.company;

import java.util.ArrayList;

import static java.lang.System.out;

public class ListStack<X> {
    private final ArrayList<X> data;
    private int stackPointer;

    public ListStack(){
        data = new ArrayList<>();
        stackPointer = 0;
    }
    public void push(X newItem)
    {
        data.add(newItem);
        stackPointer++;
        System.out.println("In push");
    }

    public X pop() throws IllegalAccessException {
        if(stackPointer == 0)
        {
            throw new IllegalAccessException("No more data exists");
        }
        return data.remove(--stackPointer);
    }
    public boolean contains(String item)
    {
        boolean found = false;
        for(int i = 0;i<stackPointer;i++)
        {
            if(item.equals(data.get(i)))
            {
                found =  true;
                break;
            }
        }
        return found;
    }

    public X access(X item) throws IllegalAccessException {
        while(stackPointer > 0) {
            X temp = pop();
            if(item.equals(temp)){
                return temp;
            }

        }
        //if we didn't find the ìtem in the stack throw exception
        throw new IllegalArgumentException("Could not find the item in the stack" + item);
    }

    public int size()
    {
        return stackPointer;
    }
    public static void main(String[] args) throws IllegalAccessException {
        ListStack <Integer> stack = new ListStack<>();
        out.println(stack.size());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        out.println(stack.contains("Ashish"));
        stack.pop();
        while(stack.size() > 0){
            out.println(stack.pop());
        }


    }
}

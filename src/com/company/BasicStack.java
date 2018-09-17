package com.company;

public class BasicStack<X> {

    private X [] data;
    private int stackPointer;

    public BasicStack(){
        data = (X[]) new Object[1000];
        stackPointer = 0;
    }
     public void push(X newItem)
     {
         data[stackPointer++] = newItem;
     }

     public X pop() throws IllegalAccessException {
         if(stackPointer == 0)
         {
             throw new IllegalAccessException("No more data exists");
         }
         return data[--stackPointer];
     }
    public boolean contains(X item)
    {
        boolean found = false;
        for(int i = 0;i<stackPointer;i++)
        {
            if(item.equals(data[i]))
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
    BasicStack <String> stack = new BasicStack<>();

        stack.push("Ashish");
        stack.push("Ashish2");
        stack.push("Ashish3");
        stack.push("Ashish4");
        stack.push("Ashish5");
        System.out.println(stack.contains("Ashish"));
        stack.pop();
        while(stack.size() > 0){
            System.out.println(stack.pop());
        }


    }
}

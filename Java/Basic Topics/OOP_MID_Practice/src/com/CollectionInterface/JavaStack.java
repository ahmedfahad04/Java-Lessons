package com.CollectionInterface;

import java.util.Stack;

public class JavaStack {
    public static void main(String[] args) {
        Stack <Number> stack = new Stack<>();

        stack.push(12L);
        stack.push(14.5);
        stack.push(3545);
        stack.push(198.4F);
        stack.push(1414515);
        stack.push(147498.4F);

        System.out.println("All members...");
        for(Number value: stack){
            System.out.println(value);
        }

        stack.pop();
        stack.remove(14.5); // as stack extends Vector, that's why vector's method is also available in stack
        System.out.println("TOP ELEMENT: " + stack.peek());

        System.out.println("Stack status: " + stack.empty());

        System.out.println("After Modification...");
        for(Number value: stack){
            System.out.println(value);
        }

    }
}

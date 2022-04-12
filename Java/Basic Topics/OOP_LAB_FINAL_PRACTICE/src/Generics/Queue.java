package Generics;

public class Queue <E> {
    public final int capacity;
    public int front;
    public int rear;
    public E[] member;
    public int size;

    public Queue(){
        this(10);
    }

    public Queue(int cap){
        this.capacity = cap < 0 ? 10 : cap;
        front = 0;
        rear = -1;
        member = (E[]) new Object[capacity];
        size = 0;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFULL(){
        return size == capacity;
    }

    public int size(){
        return size;
    }

    public E dequeue(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
        }

        E item = member[front++];
//        front = (front + 1) % capacity;
        size--;

        return item;
    }

    public void enqueue(E item){
        if(isFULL()){
            System.out.println("Queue is Full, can't insert new element");
        }

//        rear = (rear + 1) % capacity;
        member[++rear] = item;
        size++;
    }

    public E peek(){
        if(isEmpty()){
            System.out.println("Queue is empty, nothing to show");
        }

        return member[front];
    }
}

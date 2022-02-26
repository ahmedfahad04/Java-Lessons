package com.PracticeProblem;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Point implements Comparable<Point>{

    private final int x;
    private final int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    @Override
    public int compareTo(Point a){
        return a.x > this.x ? 1 : -1;
    }

//    public String toString(){
//        return "( " + this.x + ", " + this.y + " )\n";
//    }
}

public class PointSorting {
    public static void main(String[] args) {

        PriorityQueue<Point> coordinates = new PriorityQueue<>();
        coordinates.offer(new Point(21,47));
        coordinates.offer(new Point(14,15));
        coordinates.offer(new Point(22,56));
        coordinates.offer(new Point(8,5));
        coordinates.offer(new Point(16,26));

        while(!coordinates.isEmpty()){
            Point xy = coordinates.poll();
            System.out.println("( " + xy.getX() + ", " + xy.getY() + " )\n");
        }

    }
}
package com.PracticeProblem;

import java.util.*;

class Point{

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

//    public String toString(){
//        return "( " + this.x + ", " + this.y + " )\n";
//    }
}

class SortedPoint implements Comparator<Point> {
    @Override
    public int compare(Point a, Point b) {
        return b.getX() - a.getX();
    }
}

public class PointSorting {
    public static void main(String[] args) {

//        PriorityQueue<Point> coordinates = new PriorityQueue<>();
//        coordinates.offer(new Point(21,47));
//        coordinates.offer(new Point(14,15));
//        coordinates.offer(new Point(22,56));
//        coordinates.offer(new Point(8,5));
//        coordinates.offer(new Point(16,26));
//
//        while(!coordinates.isEmpty()){
//            Point xy = coordinates.poll();
//            System.out.println("( " + xy.getX() + ", " + xy.getY() + " )\n");
//        }

        List<Point> point = new ArrayList<>();

        point.add(new Point(21,47));
        point.add(new Point(41,55));
        point.add(new Point(25,62));
        point.add(new Point(37,11));

        Collections.sort(point, new SortedPoint());

        for(Point p: point){
            System.out.println(p.getX() + " " + p.getY());
        }

    }
}
package ru.stqa.java.sandbox;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import com.sun.org.apache.xpath.internal.SourceTree;

public class MyFirstProgram {
    public static void main(String[] args) {
        hello("world");
        hello("Кирилл");
        hello("User");

        Square s = new Square(5);
        System.out.println("Площадь квадрата со стороной " + s.l + " равна " + s.area());

        Rectangle r = new Rectangle(4, 5);
        System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " равна " + r.area());

        Point p1 = new Point();
        Point p2 = new Point();
        p1.x = 3;
        p1.y = 2;
        p2.x = 4;
        p2.y = 6;

        distance(p1, p2);

    }

    public static void hello(String somebody) {
        System.out.println("Hello, " + somebody);
    }

    public static void distance(Point p1, Point p2) {
        System.out.println(Math.sqrt(Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2)));

    }

}
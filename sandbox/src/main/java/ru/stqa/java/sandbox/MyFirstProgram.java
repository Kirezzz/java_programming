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

        Point p1 = new Point(1, 1);
        Point p2 = new Point(2, 2);

        System.out.println(p1.distance(p2));
    }

    public static void hello(String somebody) {
        System.out.println("Hello, " + somebody);
    }


}
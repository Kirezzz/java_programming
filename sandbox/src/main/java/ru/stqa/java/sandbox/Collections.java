package ru.stqa.java.sandbox;

/**
 * Created by Sony on 03.10.2016.
 */
public class Collections {
  public static void main(String args[]) {
    String[] langs = {"Java","C#","Python", "PHP"};
    for (String i : langs) {
      System.out.println("Я хочу выучить " + i);
    }
  }
}

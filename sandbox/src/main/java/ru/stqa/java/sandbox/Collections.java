package ru.stqa.java.sandbox;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Sony on 03.10.2016.
 */
public class Collections {
  public static void main(String args[]) {

    List<String> languages = new ArrayList<String>();
    languages.add("Java");
    languages.add("C#");
    languages.add("Python");
    languages.add("PHP");

    for (String l : languages) {
      System.out.println("Я хочу выучить " + l);
    }
  }
}

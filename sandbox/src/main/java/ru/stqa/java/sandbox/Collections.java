package ru.stqa.java.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * Created by Sony on 03.10.2016.
 */
public class Collections {
  public static void main(String args[]) {

    List<String> languages = Arrays.asList("Java","C#","Python", "PHP");
    for (int i = 0; i < languages.size(); i++) {
      System.out.println("Я хочу выучить " + languages.get(i));
    }
  }
}

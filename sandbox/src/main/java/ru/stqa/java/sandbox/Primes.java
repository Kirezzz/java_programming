package ru.stqa.java.sandbox;

/**
 * Created by Sony on 02.10.2016.
 */
public class Primes {
  public static boolean isPrime(int n) {
    for (int i = 2; i < n; i ++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }
}

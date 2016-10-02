package ru.stqa.java.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Sony on 02.10.2016.
 */
public class PrimeTests {
  @Test
  public void testPrime() {
    Assert.assertTrue(Primes.isPrime(Integer.MAX_VALUE));
  }
}

package ru.stqa.java.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Sony on 18.09.2016.
 */
public class PointsTest {
  @Test
  public void testDistance1() {
    Point p1 = new Point(1, 1);
    Point p2 = new Point(2, 2);
    Assert.assertEquals(p1.distance(p2), 1.4142135623730951);
  }

  @Test
  public void testDistance2() {
    Point p1 = new Point(1, 1);
    Point p2 = new Point(2, 2);
    Assert.assertNotEquals(p1.distance(p2), 2);
  }

  @Test
  public void testDistance3() {
    Point p1 = new Point(1, 1);
    Point p2 = new Point(2, 2);
    Assert.assertNotEquals(p1.distance(p2), 1);
  }
  @Test
  public void testDistance4() {
    Point p1 = new Point(1, 1);
    Point p2 = new Point(2, 2);
    Assert.assertEquals(p1.distance(p2), 1);
  }
  }

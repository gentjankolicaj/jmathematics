package io.jmathematics.algorithm;

public final class Pythagoras {

  private Pythagoras() {
  }

  public static double hypotenuse(double a, double b) {
    return Math.sqrt(a * a + b * b);
  }

  public static double triangleArea(double a, double b) {
    return a * b / 2;
  }


}

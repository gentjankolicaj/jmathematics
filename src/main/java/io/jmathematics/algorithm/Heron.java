package io.jmathematics.algorithm;

public final class Heron {

  private Heron() {
  }


  public static double triangleArea(double a, double b, double c) {
    double s = (a + b + c) / 2;
    return Math.sqrt(s * (s - a) * (s - b) * (s - c));
  }


}

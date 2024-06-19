package io.jmathematics.algorithm;

import io.jmathematics.Algorithm;

/**
 * Implementation of <a href="https://en.wikipedia.org/wiki/Euclidean_algorithm">Euclidean
 * algorithm</a>
 */
public class EuclideanAlgorithm implements Algorithm {

  private EuclideanAlgorithm() {
  }

  public static int gcd(final int a, final int b) {
    int x = Math.max(a, b);
    int y = Math.min(a, b);
    while (y != 0) {
      int tmp = y;
      y = x % y;
      x = tmp;
    }
    return x;
  }

  public static long gcd(final long a, final long b) {
    long x = Math.max(a, b);
    long y = Math.min(a, b);
    while (y != 0) {
      long tmp = y;
      y = x % y;
      x = tmp;
    }
    return x;
  }

}

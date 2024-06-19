package io.jmathematics.approx;

import java.util.stream.IntStream;

/**
 * Calculation of factorial using <a
 * href="https://en.wikipedia.org/wiki/Stirling%27s_approximation">Stirling approximation</a>
 */
public class StirlingApprox {

  private StirlingApprox() {
  }

  /**
   * Factorial natural logarithm.
   *
   * @param n factorial
   * @return ln(n !)
   */
  public static double ln(int n) {
    return IntStream.rangeClosed(1, n).mapToDouble(Math::log).sum();
  }

  /**
   * Factorial logarithm with base=2
   *
   * @param n factorial
   * @return log2(n !)
   */
  public static double lg(int n) {
    return IntStream.rangeClosed(1, n).mapToDouble(i -> Math.log(i) / Math.log(2)).sum();
  }

  public static double factorial(int n) {
    return Math.sqrt(2 * Math.PI * n) * Math.pow(n / Math.E, n);
  }

}

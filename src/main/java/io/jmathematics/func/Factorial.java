package io.jmathematics.func;

public class Factorial implements UnivariateFunction {

  /**
   * Calculate value using loop
   *
   * @param n
   * @return
   */
  public static int valueL(int n) {
    int ans = 1;
    for (int i = n; i >= 2; i--) {
      ans = ans * i;
    }
    return ans;
  }

  /**
   * Calculate value using loop
   *
   * @param n
   * @return
   */
  public static double valueL(double n) {
    double ans = 1;
    for (double i = n; i >= 1; i--) {
      ans = ans * i;
    }
    return ans;
  }

  /**
   * Calculate value using recursive function call
   *
   * @param n
   * @return
   */
  public static int valueR(int n) {
    if (n == 1) {
      return 1;
    }
    return n * valueR(n - 1);
  }

  /**
   * Calculate value using recursive function call
   *
   * @param n
   * @return
   */
  public static double valueR(double n) {
    if (n == 1) {
      return 1;
    }
    return n * valueR(n - 1);
  }

  @Override
  public double value(double x) {
    return valueR(x);
  }
}

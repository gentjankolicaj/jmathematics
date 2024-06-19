package io.jmathematics.algorithm;


public class Euler {

  private Euler() {
  }

  public static long totGCD(long n) {
    if (n == 0 || n == 1) {
      return n;
    }
    long m = 0;
    for (long i = n - 1; i > 0; i--) {
      if (EuclideanAlgorithm.gcd(i, n) == 1) {
        m++;
      }
    }
    return m;
  }

  public static long tot(long n) {
    if (n == 0 || n == 1) {
      return n;
    }
    double result = n;
    for (int p = 2; (long) p * p <= n; ++p) {
      // Check if p is a prime factor.
      if (n % p == 0) {
        // If yes, then update n and result
        while (n % p == 0) {
          n /= p;
        }
        result -= result / p;
      }
    }

    // If n has a prime factor greater than sqrt(n)
    // (There can be at-most one such prime factor)
    if (n > 1) {
      result -= result / n;
    }
    return (long) result;
  }

}

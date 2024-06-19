package io.jmathematics.prime;

import io.jmathematics.Theorem;

/**
 * Simplistic implementation of prime number theorem.
 */
public class PNT implements Theorem {

  public static int primes(int n) {
    return (int) (n / Math.log(n));
  }

  public static long primes(long n) {
    return (long) (n / Math.log(n));
  }

}

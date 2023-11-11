package io.jmathematics.prime;

import io.jmathematics.Algorithm;
import io.jmathematics.modular.ModExp;
import io.jmathematics.random.CommonRandom;

public interface Primality extends Algorithm {


  /**
   * Checks for primality of a number using trial division algorithm.
   *
   * @param n
   * @return flag whether argument is prime or not
   */
  static boolean trialDivision(long n) {
    if (n <= 1) {
      return false;
    }
    if (n == 2 || n == 3) {
      return true;
    }
    if (n % 2 == 0 || n % 3 == 0) {
      return false;
    }
    for (int i = 5; i <= Math.sqrt(n); i = i + 6) {
      if (n % i == 0 || n % (i + 2) == 0) {
        return false;
      }
    }
    return true;
  }


  /**
   * <a href="https://en.wikipedia.org/wiki/Fermat_primality_test">Fermat primality test</a>
   *
   * @param p          assumed prime number
   * @param iterations number with random bases 0<a<p-1
   * @return probable prime number
   */
  static double fermat(int p, int iterations) {
    int primality = 0;
    int i = 0;
    while (i < iterations) {
      int a = CommonRandom.secure(1, p - 1);
      long residue = ModExp.squareMultiply(a, p - 1, p);
      if (residue == 1) {
        primality++;
      }
      i++;
    }
    return (double) primality / iterations;
  }

  static double millerRabin(long p, long k) {
    if (p <= 1) {
      throw new IllegalArgumentException("Candidate number must be bigger than 1");
    }
    if (p <= 3) {
      return 0;
    }
    //if n is even is not prime
    if (p % 2 == 0) {
      return 1;
    }
    long d = p - 1;
    long s = 0;
    while (d % 2 == 0 && d > 0) {
      d = d >> 1;
      s++;
    }
    if (d == 0) {
      throw new UnsupportedOperationException("Couldn't find d>0 odd, such that n-1=d*2^s");
    }

    if (s == 0) {
      throw new UnsupportedOperationException("Couldn't find s>0 odd, such that n-1=d*2^s");
    }
    long primality = 0;
    int i = 0;
    while (i < k) {
      long a = CommonRandom.secure(1, (int) p - 1);
      long x = ModExp.squareMultiply(a, d, p);
      if (x == 1 || x == -1) {
        primality++;
      } else {
        int j = 0;
        while (j < s) {
          long y = x * x % p;
          if (y == -1) {
            primality++;
            break;
          }
          j++;
        }
      }
      i++;
    }
    return primality / k;
  }

}

package io.mathematics.prime;

import io.mathematics.Algorithm;
import io.mathematics.modular.ModExp;
import io.mathematics.random.CommonRandom;

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
    return primality / iterations;
  }


}

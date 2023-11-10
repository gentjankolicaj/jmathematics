package io.mathematics.prime;

import io.mathematics.Algorithm;
import io.mathematics.modular.ModExp;
import io.mathematics.random.CommonRandom;

public interface Compositeness extends Algorithm {

  static double solovayStrassen(long n) {
    return 0;
  }

  static double millerRabin(int p, int k) {
    double compositeness = fermat(p, k);
    long s = 4;
    long d = 35;
    int i = 0;
    while (i < k) {
      int a = CommonRandom.secure(2, p - 2);
      long x = ModExp.squareMultiply(a, d, p);
      int j = 0;
      while (j < s) {
        long y = x * x % p;
        if (y == 1 && x != 1 && x != p - 1) {
          return 1;
        }
        x = y;
        if (y == 1) {
          return 1;
        }
        j++;
      }
      i++;
    }
    return 0;
  }

  /**
   * <a href="https://en.wikipedia.org/wiki/Fermat_primality_test">Fermat primality test</a>
   *
   * @param p          assumed prime number
   * @param iterations number with random bases 0<a<p-1
   * @return probable composite number
   */
  static double fermat(int p, int iterations) {
    int primality = 0;
    int i = 0;
    while (i < iterations) {
      int a = CommonRandom.secure(1, p - 1);
      long residue = ModExp.squareMultiply(a, (long) p - 1, p);
      if (residue != 1) {
        return 1;
      } else {
        primality++;
      }
      i++;
    }
    return 1 - primality / iterations;
  }

  static double forbenius(long n) {
    return 0;
  }


}

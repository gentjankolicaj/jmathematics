package io.mathematics.prime;

import io.mathematics.Algorithm;
import io.mathematics.modular.ModExp;
import io.mathematics.random.CommonRandom;

public interface Compositeness extends Algorithm {

  static double solovayStrassen(long n) {
    return 0;
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
    while (d % 2 == 0) {
      d = d >> 1;
      s++;
    }
    if (d == 0) {
      throw new UnsupportedOperationException("Couldn't find d>0 odd, such that n-1=d*2^s");
    }

    if (s == 0) {
      throw new UnsupportedOperationException("Couldn't find s>0 odd, such that n-1=d*2^s");
    }
    long composite = 0;
    int i = 0;
    while (i < k) {
      long a = CommonRandom.secure(2, (int) p - 1);
      long x = ModExp.squareMultiply(a, d, p);
      if (x == 1 || x == -1) {
        //probably prime do nothing
      } else {
        int j = 0;
        while (j < s) {
          long y = x * x % p;
          if (y == 1 && x != p - 1) {
            composite++;
            break;
          }
          if (y != 1) {
            composite++;
            break;
          }
          j++;
        }
      }
      i++;
    }
    return composite / k;

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

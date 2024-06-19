package io.jmathematics.prime;

import io.jmathematics.Algorithm;
import io.jmathematics.modular.ModExp;
import io.jmathematics.random.CommonRandom;

public interface Compositeness extends Algorithm {


  /**
   * <a href="https://en.wikipedia.org/wiki/Miller%E2%80%93Rabin_primality_test">Miller-Rabin
   * primality test</a>
   * <br> a^p-1=1 (mod p)
   * <br> x^2-1=0 (mod p)
   * <br> (x-1)(x+1)=0 (mod p) , p is odd because p even is not prime, p-1 even => p-1=d*2^s where
   * d,2^s(odd , even)
   * and 1<a<p-2
   *
   * @param p candidate prime
   * @param k test iterations
   * @return positive_composite/k iterations, also if prime => 0 and if composite =>1
   */
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

    if (s == 0) {
      throw new UnsupportedOperationException("Couldn't find s>0 odd, such that n-1=d*2^s");
    }
    long composite = 0;
    int i = 0;
    while (i < k) {
      long a = CommonRandom.secure(2, p - 2);
      long x = ModExp.squareMultiply(a, d, p);
      if (x != 1 && x != -1) {
        int j = 0;
        while (j < s) {
          long y = x * x % p;
          if (y == 1 && x != 1 && x != p - 1) {
            composite++;
            break;
          }
          if (y != 1) {
            composite++;
            break;
          }
          x = y;
          j++;
        }
      }
      i++;
    }
    return (double) composite / k;

  }

  /**
   * <a href="https://en.wikipedia.org/wiki/Fermat_primality_test">Fermat primality test</a>
   * <br>a^p-1=1(mod p) where 1<a<p-1
   *
   * @param p candidate prime
   * @param k test iterations
   * @return positive_composite/k iterations,
   */
  static double fermat(long p, long k) {
    long primality = 0;
    int i = 0;
    while (i < k) {
      long a = CommonRandom.secure(1, p - 1);
      long residue = ModExp.squareMultiply(a, p - 1, p);
      if (residue != 1) {
        return 1;
      } else {
        primality++;
      }
      i++;
    }
    return 1 - (double) primality / k;
  }

}

package io.jmathematics.prime;

import io.jmathematics.Algorithm;
import io.jmathematics.modular.ModExp;
import io.jmathematics.random.CommonRandom;

//todo: CommonRandom.secure(), call a method for generating long random.
public interface Primality extends Algorithm {


  /**
   * Checks for primality of a number using trial division algorithm.
   *
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
   * <br>a^p-1=1(mod p) where 1<a<p-1
   *
   * @param p candidate prime
   * @param k test iterations
   * @return positive_primes/k iterations,
   */
  static double fermat(long p, long k) {
    int primality = 0;
    int i = 0;
    while (i < k) {
      long a = CommonRandom.secure(1, p - 1);
      long residue = ModExp.squareMultiply(a, p - 1, p);
      if (residue == 1) {
        primality++;
      }
      i++;
    }
    return (double) primality / k;
  }

  /**
   * <a href="https://en.wikipedia.org/wiki/Fermat_primality_test">Fermat primality test</a>
   * <br>2^p-1=1(mod p) where 1<2<p-1
   *
   * @param p candidate prime
   * @return 0 or 1 based on square-multiple residue.
   */
  static double fermat(long p) {
    long residue = ModExp.squareMultiply(2, p - 1, p);
    return residue == 1 ? residue : 0;
  }

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
   * @return positive_primes/k iterations, also if prime => 1 and if composite =>0
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
      return 0;
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
    long primality = 0;
    int i = 0;
    while (i < k) {
      long a = CommonRandom.secure(1, p - 2);
      long x = ModExp.squareMultiply(a, d, p);
      if (x == 1 || x == -1) {
        primality++;
      } else {
        int j = 0;
        boolean composite = false;
        while (j < s) {
          long y = x * x % p;
          if (y == 1 && x != 1 && x != p - 1) {
            composite = true;
            break;
          }
          if (y != 1) {
            composite = true;
            break;
          }
          x = y;
          j++;
        }
        primality = composite ? primality : primality + 1;
      }
      i++;
    }
    return (double) primality / k;
  }

}

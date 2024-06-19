package io.jmathematics.algorithm;

import io.jmathematics.Algorithm;
import io.jmathematics.exception.OperationException;
import io.jmathematics.modular.CommonResidue;

/**
 * Implementation of <a href="https://en.wikipedia.org/wiki/Extended_Euclidean_algorithm">Extended
 * Euclidean Algorithm</a>
 */
public class ExtendedEuclideanAlgorithm implements Algorithm {

  private ExtendedEuclideanAlgorithm() {
  }

  public static long[] bezoutCoefficients(final long a, final long b) {
    long r0 = Math.max(a, b);
    long r1 = Math.min(a, b);
    long ri;
    long a0 = 1;
    long a1 = 0;
    long ai;
    long b0 = 0;
    long b1 = 1;
    long bi;

    do {
      ri = r0 % r1;
      ai = a0 - (r0 / r1) * a1;
      bi = b0 - (r0 / r1) * b1;

      //residue shift
      r0 = r1;
      r1 = ri;

      //coefficient shift
      a0 = a1;
      a1 = ai;
      b0 = b1;
      b1 = bi;
    } while (ri != 0 && ri != 1);
    return new long[]{ai, bi};
  }

  public static int mulInv(final int a, final int b) throws OperationException {
    if (EuclideanAlgorithm.gcd(a, b) != 1) {
      throw new OperationException(
          "Multiplicative inverse of " + a + " & " + b + " not found, a & b are not coprime.");
    }
    int r0 = Math.max(a, b);
    int r1 = Math.min(a, b);
    int ri;
    int a0 = 0;
    int a1 = 1;
    int ai;

    do {
      ri = r0 % r1;
      ai = a0 - (r0 / r1) * a1;

      //residue shift
      r0 = r1;
      r1 = ri;

      //coefficient shift
      a0 = a1;
      a1 = ai;
    } while (ri != 0 && ri != 1);
    return CommonResidue.mod(ai, b);
  }

  public static long mulInv(final long a, final long b) throws OperationException {
    if (EuclideanAlgorithm.gcd(a, b) != 1) {
      throw new OperationException(
          "Multiplicative inverse of " + a + " & " + b + " not found, a & b are not coprime.");
    }
    long r0 = Math.max(a, b);
    long r1 = Math.min(a, b);
    long ri;
    long a0 = 0;
    long a1 = 1;
    long ai;

    do {
      ri = r0 % r1;
      ai = a0 - (r0 / r1) * a1;

      //residue shift
      r0 = r1;
      r1 = ri;

      //coefficient shift
      a0 = a1;
      a1 = ai;
    } while (ri != 0 && ri != 1);
    return CommonResidue.mod(ai, b);
  }

}

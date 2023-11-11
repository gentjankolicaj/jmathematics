package io.jmathematics.modular;

public class ModLog {

  private ModLog() {
  }

  public static long[][] logTable(int maxBase, int maxExponent, long modulus) {
    long[][] logTable = new long[maxBase + 1][maxExponent + 1];
    for (int i = 0; i <= maxBase; i++) {
      for (int j = 0; j <= maxExponent; j++) {
        logTable[j][i] = (long) Math.pow(i, j) % modulus;
      }
    }
    return logTable;
  }

  /**
   * Calculates the discrete logarithm in mod world.This implementation returns first result.
   *
   * @param base    base
   * @param value   base^exponent (mod modulus)
   * @param modulus
   * @return log(base ^ exponent) mod(modulus) = exponent (mod modulus)
   */
  public static long log(long base, long value, long modulus) {
    long exponent = 1;
    long prod = base % modulus;
    while (prod != value) {
      prod = (prod * base) % modulus;
      exponent++;
    }
    return exponent;
  }


}

package io.jmathematics.modular;


/**
 * Modular exponentiation methods <br><a
 * href="https://en.wikipedia.org/wiki/Modular_exponentiation">Modular exponentiation</a>
 */
public class ModExp {

  private ModExp() {
  }

  public static long multiplyReduce(long base, long exponent, long modulus) {
    if (base == 0 || base == 1) {
      return base;
    }
    if (exponent == 0) {
      return 1;
    }
    if (exponent == 1) {
      return base;
    }
    if (modulus == 1) {
      return 0;
    }
    long result = 1;
    while (exponent > 0) {
      result = (result * base) % modulus;
      exponent--;
    }
    return result;
  }

  public static long squareMultiply(long base, long exponent, long modulus) {
    if (base == 0 || base == 1) {
      return base;
    }
    if (exponent == 0) {
      return 1;
    }
    if (exponent == 1) {
      return base;
    }
    if (modulus == 1) {
      return 0;
    }
    long result = 1;
    base = base % modulus;
    while (exponent > 0) {
      if (exponent % 2 == 1) {
        result = (result * base) % modulus;
      }
      base = (base * base) % modulus;
      exponent = exponent >> 1;
    }
    return result;
  }

}

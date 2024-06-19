package io.jmathematics.modular;

import io.jmathematics.algorithm.ExtendedEuclideanAlgorithm;
import org.apache.commons.lang3.ArrayUtils;

/**
 * Implementation of <a href="https://en.wikipedia.org/wiki/Chinese_remainder_theorem">Chinese
 * Remainder Theorem</a>.
 */
public class CRT {

  public static final String ARRAY_EMPTY_NOT_VALID = "Moduli array empty not valid.";
  public static final String RESIDUE_ARRAY_EMPTY_NOT_VALID = "Residue array empty not valid.";
  public static final String DIFFERENT_LENGTHS_NOT_VALID = "Residue & moduli array with different lengths not valid.";

  private CRT() {
  }

  public static long[] residues(long x, long[] moduli) {
    if (ArrayUtils.isEmpty(moduli)) {
      throw new IllegalArgumentException(ARRAY_EMPTY_NOT_VALID);
    }
    long[] residues = new long[moduli.length];
    for (int i = 0, len = moduli.length; i < len; i++) {
      residues[i] = x % moduli[i];
    }
    return residues;
  }

  public static long[] add(long[] residues1, long[] residues2, long[] moduli) {
    if (ArrayUtils.isEmpty(residues1) || ArrayUtils.isEmpty(residues2)) {
      throw new IllegalArgumentException(RESIDUE_ARRAY_EMPTY_NOT_VALID);
    }
    if (ArrayUtils.isEmpty(moduli)) {
      throw new IllegalArgumentException(ARRAY_EMPTY_NOT_VALID);
    }
    if (residues1.length != residues2.length || residues1.length != moduli.length) {
      throw new IllegalArgumentException(DIFFERENT_LENGTHS_NOT_VALID);
    }
    long[] res = new long[residues1.length];
    for (int i = 0, len = moduli.length; i < len; i++) {
      res[i] = (residues1[i] + residues2[i]) % moduli[i];
    }
    return res;
  }

  public static long[] add(long[] residues, long x, long[] moduli) {
    if (ArrayUtils.isEmpty(residues)) {
      throw new IllegalArgumentException(RESIDUE_ARRAY_EMPTY_NOT_VALID);
    }
    if (ArrayUtils.isEmpty(moduli)) {
      throw new IllegalArgumentException(ARRAY_EMPTY_NOT_VALID);
    }
    if (residues.length != moduli.length) {
      throw new IllegalArgumentException(DIFFERENT_LENGTHS_NOT_VALID);
    }
    long[] res = new long[residues.length];
    for (int i = 0, len = moduli.length; i < len; i++) {
      res[i] = (residues[i] + x) % moduli[i];
    }
    return res;
  }

  public static long[] sub(long[] residues1, long[] residues2, long[] moduli) {
    if (ArrayUtils.isEmpty(residues1) || ArrayUtils.isEmpty(residues2)) {
      throw new IllegalArgumentException(RESIDUE_ARRAY_EMPTY_NOT_VALID);
    }
    if (ArrayUtils.isEmpty(moduli)) {
      throw new IllegalArgumentException(ARRAY_EMPTY_NOT_VALID);
    }
    if (residues1.length != residues2.length || residues1.length != moduli.length) {
      throw new IllegalArgumentException(DIFFERENT_LENGTHS_NOT_VALID);
    }
    long[] res = new long[residues1.length];
    for (int i = 0, len = moduli.length; i < len; i++) {
      res[i] = (residues1[i] - residues2[i]) % moduli[i];
    }
    return res;
  }

  public static long[] sub(long[] residues, long x, long[] moduli) {
    if (ArrayUtils.isEmpty(residues)) {
      throw new IllegalArgumentException(RESIDUE_ARRAY_EMPTY_NOT_VALID);
    }
    if (ArrayUtils.isEmpty(moduli)) {
      throw new IllegalArgumentException(ARRAY_EMPTY_NOT_VALID);
    }
    if (residues.length != moduli.length) {
      throw new IllegalArgumentException(DIFFERENT_LENGTHS_NOT_VALID);
    }
    long[] res = new long[residues.length];
    for (int i = 0, len = moduli.length; i < len; i++) {
      res[i] = (residues[i] - x) % moduli[i];
    }
    return res;
  }

  public static long[] mul(long[] residues1, long[] residues2, long[] moduli) {
    if (ArrayUtils.isEmpty(residues1) || ArrayUtils.isEmpty(residues2)) {
      throw new IllegalArgumentException(RESIDUE_ARRAY_EMPTY_NOT_VALID);
    }
    if (ArrayUtils.isEmpty(moduli)) {
      throw new IllegalArgumentException(ARRAY_EMPTY_NOT_VALID);
    }
    if (residues1.length != residues2.length || residues1.length != moduli.length) {
      throw new IllegalArgumentException(DIFFERENT_LENGTHS_NOT_VALID);
    }
    long[] res = new long[residues1.length];
    for (int i = 0, len = moduli.length; i < len; i++) {
      res[i] = (residues1[i] * residues2[i]) % moduli[i];
    }
    return res;
  }

  public static long[] mul(long[] residues, long x, long[] moduli) {
    if (ArrayUtils.isEmpty(residues)) {
      throw new IllegalArgumentException(RESIDUE_ARRAY_EMPTY_NOT_VALID);
    }
    if (ArrayUtils.isEmpty(moduli)) {
      throw new IllegalArgumentException(ARRAY_EMPTY_NOT_VALID);
    }
    if (residues.length != moduli.length) {
      throw new IllegalArgumentException(DIFFERENT_LENGTHS_NOT_VALID);
    }
    long[] res = new long[residues.length];
    for (int i = 0, len = moduli.length; i < len; i++) {
      res[i] = (residues[i] * x) % moduli[i];
    }
    return res;
  }

  public static long[] mulInv(long[] residues, long[] moduli) {
    if (ArrayUtils.isEmpty(residues)) {
      throw new IllegalArgumentException(RESIDUE_ARRAY_EMPTY_NOT_VALID);
    }
    if (ArrayUtils.isEmpty(moduli)) {
      throw new IllegalArgumentException(ARRAY_EMPTY_NOT_VALID);
    }
    if (residues.length != moduli.length) {
      throw new IllegalArgumentException(DIFFERENT_LENGTHS_NOT_VALID);
    }
    throw new UnsupportedOperationException();
  }

  public static long[] exp(long[] residues, long[] exponents, long[] moduli) {
    if (ArrayUtils.isEmpty(residues)) {
      throw new IllegalArgumentException(RESIDUE_ARRAY_EMPTY_NOT_VALID);
    }
    if (ArrayUtils.isEmpty(exponents)) {
      throw new IllegalArgumentException("Exponents array empty not valid.");
    }
    if (ArrayUtils.isEmpty(moduli)) {
      throw new IllegalArgumentException(ARRAY_EMPTY_NOT_VALID);
    }
    if (residues.length != exponents.length || exponents.length != moduli.length) {
      throw new IllegalArgumentException(DIFFERENT_LENGTHS_NOT_VALID);
    }
    long[] res = new long[moduli.length];
    for (int i = 0, len = moduli.length; i < len; i++) {
      res[i] = ModExp.squareMultiply(residues[i], exponents[i], moduli[i]);
    }
    return res;
  }

  public static long[] exp(long[] residues, long exponent, long[] moduli) {
    if (ArrayUtils.isEmpty(residues)) {
      throw new IllegalArgumentException(RESIDUE_ARRAY_EMPTY_NOT_VALID);
    }
    if (ArrayUtils.isEmpty(moduli)) {
      throw new IllegalArgumentException(ARRAY_EMPTY_NOT_VALID);
    }
    if (residues.length != moduli.length) {
      throw new IllegalArgumentException(DIFFERENT_LENGTHS_NOT_VALID);
    }
    long[] res = new long[moduli.length];
    for (int i = 0, len = moduli.length; i < len; i++) {
      res[i] = ModExp.squareMultiply(residues[i], exponent, moduli[i]);
    }
    return res;
  }


  public static long x(long[] residues, long[] moduli) {
    if (ArrayUtils.isEmpty(residues)) {
      throw new IllegalArgumentException(RESIDUE_ARRAY_EMPTY_NOT_VALID);
    }
    if (ArrayUtils.isEmpty(moduli)) {
      throw new IllegalArgumentException(ARRAY_EMPTY_NOT_VALID);
    }
    if (residues.length != moduli.length) {
      throw new IllegalArgumentException(DIFFERENT_LENGTHS_NOT_VALID);
    }
    long n = 1;
    for (long m : moduli) {
      n *= m;
    }
    long x = 0;
    //Calc coefficients, x congruent AiRi+...+AnRn , b & bMI=bMultiplicativeInverse => b^-1 mod M
    for (int i = 0, len = moduli.length; i < len; i++) {
      long a = n / moduli[i] * ExtendedEuclideanAlgorithm.mulInv(n / moduli[i], moduli[i]) % n;
      x = (x + a * residues[i]) % n;
    }
    return x;
  }

  /**
   * @param moduli
   * @return
   */
  public static long[] coefficient(long[] moduli) {
    if (ArrayUtils.isEmpty(moduli)) {
      throw new IllegalArgumentException(ARRAY_EMPTY_NOT_VALID);
    }

    long n = 1;
    for (long m : moduli) {
      n *= m;
    }
    //declare coefficients, x congruent AiRi+...+AnRn
    long[] a = new long[moduli.length];

    //calculate coefficients, bMI=bMultiplicativeInverse => b^-1 mod M
    for (int i = 0, len = moduli.length; i < len; i++) {
      a[i] = n / moduli[i] * ExtendedEuclideanAlgorithm.mulInv(n / moduli[i], moduli[i]) % n;
    }
    return a;
  }

  /**
   * @param residues CRT x residues according to m1,m2...mn
   * @param moduli   CRT moduli
   * @return A1, A2...A coefficients in (mod N)
   */
  public static long[] coefficient(long[] residues, long[] moduli) {
    if (ArrayUtils.isEmpty(residues)) {
      throw new IllegalArgumentException(RESIDUE_ARRAY_EMPTY_NOT_VALID);
    }
    if (ArrayUtils.isEmpty(moduli)) {
      throw new IllegalArgumentException(ARRAY_EMPTY_NOT_VALID);
    }
    if (residues.length != moduli.length) {
      throw new IllegalArgumentException(DIFFERENT_LENGTHS_NOT_VALID);
    }
    long n = 1;
    for (long m : moduli) {
      n *= m;
    }
    //declare coefficients, x congruent AiRi+...+AnRn
    long[] a = new long[moduli.length];

    //calculate coefficients, bMI=bMultiplicativeInverse => b^-1 mod M
    for (int i = 0, len = moduli.length; i < len; i++) {
      a[i] = (n / moduli[i]) * (ExtendedEuclideanAlgorithm.mulInv(n / moduli[i], n));
    }
    return a;
  }
}

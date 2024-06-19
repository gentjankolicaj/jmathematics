package io.jmathematics.modular;

import io.jmathematics.algorithm.ExtendedEuclideanAlgorithm;
import io.jmathematics.exception.OperationException;
import org.apache.commons.lang3.ArrayUtils;

public class ModInt {

  public static final String ARGUMENT_ARRAY_IS_EMPTY = "Argument array is empty.";
  private final int modulus;
  private final ResidueSystem residueSystem;

  public ModInt(int modulus) {
    this.modulus = modulus;
    this.residueSystem = ResidueSystem.LEAST;
  }

  public int residueSystemSize() {
    return modulus;
  }

  public int[] residueSystem() {
    return residueSystem.residueSystem(modulus);
  }

  /**
   * All equivalence classes of modulus with number of elements=classSize
   *
   * @param classSize equivalence class size
   * @return equivalent classes
   */
  public int[][] equivClasses(int classSize) {
    int[][] equivClasses = new int[modulus][classSize];
    for (int i = 0; i < modulus; i++) {
      int negativeMembers = classSize / 2;
      for (int j = 0; j < classSize; j++) {
        equivClasses[i][j] = -(negativeMembers * modulus) + i + j * modulus;
      }
    }
    return equivClasses;
  }

  public boolean isCongruent(int a, int b) {
    return (a - b) % modulus == 0;
  }

  public boolean isCongruent(int... args) {
    if (ArrayUtils.isEmpty(args)) {
      throw new IllegalArgumentException(ARGUMENT_ARRAY_IS_EMPTY);
    }
    for (int i = 1, len = args.length; i < len; i++) {
      if ((args[i - 1] - args[i]) % modulus != 0) {
        return false;
      }
    }
    return true;
  }

  public int add(int a, int b) {
    return (int) (((long) a + b) % modulus);
  }

  public int add(int... args) {
    if (ArrayUtils.isEmpty(args)) {
      throw new IllegalArgumentException(ARGUMENT_ARRAY_IS_EMPTY);
    }
    long sum = 0;
    for (int x : args) {
      sum += x;
    }
    return (int) sum % modulus;
  }

  public int sub(int a, int b) {
    return (int) (((long) a - b) % modulus);
  }

  public int sub(int... args) {
    if (ArrayUtils.isEmpty(args)) {
      throw new IllegalArgumentException(ARGUMENT_ARRAY_IS_EMPTY);
    }
    long diff = 0;
    for (int x : args) {
      diff -= x;
    }
    return (int) diff % modulus;
  }

  public int mul(int a, int b) {
    return (int) ((long) a * b % modulus);
  }

  public int mul(int... args) {
    if (ArrayUtils.isEmpty(args)) {
      throw new IllegalArgumentException(ARGUMENT_ARRAY_IS_EMPTY);
    }
    long prod = 1;
    for (int x : args) {
      prod *= x;
    }
    return (int) prod % modulus;
  }

  /**
   * Multiplicative inverse of argument using Extended Euclidean Algorithm because of division is
   * not defined in modular arithmetic.
   *
   * @param a argument
   * @return multiplicative inverse of a mod(m)
   */
  public int mulInv(int a) throws OperationException {
    return ExtendedEuclideanAlgorithm.mulInv(a, modulus);
  }


  /**
   * Mod operation a%modulus=r where a%m in [-m+1,m-1]
   *
   * @param a integer
   * @return residue of mod operation: a%modulus=r
   */
  public int mod(int a) {
    return a % modulus;
  }

  /**
   * Convert to positive residue , r < 0 ? r + m : r
   *
   * @param r residue mod modulus
   * @return Positive residue r>0 in mod m.
   */
  public int pos(int r) {
    return CommonResidue.convert(r, modulus);
  }

  /**
   * Mod operation with positive residue as output.
   *
   * @param a integer
   * @return positive residue of mod operation. a mod m=r , r>=0
   */
  public int commonResidue(int a) {
    return CommonResidue.mod(a, modulus);
  }

  /**
   * Exponentiation using square-multiply method.
   *
   * @param base     base
   * @param exponent exponent
   * @return base^exponent (mod modulus)
   */
  public long exp(int base, int exponent) {
    return ModExp.squareMultiply(base, exponent, modulus);
  }

  /**
   * Prone to discrete log problem
   *
   * @param base  base
   * @param value base^exponent (mod modulus)
   * @return log(base ^ exponent) mod(modulus) = exponent (mod modulus)
   */
  public long log(int base, int value) {
    return ModLog.log(base, value, modulus);
  }


}

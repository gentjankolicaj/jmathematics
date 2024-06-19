package io.jmathematics.modular;


import io.jmathematics.algorithm.ExtendedEuclideanAlgorithm;
import io.jmathematics.exception.OperationException;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;

@Slf4j
public class ModLong {

  public static final String ARGUMENT_ARRAY_IS_EMPTY = "Argument array is empty.";
  private final long modulus;
  private final ResidueSystem residueSystem;

  public ModLong(long modulus) {
    this.modulus = modulus;
    this.residueSystem = ResidueSystem.LEAST;
  }


  public long residueSystemSize() {
    return modulus;
  }

  public long[] residueSystem() {
    log.warn(
        "Modulus of type long '{}', casted to int '{}' because java doesn't support array index of type long.Not all residue classes are present !!!",
        modulus, (int) modulus);
    return Arrays.stream(residueSystem.residueSystem((int) modulus)).asLongStream().toArray();
  }


  /**
   * All equivalence classes of modulus with number of elements=classSize
   *
   * @param classSize equivalence class size
   * @return equivalent classes
   */
  public long[][] equivClasses(int classSize) {
    long[][] equivClasses = new long[(int) modulus][classSize];
    for (int i = 0; i < modulus; i++) {
      long negativeMembers = classSize / 2;
      for (int j = 0; j < classSize; j++) {
        equivClasses[i][j] = -(negativeMembers * modulus) + i + j * modulus;
      }
    }
    return equivClasses;
  }

  public boolean isCongruent(long a, long b) {
    return (a - b) % modulus == 0;
  }

  public boolean isCongruent(long... args) {
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

  public long add(long a, long b) {
    return (a + b) % modulus;
  }

  public long add(long... args) {
    if (ArrayUtils.isEmpty(args)) {
      throw new IllegalArgumentException(ARGUMENT_ARRAY_IS_EMPTY);
    }
    long sum = 0;
    for (long x : args) {
      sum += x;
    }
    return sum % modulus;
  }

  public long sub(long a, long b) {
    return (a - b) % modulus;
  }

  public long sub(long... args) {
    if (ArrayUtils.isEmpty(args)) {
      throw new IllegalArgumentException(ARGUMENT_ARRAY_IS_EMPTY);
    }
    long diff = 0;
    for (long x : args) {
      diff -= x;
    }
    return diff % modulus;
  }

  public long mul(long a, long b) {
    return (a * b) % modulus;
  }

  public long mul(long... args) {
    if (ArrayUtils.isEmpty(args)) {
      throw new IllegalArgumentException(ARGUMENT_ARRAY_IS_EMPTY);
    }
    long prod = 1;
    for (long x : args) {
      prod *= x;
    }
    return prod % modulus;
  }

  /**
   * Multiplicative Inverse of argument using Extended Euclidean Algorithm because of division is
   * not defined in modular arithmetic.
   *
   * @param a argument
   * @return multiplicative inverse of a mod(m)
   */
  public long mulInv(long a) throws OperationException {
    return ExtendedEuclideanAlgorithm.mulInv(a, modulus);
  }


  /**
   * Mod operation a%modulus=r where a%m in [-m+1,m-1]
   *
   * @param a integer
   * @return residue of mod operation: a%modulus=r
   */
  public long mod(long a) {
    return a % modulus;
  }

  /**
   * Convert to positive residue , r < 0 ? r + m : r
   *
   * @param r residue mod modulus
   * @return Positive residue r>0 in mod m.
   */
  public long pos(long r) {
    return CommonResidue.convert(r, modulus);
  }

  /**
   * Mod operation with positive residue as output.
   *
   * @param a integer
   * @return positive residue of mod operation. a mod m=r , r>=0
   */
  public long commonResidue(long a) {
    return CommonResidue.mod(a, modulus);
  }

  /**
   * Exponentiation using square-multiply method.
   *
   * @param base     base
   * @param exponent exponent
   * @return base^exponent (mod modulus)
   */
  public long exp(long base, long exponent) {
    return ModExp.squareMultiply(base, exponent, modulus);
  }

  /**
   * Prone to discrete log problem
   *
   * @param base  base
   * @param value base^exponent (mod modulus)
   * @return log(base ^ exponent) mod(modulus) = exponent (mod modulus)
   */
  public long log(long base, long value) {
    return ModLog.log(base, value, modulus);
  }

}

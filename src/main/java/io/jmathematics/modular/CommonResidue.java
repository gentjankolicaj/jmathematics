package io.jmathematics.modular;

/**
 * Implementation of some util methods for <a
 * href="https://mathworld.wolfram.com/CommonResidue.html">Common Residue</a>, meaning residues r >
 * 0.
 */
public interface CommonResidue {


  /**
   * Converts to positive residue.
   *
   * @param r residue
   * @param m modulus
   * @return positive residue
   */
  static int convert(int r, int m) {
    return r < 0 ? r + m : r;
  }

  /**
   * Converts to positive residue.
   *
   * @param r residue
   * @param m modulus
   * @return positive residue
   */
  static long convert(long r, long m) {
    return r < 0 ? r + m : r;
  }


  /**
   * Mod operation avoiding negative residues
   *
   * @param x integer
   * @param m modulus
   * @return positive residue of mod operation. x mod m=r , r>=0
   */
  static int mod(int x, int m) {
    return (x % m + m) % m;
  }

  /**
   * Mod operation avoiding negative residues
   *
   * @param x integer
   * @param m modulus
   * @return positive residue of mod operation. x mod m=r , r>=0
   */
  static long mod(long x, long m) {
    return (x % m + m) % m;
  }


}

package io.jmathematics;

public interface DivisionOp {


  static long floor(long a, long b) {
    return a - b * (long) Math.floor((double) a / b);
  }

  static long truncate(long a, long b) {
    return a - b * (long) Math.ceil((double) a / b);
  }

}

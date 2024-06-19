package io.jmathematics.random;

import java.security.SecureRandom;

public class CommonRandom {

  private static final SecureRandom secureRandom = new SecureRandom();


  public static int secure(int min, int max) {
    return min + secureRandom.nextInt(max);
  }

  public static long secure(long min, long max) {
    long rand = secureRandom.nextLong();
    if (rand >= min) {
      if (rand - max > 0) {
        return rand;
      }
      if (rand - max < 0) {
        return (max - rand > min) ? max - rand : max - rand + min;
      }
      return secure(min, max);
    } else {
      return rand + min;
    }
  }

}

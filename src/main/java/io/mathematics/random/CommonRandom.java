package io.mathematics.random;

import java.security.SecureRandom;

public class CommonRandom {

  private static final SecureRandom secureRandom = new SecureRandom();


  public static int secure(int min, int max) {
    return min + secureRandom.nextInt(max);
  }

}

package io.mathematics.modular;

public enum ResidueSystem {

  LEAST {
    @Override
    public int[] residueClasses(int modulus) {
      int[] residueClasses = new int[modulus];
      for (int i = 0; i < modulus; i++) {
        residueClasses[i] = i;
      }
      return residueClasses;
    }

  },
  COMPLETE {
    @Override
    public int[] residueClasses(int modulus) {
      int[] residueClasses = new int[modulus];
      for (int i = 1; i <= modulus; i++) {
        residueClasses[i - 1] = i;
      }
      return residueClasses;
    }
  };

  public abstract int[] residueClasses(int modulus);
}

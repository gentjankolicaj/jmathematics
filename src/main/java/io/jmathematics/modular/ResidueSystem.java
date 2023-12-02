package io.jmathematics.modular;

public enum ResidueSystem {

  LEAST {
    @Override
    public int[] residueSystem(int modulus) {
      int[] residueClasses = new int[modulus];
      for (int i = 0; i < modulus; i++) {
        residueClasses[i] = i;
      }
      return residueClasses;
    }

  },
  COMPLETE {
    @Override
    public int[] residueSystem(int modulus) {
      int[] residueClasses = new int[modulus];
      for (int i = 1; i <= modulus; i++) {
        residueClasses[i - 1] = i;
      }
      return residueClasses;
    }
  };

  public abstract int[] residueSystem(int modulus);
}

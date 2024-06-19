package io.jmathematics.prime;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class PrimalityTest {

  @Test
  void trialDivision() {
    assertThat(Primality.trialDivision(17)).isTrue();
    assertThat(Primality.trialDivision(17L)).isTrue();
    assertThat(Primality.trialDivision(1)).isFalse();
    assertThat(Primality.trialDivision(1L)).isFalse();
    assertThat(Primality.trialDivision(2)).isTrue();
    assertThat(Primality.trialDivision(2L)).isTrue();
  }

  @Test
  void fermat() {
    assertThat(Primality.fermat(3671, 100)).isGreaterThan(0.5);
    assertThat(Primality.fermat(3671)).isGreaterThan(0.5);
    assertThat(Primality.fermat(3672, 100)).isLessThan(0.1);
  }

  @Test
  void millerRabin() {
    assertThat(Primality.millerRabin(561, 39)).isLessThan(0.1);
    assertThat(Primality.millerRabin(563, 39)).isGreaterThan(0.5);
    assertThat(Primality.millerRabin(3671, 39)).isGreaterThan(0.5);
    assertThat(Primality.millerRabin(3672, 39)).isLessThan(0.1);
  }
}
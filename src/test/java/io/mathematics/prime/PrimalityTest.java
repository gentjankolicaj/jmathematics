package io.mathematics.prime;


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
    assertThat(Primality.fermat(3671, 10000)).isEqualTo(1);
    assertThat(Primality.fermat(3672, 10000)).isEqualTo(0);
  }
}
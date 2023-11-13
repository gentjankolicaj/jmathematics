package io.jmathematics.prime;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CompositenessTest {

  @Test
  void fermat() {
    assertThat(Compositeness.fermat(3671, 100)).isZero();
    assertThat(Compositeness.fermat(3672, 100)).isEqualTo(1);
  }

  @Test
  void millerRabin() {
    assertThat(Compositeness.millerRabin(3671, 10)).isZero();
    assertThat(Compositeness.millerRabin(3672, 10)).isEqualTo(1);
    assertThat(Compositeness.millerRabin(561, 10)).isEqualTo(1);
    assertThat(Compositeness.millerRabin(563, 10)).isZero();
  }
}
package io.jmathematics.prime;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CompositenessTest {

  @Test
  void fermat() {
    assertThat(Compositeness.fermat(3671, 100)).isLessThan(0.1);
    assertThat(Compositeness.fermat(3672, 100)).isGreaterThan(0.5);
  }

  @Test
  void millerRabin() {
    assertThat(Compositeness.millerRabin(3671, 10)).isLessThan(0.1);
    assertThat(Compositeness.millerRabin(3672, 10)).isGreaterThan(0.5);
    assertThat(Compositeness.millerRabin(561, 10)).isGreaterThan(0.5);
    assertThat(Compositeness.millerRabin(563, 10)).isLessThan(0.1);
  }
}
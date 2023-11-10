package io.mathematics.prime;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CompositenessTest {

  @Test
  void fermat() {
    assertThat(Compositeness.fermat(3671, 10000)).isEqualTo(0);
    assertThat(Compositeness.fermat(3672, 10000)).isEqualTo(1);
  }
}